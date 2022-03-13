package migros.b2b.portal.order.controllers;

import migros.b2b.portal.model.requests.OrderRequest;
import migros.b2b.portal.model.responses.OrderResponse;
import migros.b2b.portal.order.services.IOrderService;
import migros.b2b.portal.order.services.impl.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class OrderController {
    IOrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/addOrder")
    public ResponseEntity<OrderResponse> addOrder(@Valid @RequestBody OrderRequest orderRequest) {

        OrderResponse orderResponse = orderService.addOrder(orderRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }
}
