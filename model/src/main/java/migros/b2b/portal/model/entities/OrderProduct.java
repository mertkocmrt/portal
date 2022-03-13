package migros.b2b.portal.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProduct {
    @Id
    private String _id;
    private String name;
    private Integer quantity;
    private String author;
    private BigDecimal price;
}
