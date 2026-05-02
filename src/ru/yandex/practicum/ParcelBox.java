package ru.yandex.practicum;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {

    private ArrayList<T> parcels = new ArrayList<>();
    private int maxBoxWeight;
    private int boxWeight = 0;

    public ParcelBox(int maxBoxWeight) {
        this.maxBoxWeight = maxBoxWeight;
    }

    public void addParcel(T parcel) {
        if ((boxWeight + parcel.getWeight()) > maxBoxWeight) {
            System.out.println("При добавлении этого предмета масса коробки превысит максимально допустимую!");
        } else {
            parcels.add(parcel);
            boxWeight += parcel.getWeight();
        }
    }
    public ArrayList<T> getAllParcels() {
        return parcels;
    }
}
