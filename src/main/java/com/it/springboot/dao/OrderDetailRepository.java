package com.it.springboot.dao;/**
 * Created by sunrise on 2018/9/4.
 */

import com.it.springboot.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName OrderDetailRepository
 * @Description 订单详情dao
 * @Author sunrise
 * @Date 2018/9/4 14:36
 * @Version 1.0
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{
        List<OrderDetail> findByOrderId(String orderId);

}






