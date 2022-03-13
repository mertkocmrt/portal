package migros.b2b.portal.order.services;

import migros.b2b.portal.model.requests.OrderRequest;
import migros.b2b.portal.model.responses.OrderResponse;

public interface IOrderService {
    OrderResponse addOrder(OrderRequest orderRequest);
}
