package com.it.springboot.service.impl;

import com.it.springboot.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sunrise on 2018/9/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findAll() throws Exception {
        List<ProductCategory> categoryList = categoryService.findAll();
        Assert.assertNotEquals(0,categoryList.size());
    }

    @Test
    public void findByCatogoryId() throws Exception {
        ProductCategory productCategory = categoryService.findByCatogoryId(2);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findAllByCategoryTypeIsIn() throws Exception {
        List<ProductCategory> categories = categoryService.findAllByCategoryTypeIsIn(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertNotEquals(0,categories.size());
    }

    @Test
    public void save() throws Exception {
        ProductCategory productCategory = new ProductCategory("时尚百搭", 2);;
        ProductCategory category = categoryService.save(productCategory);
        Assert.assertNotNull(category);
    }

}