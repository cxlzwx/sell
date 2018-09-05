package com.it.springboot.service.impl;/**
 * Created by sunrise on 2018/9/3.
 */

import com.it.springboot.dao.ProductCategoryRepository;
import com.it.springboot.pojo.ProductCategory;
import com.it.springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * @ClassName CategoryServiceImpl
 * @Description 商品类目service
 * @Author sunrise
 * @Date 2018/9/3 14:42
 * @Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository pro;

    @Override
    public List<ProductCategory> findAll() {
        List<ProductCategory> proAll = pro.findAll();
        return proAll;
    }

    @Override
    public ProductCategory findByCatogoryId(Integer catorgoryId) {
        Optional<ProductCategory> category = pro.findById(catorgoryId);
        return category.get();
    }

    @Override
    public List<ProductCategory> findAllByCategoryTypeIsIn(List<Integer> catogroyIds) {
        List<ProductCategory> categoryList = pro.findAllByCategoryTypeIsIn(catogroyIds);
        return categoryList;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        ProductCategory category = pro.save(productCategory);
        return category;
    }
}
