package com.it.springboot.dao;

import com.it.springboot.pojo.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by sunrise on 2018/9/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> category = repository.findById(1);
        System.out.println(category.toString());
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("男生最爱", 4);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null, result);
    }

    @Test
    public void updateTest(){
        Optional<ProductCategory> category = repository.findById(1);
        ProductCategory productCategory = category.get();
        productCategory.setCategoryName("时尚休闲");
        repository.save(productCategory);
    }
    @Test
    public void findeAllByCategoryType(){
        List<ProductCategory> categories = repository.findAllByCategoryTypeIsIn(Arrays.asList(2, 4));
        Assert.assertNotNull(categories);
    }


}