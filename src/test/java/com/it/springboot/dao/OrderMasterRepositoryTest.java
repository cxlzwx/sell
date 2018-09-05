package com.it.springboot.dao;

import com.it.springboot.pojo.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by sunrise on 2018/9/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository masterRepository;

    @Test
    public void save(){
        OrderMaster master = new OrderMaster("32145","程序员3","12312312312","杭州西湖","11111",new BigDecimal(22.0),0,0);
        OrderMaster orderMaster = masterRepository.save(master);
        Assert.assertNotNull(orderMaster);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {
        PageRequest request = new PageRequest(0, 3);
        Page<OrderMaster> page = masterRepository.findByBuyerOpenid("ew3euwhd7sjw9diwkq", request);
        Assert.assertNotEquals(0,page.getContent());

    }

}