package migros.b2b.portal.operation.services;

import migros.b2b.portal.model.requests.OrderRequest;
import migros.b2b.portal.model.responses.CustomerOrdersResponse;
import migros.b2b.portal.model.responses.OrderResponse;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IOrderService {
    OrderResponse addOrder(OrderRequest orderRequest);
    List<OrderResponse> getOrdersByCriteria(String id, Date startDate, Date endDate) throws ParseException;

    CustomerOrdersResponse getCustomerOrders(String email, Integer page, Integer size);

    void cancelOrder(String id);
}
