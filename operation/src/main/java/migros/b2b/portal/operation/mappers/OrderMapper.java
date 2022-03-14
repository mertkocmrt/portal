package migros.b2b.portal.operation.mappers;

import migros.b2b.portal.model.common.ResponseMessages;
import migros.b2b.portal.model.requests.OrderRequest;
import migros.b2b.portal.model.responses.OrderResponse;
import migros.b2b.portal.operation.entities.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public OrderMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Order dtoToEntity(OrderRequest orderRequest) {
        Order order =  modelMapper.map(orderRequest, Order.class);
        order.setStatus(ResponseMessages.SUCCESSFUL_ORDER);
        return order;
    }

    public OrderResponse entityToResponse(Order order) {
        OrderResponse orderResponse = order != null ? modelMapper.map(order, OrderResponse.class) : new OrderResponse();
        orderResponse.setResponseMessage(ResponseMessages.THANK_YOU);
        return orderResponse;
    }
}
