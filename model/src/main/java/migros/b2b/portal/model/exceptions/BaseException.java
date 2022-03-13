package migros.b2b.portal.model.exceptions;
import lombok.Data;
import lombok.EqualsAndHashCode;
import migros.b2b.portal.model.common.ExceptionEnum;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException {

    private final String message;
    public BaseException() {
        this.message = ExceptionEnum.INTERNAL_SERVER_ERROR.getValue();
    }

    public BaseException(String message) {
        this.message = message;

    }
}
