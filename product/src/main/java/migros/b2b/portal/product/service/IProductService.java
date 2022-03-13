package migros.b2b.portal.product.service;

import migros.b2b.portal.model.entities.OrderProduct;
import migros.b2b.portal.model.entities.Product;
import migros.b2b.portal.model.requests.ProductRequest;
import migros.b2b.portal.model.responses.ProductResponse;

import java.util.List;

public interface IProductService {

    Product getProduct(String id);

    void updateProducts(List<ProductRequest> productOrders);
}
