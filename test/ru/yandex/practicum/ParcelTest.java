package ru.yandex.practicum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelTest {

    @Test
    void calculateStandartDeliveryCost() {
        StandardParcel standardParcel = new StandardParcel("Parcel", 10, "Address",
                2);
        assertEquals(20, standardParcel.calculateDeliveryCost());
    }

    @Test
    void calculatePerishableDeliveryCost() {
        PerishableParcel perishableParcel = new PerishableParcel("Parcel", 10, "Address",
                2, 1);
        assertEquals(30, perishableParcel.calculateDeliveryCost());
    }

    @Test
    void calculateFragileDeliveryCost() {
        FragileParcel fragileParcel = new FragileParcel("Parcel", 10, "Address",
                2);
        assertEquals(40, fragileParcel.calculateDeliveryCost());
    }
}