package com.it.springboot.dao;/**
 * Created by sunrise on 2018/9/3.
 */

import com.it.springboot.pojo.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName ProductInfoRepository
 * @Description 商品dao
 * @Author sunrise
 * @Date 2018/9/3 17:23
 * @Version 1.0
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
