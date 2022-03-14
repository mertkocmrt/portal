package migros.b2b.portal.operation.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import migros.b2b.portal.common.config.ErrorHandler;
import migros.b2b.portal.model.responses.OrderResponse;
import migros.b2b.portal.operation.services.impl.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTests {

    private MockMvc mvc;

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private JacksonTester<OrderResponse> orderResponse;

    private JacksonTester<List<OrderResponse>> orderResponseList;

    @BeforeEach
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(orderController)
                .setControllerAdvice(new ErrorHandler())
                .build();
    }

    @Test
    public void addOrderTest() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                post("/addOrder").contentType(MediaType.APPLICATION_JSON).content(
                        orderResponse.write(new OrderResponse("id",new SimpleDateFormat("dd/MM/yyyy").parse("14/06/2022"),"koc.mrt@gmail.com","status",null)).getJson()
                )).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    public void addOrderTest_PastDate() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                post("/addOrder").contentType(MediaType.APPLICATION_JSON).content(
                        orderResponse.write(new OrderResponse("id",new SimpleDateFormat("dd/MM/yyyy").parse("14/02/2022"),"koc.mrt@gmail.com","status",null)).getJson()
                )).andReturn().getResponse();
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


}
