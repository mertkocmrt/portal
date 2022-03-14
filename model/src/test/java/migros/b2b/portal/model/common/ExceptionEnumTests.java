package migros.b2b.portal.model.common;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionEnumTests {

    @Test
    public void addCustomerTest(){
        assertEquals(1, ExceptionEnum.ERROR_ENTITY_NOT_FOUND.getKey());
        assertEquals("Geri döndürülecek kayıt yok", ExceptionEnum.ERROR_ENTITY_NOT_FOUND.getValue());
    }
}
