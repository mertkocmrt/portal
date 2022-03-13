package migros.b2b.portal.model.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {

    private String _id;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date orderDate;
    private String customer;
    private String status;
    private List<ProductResponse> products;
}
