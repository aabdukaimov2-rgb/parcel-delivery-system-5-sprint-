public class PerishableParcel extends Parcel {

    private final int timeToLive;
    private final static int BASE_PRICE = 3;


    protected PerishableParcel(String description, int weight, String deliveryAddress,
                               int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getBasePrice() {
        return BASE_PRICE ;
    }

    public boolean isExpired(int currentDay) {
        return currentDay > (sendDay + timeToLive);
    }
}
