package com.it.springboot.service;

import com.it.springboot.dto.CartDTO;
import com.it.springboot.dto.OrderMasterDTO;
import com.it.springboot.pojo.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by sunrise on 2018/9/3.
 */
public interface ProductService {

    /*
    查询上架商品
     */
    List<ProductInfo> findUpAll();

    /*
    查询所有商品,分页
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /*
    保存商品信息
     */
    ProductInfo save(ProductInfo productInfo);

    /*
    根据商品id查询商品
     */
    ProductInfo findByProductId(String productId);

    //加库存
    void increaseStock(List<CartDTO> cartDTOS);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOS);
}







