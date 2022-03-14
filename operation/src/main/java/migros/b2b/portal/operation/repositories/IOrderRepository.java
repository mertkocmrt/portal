package migros.b2b.portal.operation.repositories;

import migros.b2b.portal.operation.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends MongoRepository<Order,String> {
    Page<Order> findByCustomer(String email, Pageable pageable);
}
