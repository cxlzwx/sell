package com.it.springboot.web.controller;/**
 * Created by sunrise on 2018/9/5.
 */

import com.it.springboot.dto.OrderMasterDTO;
import com.it.springboot.enums.ResultEnum;
import com.it.springboot.exception.SellException;
import com.it.springboot.form.OrderForm;
import com.it.springboot.service.BuyerService;
import com.it.springboot.service.OrderMasterService;
import com.it.springboot.service.impl.BuyerServiceImpl;
import com.it.springboot.utils.OrderForm2OrderMasterDTOConverter;
import com.it.springboot.utils.ResultUtil;
import com.it.springboot.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BuyerOrderController
 * @Description TODO
 * @Author sunrise
 * @Date 2018/9/5 14:22
 * @Version 1.0
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    OrderMasterService orderMasterService;

    @Autowired
    BuyerService buyerService;

    //创建订单
    @RequestMapping("/create")
    public Result<Map<String,String>> creatOrder(@Valid OrderForm orderForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】 参数不正确"+orderForm);
            throw new SellException(ResultEnum.ORDER_FORM_ERROR,bindingResult.getFieldError().getDefaultMessage());
        }
        OrderMasterDTO converter = OrderForm2OrderMasterDTOConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(converter.getOrderDetails())){
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.cart_isempty_error);
        }

        orderMasterService.create(converter);
        Map<String, String> objectHashMap = new HashMap<>();
        objectHashMap.put("orderId",converter.getOrderId());
        return ResultUtil.success(objectHashMap);

    }

    //订单列表
    @GetMapping("/list")
    public Result<List<OrderMasterDTO>> orderList(@RequestParam(value = "openid") String openid,
                                  @RequestParam(value = "page",defaultValue = "0")Integer page,
                                  @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单】 openID为空");
            throw new SellException(ResultEnum.ORDER_FORM_ERROR);
        }

        PageRequest pageRequest = new PageRequest(page, size);
        Page<OrderMasterDTO> masterDTOS = orderMasterService.findList(openid, pageRequest);
        List<OrderMasterDTO> masterDTOSContent = masterDTOS.getContent();
        return ResultUtil.success(masterDTOSContent);
    }

    //查询订单详情
    @GetMapping("/detail")
    public Result<OrderMasterDTO> findDatail(@RequestParam("openid") String openid,
                                              @RequestParam("orderId") String orderId){
        OrderMasterDTO masterDTO = buyerService.findOneOrder(openid, orderId);
        return ResultUtil.success(masterDTO);
    }

    //取消订单
    @PostMapping("/cancel")
    public Result<OrderMasterDTO> Cancel(@RequestParam("openid") String openid,
                                             @RequestParam("orderId") String orderId){
        buyerService.canceOneOrder(openid, orderId);
        return  ResultUtil.success();

    }

}
