package migros.b2b.portal.model.exceptions;


import migros.b2b.portal.model.common.ExceptionEnum;

public class NotEnoughStock extends BaseException {
    public NotEnoughStock(){
        super(ExceptionEnum.NOT_ENOUGH_STOCK.getValue());
    }
}
