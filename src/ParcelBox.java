import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private final List<T> parcels = new ArrayList<>();
    private final int maxWeight;
    private int currentWeight = 0; //

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addParcel(T parcel) {
        if (currentWeight + parcel.getWeight() > maxWeight) {
            System.out.println("❌ Превышен максимальный вес коробки!");
            return;
        }

        parcels.add(parcel);
        currentWeight += parcel.getWeight();
        System.out.println("📦 Посылка добавлена в коробку");
    }

    public List<T> getAllParcels() {
        return parcels;

    }

    public void showContents() {
        if (parcels.isEmpty()) {
            System.out.println(" 📭 Коробка пуста");
        } else {
            System.out.println("Содержимое коробки 📦:");
            for (T parcel : parcels) {
                System.out.println( parcel.getDescription() + " (вес: " + parcel.getWeight() + ")");
            }
        }
    }
}





