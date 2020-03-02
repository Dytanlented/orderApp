package ca.sfu.sell.service;

import ca.sfu.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);


    /**
     * Find all products in stock
     *
     */

    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //Add stock


    //Subtract stock
}