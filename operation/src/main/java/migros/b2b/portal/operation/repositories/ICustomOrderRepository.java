package migros.b2b.portal.operation.repositories;


import migros.b2b.portal.operation.entities.Order;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ICustomOrderRepository {
    List<Order> getOrderByCriteria(String id, Date startDate, Date endDate) throws ParseException;
}
