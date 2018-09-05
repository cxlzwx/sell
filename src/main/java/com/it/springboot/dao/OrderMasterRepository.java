package com.it.springboot.dao;/**
 * Created by sunrise on 2018/9/4.
 */

import com.it.springboot.pojo.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName OrderMasterRepository
 * @Description 订单dao
 * @Author sunrise
 * @Date 2018/9/4 14:31
 * @Version 1.0
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String>{

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
