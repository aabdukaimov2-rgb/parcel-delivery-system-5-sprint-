public class StandardParcel extends Parcel {

    private final static int BASE_PRICE = 2;

    protected StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getBasePrice() {
        return BASE_PRICE ;
    }

}
