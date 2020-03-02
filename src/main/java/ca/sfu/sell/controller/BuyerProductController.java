package ca.sfu.sell.controller;


import ca.sfu.sell.VO.ProductInfoVO;
import ca.sfu.sell.VO.ProductVO;
import ca.sfu.sell.VO.ResultVO;
import ca.sfu.sell.dataobject.ProductCategory;
import ca.sfu.sell.dataobject.ProductInfo;
import ca.sfu.sell.service.CategoryService;
import ca.sfu.sell.service.ProductService;
import ca.sfu.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {
        //1. search items available
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. search category(one time)

        //traditional way
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for(ProductInfo productInfo : productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //clean code(java 8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory>  productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }


        return ResultVOUtil.success(productVOList);
    }
}
