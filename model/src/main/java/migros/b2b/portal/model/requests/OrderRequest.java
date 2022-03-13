package migros.b2b.portal.model.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest implements Serializable {
    @JsonFormat(pattern="dd/MM/yyyy")
    @Future
    private Date orderDate;
    private String customer;
    @Valid
    private List<ProductRequest> products;
}
