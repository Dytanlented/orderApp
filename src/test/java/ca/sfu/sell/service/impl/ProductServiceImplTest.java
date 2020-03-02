package ca.sfu.sell.service.impl;

import ca.sfu.sell.dataobject.ProductInfo;
import ca.sfu.sell.enums.ProductStatusEnum;
import ca.sfu.sell.service.ProductService;
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


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("4399");
        Assert.assertEquals("4399",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }


    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();

        productInfo.setProductId("6666");
        productInfo.setProductName("串串");
        productInfo.setProductPrice(new BigDecimal(23.9));
        productInfo.setProductStock(0);
        productInfo.setProductDescription("自助");
        productInfo.setProductIcon("https://xxxd.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(6);

        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}