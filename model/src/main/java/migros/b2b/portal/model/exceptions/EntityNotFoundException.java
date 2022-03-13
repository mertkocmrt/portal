package readingisgood.retail.model.exception;

import readingisgood.retail.model.common.ExceptionEnum;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(){
        super(ExceptionEnum.ERROR_ENTITY_NOT_FOUND.getValue());
    }

}
