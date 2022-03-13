package migros.b2b.portal.product.repositories;

import migros.b2b.portal.model.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository  extends MongoRepository<Product,String> {
}
