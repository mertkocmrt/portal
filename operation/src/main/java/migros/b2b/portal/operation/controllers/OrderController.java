package migros.b2b.portal.operation.controllers;

import migros.b2b.portal.model.common.ResponseMessages;
import migros.b2b.portal.model.requests.OrderRequest;
import migros.b2b.portal.model.responses.CustomerOrdersResponse;
import migros.b2b.portal.model.responses.OrderResponse;
import migros.b2b.portal.operation.services.IOrderService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {
    IOrderService orderService;

    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/getOrderByCriteria")
    public ResponseEntity<List<OrderResponse>> getOrder(@RequestParam(name = "id", required=false) String id, @RequestParam(name = "startDate", required=false) @DateTimeFormat(pattern="dd/MM/yyyy") Date startDate, @RequestParam(name = "endDate", required=false)  @DateTimeFormat(pattern="dd/MM/yyyy") Date endDate) throws ParseException {

        List<OrderResponse> orderResponse = orderService.getOrdersByCriteria(id, startDate, endDate);

        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

    @GetMapping("/getCustomerOrders")
    public ResponseEntity<CustomerOrdersResponse> getCustomerOrders(@RequestParam(name = "email") String email,
                                                                    @RequestParam(name = "page") Integer page,
                                                                    @RequestParam(name = "size") Integer size) {

        CustomerOrdersResponse customerOrdersResponse = orderService.getCustomerOrders(email, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(customerOrdersResponse);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<OrderResponse> addOrder(@Valid @RequestBody OrderRequest orderRequest) {

        OrderResponse orderResponse = orderService.addOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }

    @DeleteMapping("/cancelOrder")
    public ResponseEntity<String> cancelOrder(@RequestParam(name = "id") String id) {

        orderService.cancelOrder(id);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseMessages.CANCEL_ORDER);
    }


}
