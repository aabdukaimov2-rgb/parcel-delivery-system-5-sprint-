public class FragileParcel extends Parcel implements Trackable {

    private final static int BASE_PRICE = 4;

    protected FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<" + description +  ">> обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public int getBasePrice() {
        return BASE_PRICE ;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + description + ">> изменила местоположение на " + newLocation);
    }
}
