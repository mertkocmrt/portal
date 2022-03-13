package migros.b2b.portal.order.services.impl;

import migros.b2b.portal.model.entities.Order;
import migros.b2b.portal.model.requests.OrderRequest;
import migros.b2b.portal.model.responses.OrderResponse;
import migros.b2b.portal.order.mappers.OrderMapper;
import migros.b2b.portal.order.repositories.IOrderRepository;
import migros.b2b.portal.order.services.IOrderService;
import migros.b2b.portal.product.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService implements IOrderService {
    private final OrderMapper orderMapper;
    private final IOrderRepository orderRepository;
    private final IProductService productService;

    public OrderService(IOrderRepository orderRepository, IProductService productService, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productService = productService;
    }
    @Override
    public OrderResponse addOrder(OrderRequest orderRequest) {
        Order order = orderMapper.dtoToEntity(orderRequest);
        updateProducts(orderRequest);
        order = orderRepository.insert(order);

        return orderMapper.entityToResponse(order);
    }

    private void updateProducts(OrderRequest orderRequest) {
        productService.updateProducts(orderRequest.getProducts());
    }
}
