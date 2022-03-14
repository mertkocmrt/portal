package migros.b2b.portal.operation.repositories;

import migros.b2b.portal.operation.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepository  extends MongoRepository<Customer,String> {
}
