package migros.b2b.portal.model.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrdersResponse extends BaseResponse{
    private String email;
    private String name;
    private String address;
    private List<OrderResponse> orders;
}
