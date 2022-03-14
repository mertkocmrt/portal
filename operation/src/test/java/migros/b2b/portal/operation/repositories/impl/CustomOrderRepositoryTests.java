package migros.b2b.portal.operation.repositories.impl;

import com.mongodb.client.MongoClients;
import migros.b2b.portal.operation.entities.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureMockMvc
@AutoConfigureDataMongo
@SpringBootTest
public class CustomOrderRepositoryTests {

    private static final String CONNECTION_STRING = "mongodb+srv://mertkocmrt:PZwrhS9Mr3euY3Om@cluster0.4xvkv.mongodb.net/portal?retryWrites=true&w=majority";

    private MongoTemplate mongoTemplate;

    @Test
    public void test() throws Exception {

        mongoTemplate = new MongoTemplate(MongoClients.create(CONNECTION_STRING), "test");
        CustomOrderRepository customOrderRepository = new CustomOrderRepository(mongoTemplate);
        List<Order> orders = customOrderRepository.getOrderByCriteria("id",null,null);
        assertThat(orders).isNotNull();
    }

}
