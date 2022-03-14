package migros.b2b.portal.operation.services;

import migros.b2b.portal.model.requests.OrderRequest;
import migros.b2b.portal.model.responses.OrderResponse;
import migros.b2b.portal.operation.entities.Order;
import migros.b2b.portal.operation.mappers.OrderMapper;
import migros.b2b.portal.operation.repositories.IOrderRepository;
import migros.b2b.portal.operation.services.impl.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderServicesTests {
    @InjectMocks
    OrderService orderService;
    @Mock
    private IOrderRepository orderRepository;
    @Mock
    private IProductService productService;
    @Mock
    private OrderMapper orderMapper;

    @Test
    public void addOrderTest()
    {
        OrderRequest orderRequest = OrderRequest.builder().customer("customer").build();
        Order order = Order.builder().customer("customer").build();
        OrderResponse orderResponse = OrderResponse.builder().customer("customer").build();
        given(orderMapper.dtoToEntity(orderRequest)).willReturn(order);
        given(orderRepository.insert(order)).willReturn(order);
        given(orderMapper.entityToResponse(order)).willReturn(orderResponse);

        OrderResponse returnedProductResponse = orderService.addOrder(orderRequest);
        assertThat(returnedProductResponse).isNotNull();
        verify(orderRepository).insert(any(Order.class));
    }
}
