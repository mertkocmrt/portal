package migros.b2b.portal.operation.repositories.impl;

import migros.b2b.portal.operation.entities.Order;
import migros.b2b.portal.operation.repositories.ICustomOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class CustomOrderRepository implements ICustomOrderRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomOrderRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Order> getOrderByCriteria(String id, Date startDate, Date endDate) throws ParseException {
        final Query query = new Query();
        if(id != null) {
            query.addCriteria(Criteria.where("_id").is(id));
        }
        if(startDate != null || endDate != null){
         query.addCriteria(Criteria.where("orderDate").gt(startDate!=null?startDate: LocalDate.parse("1900-01-01")).lt(endDate!=null?endDate:LocalDate.now()));
        }
        return mongoTemplate.find(query, Order.class);
    }
}
