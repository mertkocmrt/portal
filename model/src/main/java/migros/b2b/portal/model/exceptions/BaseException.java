package readingisgood.retail.model.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import readingisgood.retail.model.common.ExceptionEnum;

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
