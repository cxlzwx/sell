package com.it.springboot.service.impl;

import com.it.springboot.pojo.ProductInfo;
import com.it.springboot.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sunrise on 2018/9/3.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
    @Autowired
    ProductService info;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> upAll = info.findUpAll();
        Assert.assertNotNull(upAll);
    }

    @Test
    public void findAll() throws Exception {
        Page<ProductInfo> page = info.findAll(new PageRequest(0, 2));
        Assert.assertNotNull(page);
    }

    @Test
    public void save() throws Exception {
        ProductInfo productInfo = new ProductInfo("654321","连衣裙", new BigDecimal(200.0), 200, "好看", "http://xxx.jpg", 0, 2);
        ProductInfo info = this.info.save(productInfo);
        Assert.assertNotNull(info);
    }

    @Test
    public void findByProductId() throws Exception {
        ProductInfo productInfo = info.findByProductId("123456");
        Assert.assertNotNull(productInfo);
    }

}