package migros.b2b.portal.operation.repositories;

import migros.b2b.portal.operation.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRepository  extends MongoRepository<Product,String> {
}
