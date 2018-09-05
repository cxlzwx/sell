package com.it.springboot.service.impl;/**
 * Created by sunrise on 2018/9/3.
 */

import com.it.springboot.dao.ProductInfoRepository;
import com.it.springboot.dto.CartDTO;
import com.it.springboot.enums.ProductStatusEnum;
import com.it.springboot.enums.ResultEnum;
import com.it.springboot.exception.SellException;
import com.it.springboot.pojo.ProductInfo;
import com.it.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName ProductServiceImpl
 * @Description 查询商品信息实现类
 * @Author sunrise
 * @Date 2018/9/3 17:55
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository proinfo;

    @Override
    public List<ProductInfo> findUpAll() {
        List<ProductInfo> productInfoList =  proinfo.findByProductStatus(ProductStatusEnum.UP.getCode());
        return productInfoList;
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        Page<ProductInfo> page = proinfo.findAll(pageable);
        return page;
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return proinfo.save(productInfo);
    }

    @Override
    public ProductInfo findByProductId(String productId) {
        return  proinfo.findById(productId).get();
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO : cartDTOS) {
            ProductInfo productInfo = proinfo.findById(cartDTO.getProductId()).get();
            if (proinfo == null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int icon = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(icon);
            proinfo.save(productInfo);
        }

    }

    @Override
    public void decreaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO : cartDTOS) {
            ProductInfo productInfo = proinfo.findById(cartDTO.getProductId()).get();
            if (productInfo==null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            int icon = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (0>icon){
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(icon);
            proinfo.save(productInfo);
        }
    }
}
