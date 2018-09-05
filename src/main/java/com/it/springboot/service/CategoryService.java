package com.it.springboot.service;

import com.it.springboot.pojo.ProductCategory;

import java.util.List;

/**
 * Created by sunrise on 2018/9/3.
 */
public interface CategoryService {
    List<ProductCategory> findAll();
    ProductCategory findByCatogoryId(Integer catorgoryId);
    List<ProductCategory> findAllByCategoryTypeIsIn(List<Integer> catogroyIds);
    ProductCategory save(ProductCategory productCategory);

}
