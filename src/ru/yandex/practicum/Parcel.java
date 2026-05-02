package ru.yandex.practicum;

public abstract class Parcel {
    protected final String description;
    private final int weight;
    private final String deliveryAddress;
    protected final int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка <" + description + "> упакована");
    }

    public void deliver() {
        System.out.println("Посылка <" + description + "> доставлена по адресу " + deliveryAddress);
    }

    public abstract int getCost();

    public int calculateDeliveryCost() {
        return weight * getCost();
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Посылка " + description;
    }
}
