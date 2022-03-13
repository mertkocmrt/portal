package readingisgood.retail.model.exception;

import readingisgood.retail.model.common.ExceptionEnum;

public class NotEnoughStock extends BaseException {
    public NotEnoughStock(){
        super(ExceptionEnum.NOT_ENOUGH_STOCK.getValue());
    }
}
