package com.it.springboot.service.impl;/**
 * Created by sunrise on 2018/9/4.
 */

import com.it.springboot.dao.OrderDetailRepository;
import com.it.springboot.dao.OrderMasterRepository;
import com.it.springboot.dto.CartDTO;
import com.it.springboot.dto.OrderMasterDTO;
import com.it.springboot.enums.OrderStatusEnum;
import com.it.springboot.enums.PayStatusEnum;
import com.it.springboot.enums.ResultEnum;
import com.it.springboot.exception.SellException;
import com.it.springboot.pojo.OrderDetail;
import com.it.springboot.pojo.OrderMaster;
import com.it.springboot.pojo.ProductInfo;
import com.it.springboot.service.OrderMasterService;
import com.it.springboot.service.ProductService;
import com.it.springboot.utils.KeyUtils;
import com.it.springboot.utils.OrderMaster2OrderMasterDTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName OrderMasterServiceImpl
 * @Description 订单业务层
 * @Author sunrise
 * @Date 2018/9/4 15:46
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    ProductService productService;

    @Autowired
    OrderDetailRepository detailRepository;

    @Autowired
    OrderMasterRepository masterRepository;

    @Override
    @Transactional
    public OrderMasterDTO create(OrderMasterDTO orderMasterDTO) {

        //生成订单id
        String orderId = KeyUtils.getKey();

        //订单总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

//        List<CartDTO> cartDTOS = new ArrayList<>();
        //查询商品
        List<OrderDetail> details = orderMasterDTO.getOrderDetails();
        for (OrderDetail detail : details) {
            //获得对应的商品信息
            ProductInfo productInfo = productService.findByProductId(detail.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //计算价格
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(detail.getProductQuantity())).add(orderAmount);
            //订单详情
            detail.setDetailId(KeyUtils.getKey());
            detail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,detail);
            //写入orderdetail
            detailRepository.save(detail);


//            CartDTO cartDTO = new CartDTO(detail.getProductId(), detail.getProductQuantity());
//            cartDTOS.add(cartDTO);

        }

        //写入订单到数据库（ordermaster，orderdetail）
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderMasterDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        masterRepository.save(orderMaster);

        //扣库存
        List<CartDTO> cartDTOS = details.stream().map(e -> new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());

        productService.decreaseStock(cartDTOS);

        return orderMasterDTO;
    }

    @Override
    public Page<OrderMasterDTO> findList(String buyerOpenid,Pageable pageable) {
        Page<OrderMaster> orderMasters = masterRepository.findByBuyerOpenid(buyerOpenid, pageable);

        List<OrderMasterDTO> orderMasterDTOS = OrderMaster2OrderMasterDTOConverter.converter(orderMasters.getContent());

        PageImpl<OrderMasterDTO> page =
                new PageImpl<>(orderMasterDTOS,pageable,orderMasters.getTotalElements());

        return page;
    }

    @Override
    public OrderMasterDTO findOne(String orderId) {
        //查询订单
        OrderMaster orderMaster = masterRepository.findById(orderId).get();
        if (StringUtils.isEmpty(orderMaster)){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //查询订单详情列表
        List<OrderDetail> orderDetails = detailRepository.findByOrderId(orderId);
        if (orderDetails.size()<1){
            throw new SellException(ResultEnum.ORDERDETAIL_NOT_EXIST);
        }
        OrderMasterDTO orderMasterDTO = new OrderMasterDTO();
        BeanUtils.copyProperties(orderMaster,orderMasterDTO);
        orderMasterDTO.setOrderDetails(orderDetails);
        return orderMasterDTO;
    }

    @Override
    @Transactional
    public OrderMasterDTO cancel(OrderMasterDTO orderMasterDTO) {
        OrderMaster orderMaster = new OrderMaster();

        //判断订单状态
        if(!orderMasterDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【取消订单】订单状态不正确 "+orderMasterDTO.getOrderId()+orderMasterDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        BeanUtils.copyProperties(orderMasterDTO,orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        OrderMaster updateResult = masterRepository.save(orderMaster);
        if (updateResult==null){
            log.error("【修改订单】 修改失败"+ orderMaster);
            throw new SellException(ResultEnum.ORDERMASTER_UPDATE_ERROR);
        }
        //返还库存
        if (orderMasterDTO.getOrderDetails().size()<=0){
            log.error("【返还库存】修改库存失败"+orderMasterDTO);
            throw  new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }

        List<CartDTO> cartDTOS =  orderMasterDTO.getOrderDetails().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(cartDTOS);

        //如果已经支付,退款
        if (orderMasterDTO.getPayStatus().equals(PayStatusEnum.SUCCECC.getCode())){
            //TODO
        }
        return orderMasterDTO;
    }

    @Override
    public OrderMasterDTO finish(OrderMasterDTO orderMasterDTO) {
        return  null;
    }

    @Override
    public OrderMasterDTO paid(OrderMasterDTO orderMasterDTO) {
        return null;
    }
}
