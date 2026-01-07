import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParcelCostTest {

    @Test
    void standardParcelCostShouldBeCalculatedCorrectly() {
        StandardParcel parcel = new StandardParcel("Книга", 10, "Бишкек", 1);

        assertEquals(20, parcel.calculateDeliveryCost());
    }

    @Test
    void fragileParcelCostShouldBeCalculatedCorrectly() {
        FragileParcel parcel = new FragileParcel("Ваза", 5, "Ош", 2);

        assertEquals(20, parcel.calculateDeliveryCost());
    }

    @Test
    void zeroWeightParcelShouldCostZero() {
        StandardParcel parcel = new StandardParcel("Пусто", 0, "Бишкек", 1);

        assertEquals(0, parcel.calculateDeliveryCost());
    }
}
