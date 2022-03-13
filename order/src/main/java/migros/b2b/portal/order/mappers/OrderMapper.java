package migros.b2b.portal.order.mappers;

import migros.b2b.portal.model.common.ResponseMessages;
import migros.b2b.portal.model.entities.Order;
import migros.b2b.portal.model.requests.OrderRequest;
import migros.b2b.portal.model.responses.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderMapper {
    private ModelMapper modelMapper;

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
