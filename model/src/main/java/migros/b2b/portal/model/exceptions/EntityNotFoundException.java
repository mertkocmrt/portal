package migros.b2b.portal.model.exceptions;


import migros.b2b.portal.model.common.ExceptionEnum;

public class EntityNotFoundException extends BaseException {

    public EntityNotFoundException(){
        super(ExceptionEnum.ERROR_ENTITY_NOT_FOUND.getValue());
    }

}
