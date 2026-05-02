package ru.yandex.practicum;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {

    ArrayList<T> box = new ArrayList<>();
    private int maxBoxWeight;
    private int boxWeight = 0;

    public ParcelBox(int maxBoxWeight) {
        this.maxBoxWeight = maxBoxWeight;
    }

    public void addParcel(T parcel) {
        if ((boxWeight + parcel.getWeight()) > maxBoxWeight) {
            System.out.println("При добавлении этого предмета масса коробки превысит максимально допустимую!");
        } else {
            box.add(parcel);
            boxWeight += parcel.getWeight();
        }
    }
    public ArrayList<T> getParcels() {
        return box;
    }

    public void getAllParcels() {
        for(T parcel : box) {
            System.out.println(parcel.toString());
        }
    }
}
