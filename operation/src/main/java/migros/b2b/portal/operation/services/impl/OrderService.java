package migros.b2b.portal.operation.services.impl;

import migros.b2b.portal.model.requests.OrderRequest;
import migros.b2b.portal.model.responses.CustomerOrdersResponse;
import migros.b2b.portal.model.responses.OrderResponse;
import migros.b2b.portal.operation.entities.Customer;
import migros.b2b.portal.operation.entities.Order;
import migros.b2b.portal.operation.mappers.CustomerOrdersMapper;
import migros.b2b.portal.operation.mappers.OrderMapper;
import migros.b2b.portal.operation.repositories.ICustomOrderRepository;
import migros.b2b.portal.operation.repositories.IOrderRepository;
import migros.b2b.portal.operation.services.ICustomerService;
import migros.b2b.portal.operation.services.IOrderService;
import migros.b2b.portal.operation.services.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService implements IOrderService {
    private final OrderMapper orderMapper;
    private final IOrderRepository orderRepository;

    private final ICustomerService customerService;
    private final IProductService productService;

    private final ICustomOrderRepository customOrderRepository;

    private final CustomerOrdersMapper customerOrdersMapper;

    public OrderService(IOrderRepository orderRepository,ICustomOrderRepository customOrderRepository, ICustomerService customerService,IProductService productService,  OrderMapper orderMapper, CustomerOrdersMapper customerOrdersMapper) {
        this.orderRepository = orderRepository;
        this.customOrderRepository = customOrderRepository;
        this.orderMapper = orderMapper;
        this.productService = productService;
        this.customerService = customerService;
        this.customerOrdersMapper= customerOrdersMapper;

    }
    @Override
    public OrderResponse addOrder(OrderRequest orderRequest) {
        Order order = orderMapper.dtoToEntity(orderRequest);
        updateProducts(orderRequest);
        order = orderRepository.insert(order);

        return orderMapper.entityToResponse(order);
    }

    @Override
    public List<OrderResponse> getOrdersByCriteria(String id, Date startDate, Date endDate) throws ParseException {
        List<Order> orders =  customOrderRepository.getOrderByCriteria(id,startDate,endDate);
        return orders.stream().map(orderMapper::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public CustomerOrdersResponse getCustomerOrders(String email, Integer page, Integer size) {
        Customer customer = getCustomer(email);

        Pageable paging = PageRequest.of(page, size, Sort.by(
                Sort.Order.desc("orderDate")));
        Page<Order> ordersPage = orderRepository.findByCustomer(email, paging);

        return customerOrdersMapper.mapToCustomerOrdersResponse(customer,ordersPage.getContent());

    }

    private Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    @Override
    public void cancelOrder(String id) {
        orderRepository.deleteById(id);
    }


    private void updateProducts(OrderRequest orderRequest) {
        productService.updateProducts(orderRequest.getProducts());
    }
}
