package migros.b2b.portal.operation.services;

import migros.b2b.portal.model.requests.ProductRequest;
import migros.b2b.portal.operation.entities.Product;

import java.util.List;

public interface IProductService {

    Product getProduct(String id);

    void updateProducts(List<ProductRequest> productOrders);
}
