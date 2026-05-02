package ru.yandex.practicum;

public class PerishableParcel extends Parcel{

    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getCost() {
        return 3;
    }

    public boolean isExpired(int currentDay) {
        return (sendDay + timeToLive) < currentDay;
    }
}
