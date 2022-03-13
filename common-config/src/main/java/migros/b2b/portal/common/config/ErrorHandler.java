package migros.b2b.portal.common.config;

import migros.b2b.portal.model.exceptions.BaseException;
import migros.b2b.portal.model.exceptions.EntityNotFoundException;
import migros.b2b.portal.model.exceptions.NotEnoughStock;
import migros.b2b.portal.model.responses.BaseResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<BaseResponse> handleNotFoundException(EntityNotFoundException e, Locale locale) {
        return ResponseEntity
                .badRequest()
                .body(new BaseResponse(e.getMessage()));
    }

    @ExceptionHandler({NotEnoughStock.class})
    protected ResponseEntity<BaseResponse> handleNotEnoughStockException(NotEnoughStock e, Locale locale) {
        return ResponseEntity
                .internalServerError()
                .body(new BaseResponse(e.getMessage()));
    }

    @ExceptionHandler({BaseException.class})
    protected ResponseEntity<BaseResponse>  handleOtherException (BaseException e, Locale locale) {
        return ResponseEntity
                .internalServerError()
                .body(new BaseResponse(e.getMessage()));
    }

}
