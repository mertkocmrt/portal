package migros.b2b.portal.model.common;

public enum ExceptionEnum {
    ERROR_ENTITY_NOT_FOUND(1,"Geri döndürülecek kayıt yok"),
    INTERNAL_SERVER_ERROR(2, "İşlem sırasında hata"),
    NOT_ENOUGH_STOCK(4,"Çok geç kaldınız başka bir e-ticaret sitesini deneyin");

    private int key;
    private String value;

    ExceptionEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
