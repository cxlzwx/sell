package com.it.springboot.dao;

import com.it.springboot.pojo.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Locale;

/*
 *@ClassName ProductCategoryRepository
 *@Description 商品类目dao
 *@Author Sunrise
 *@Date 2018/9/3 14:14
 *@Version 1.0
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    List<ProductCategory> findAllByCategoryTypeIsIn(List<Integer> categoryType);
}
