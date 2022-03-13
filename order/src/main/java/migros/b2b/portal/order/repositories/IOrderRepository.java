package migros.b2b.portal.order.repositories;

import migros.b2b.portal.model.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends MongoRepository<Order,String> {
}
