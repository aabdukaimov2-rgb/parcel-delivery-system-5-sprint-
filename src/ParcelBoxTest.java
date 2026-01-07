import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {

    @Test
    public void testParcelBoxExceedLimit() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(5);
        StandardParcel parcel1 = new StandardParcel("Пакет1", 4, "Адрес1", 1);
        StandardParcel parcel2 = new StandardParcel("Пакет2", 3, "Адрес2", 1);

        box.addParcel(parcel1); // Добавится успешно
        box.addParcel(parcel2); // Не добавится - превышение лимита (4+3 > 5)

        assertEquals(1, box.getAllParcels().size());
    }

}

