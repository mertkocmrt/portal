package migros.b2b.portal.operation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Orders")
public class Order {
    @Id
    private String _id;
    private Date orderDate;
    private String customer;
    private String status;
    private List<OrderProduct> products;
}
