import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PerishableParcelTest {

    @Test
    void parcelShouldNotBeExpiredWithinTimeToLive() {
        PerishableParcel parcel =
                new PerishableParcel("Торт", 2, "Бишкек", 1, 5);

        assertFalse(parcel.isExpired(5));
    }

    @Test
    void parcelShouldBeExpiredAfterTimeToLive() {
        PerishableParcel parcel =
                new PerishableParcel("Торт", 2, "Бишкек", 1, 5);

        assertTrue(parcel.isExpired(7));
    }

    @Test
    void parcelShouldNotBeExpiredOnLastValidDay() {
        PerishableParcel parcel =
                new PerishableParcel("Йогурт", 1, "Ош", 3, 2);

        assertFalse(parcel.isExpired(5)); // 3 + 2
    }
}
