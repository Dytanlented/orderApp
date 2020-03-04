package ca.sfu.sell.service;

import ca.sfu.sell.dataobject.ProductInfo;
import ca.sfu.sell.dto.CartDTO;
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
    void increaseStock(List<CartDTO> cartDTOList);

    //Subtract stock
    void decreaseStock(List<CartDTO> cartDTOList);
}
