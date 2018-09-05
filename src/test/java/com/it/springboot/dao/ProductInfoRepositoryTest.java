package com.it.springboot.dao;

import com.it.springboot.pojo.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sunrise on 2018/9/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository repository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> infos = repository.findByProductStatus(0);
        Assert.assertNotNull(infos);
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo("123456","木桶饭", new BigDecimal(20.0), 200, "好吃", "http://xxx.jpg", 0, 2);
        ProductInfo info = repository.save(productInfo);

    }

}