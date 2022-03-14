package migros.b2b.portal.operation.mappers;

import migros.b2b.portal.model.common.ResponseMessages;
import migros.b2b.portal.model.responses.CustomerOrdersResponse;
import migros.b2b.portal.model.responses.OrderResponse;
import migros.b2b.portal.operation.entities.Customer;
import migros.b2b.portal.operation.entities.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerOrdersMapper {
    private final ModelMapper modelMapper;
    private final OrderMapper orderMapper;

    @Autowired
    public CustomerOrdersMapper(ModelMapper modelMapper, OrderMapper orderMapper){
        this.modelMapper = modelMapper;
        this.orderMapper = orderMapper;
    }

    public CustomerOrdersResponse mapToCustomerOrdersResponse(Customer customer, List<Order> orders) {

        List<OrderResponse> orderResponseList = orders.stream().map(order -> orderMapper.entityToResponse(order)).collect(Collectors.toList());

        CustomerOrdersResponse customerOrdersResponse = new CustomerOrdersResponse();
        customerOrdersResponse.setOrders(orderResponseList);
        customerOrdersResponse.setAddress(customer.getAddress());
        customerOrdersResponse.setEmail(customer.getEmail());
        customerOrdersResponse.setAddress(customer.getAddress());

        customerOrdersResponse.setResponseMessage(ResponseMessages.CUSTOMER_ORDERS);
        return customerOrdersResponse;
    }
}
