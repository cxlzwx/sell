package com.it.springboot.web.controller;/**
 * Created by sunrise on 2018/9/3.
 */

import com.it.springboot.pojo.ProductCategory;
import com.it.springboot.pojo.ProductInfo;
import com.it.springboot.service.CategoryService;
import com.it.springboot.service.ProductService;
import com.it.springboot.utils.ResultUtil;
import com.it.springboot.vo.ProductInfoVO;
import com.it.springboot.vo.ProductVO;
import com.it.springboot.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName BuyerProductController
 * @Description 商品控制器
 * @Author sunrise
 * @Date 2018/9/3 19:12
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/buyer")
public class BuyerProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/product/list")
    public Result<List> productList(){
        //1.查询所有上架商品
        List<ProductInfo> upAll = productService.findUpAll();
        //2.查询商品的类目
//        List<Integer> categoryTypes = new ArrayList<>();
//        for (ProductInfo productInfo : upAll) {
//            categoryTypes.add(productInfo.getCategoryType());
//        }
        //java8的方式
        List<Integer> categoryTypes = upAll.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());
        //查询所有类目
        List<ProductCategory> productCategories = categoryService.findAllByCategoryTypeIsIn(categoryTypes);

        //数据封装
        //创建productVOS对象用来赋值data
        List<ProductVO> productVOS = new ArrayList<>();
        //创建productVO对象赋值给foots

        for (ProductCategory productCategory : productCategories) {
            ProductVO productVO = new ProductVO();
            productVO.setName(productCategory.getCategoryName());
            productVO.setType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOS =new ArrayList<>();
            for (ProductInfo productInfo : upAll) {
                //遍历上架商品数据赋值给productinfoVO
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    //将productInfo对象添加到producVO对象中
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setFoods(productInfoVOS);
            productVOS.add(productVO);
        }

       return ResultUtil.success(productVOS);
    }
}















