
public abstract class Parcel {

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;


    protected Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public int getSendDay() {
        return sendDay;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }


    public void packageItem() {
        System.out.println("📦 Посылка <<" + description +  ">> упакована");
    }

    public void deliver() {
        System.out.println("📦 Посылка <<" + description + ">> доставлена по адресу: " + deliveryAddress);
    }

    protected abstract int getBasePrice();

    public int calculateDeliveryCost() {
        return weight * getBasePrice();
    }


}