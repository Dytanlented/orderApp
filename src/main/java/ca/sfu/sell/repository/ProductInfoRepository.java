package ca.sfu.sell.repository;

import ca.sfu.sell.dataobject.ProductInfo;
import ca.sfu.sell.enums.ProductStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
