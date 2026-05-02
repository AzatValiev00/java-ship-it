package ru.yandex.practicum;

public class StandardParcel extends Parcel{

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getCost() {
        return 2;
    }
}
