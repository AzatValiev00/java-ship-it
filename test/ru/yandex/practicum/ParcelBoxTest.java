package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {

    ParcelBox<StandardParcel> box;
    StandardParcel parcel1;

    @BeforeEach
    void beforeEach() {
        box = new ParcelBox<>(10);
        parcel1 = new StandardParcel("Parcel1", 8, "Address", 2);
        box.addParcel(parcel1);
    }

    @Test
    void parcelWeightIsUnderLimit() {
        StandardParcel parcel2 = new StandardParcel("Parcel2", 1, "Address", 2);
        box.addParcel(parcel2);
        ArrayList<StandardParcel> actual = box.getParcels();
        assertEquals(2, actual.size());
        assertTrue(actual.contains(parcel1));
        assertTrue(actual.contains(parcel2));
    }

    @Test
    void parcelWeightEqualsLimit() {
        StandardParcel parcel2 = new StandardParcel("Parcel2", 2, "Address", 2);
        box.addParcel(parcel2);
        ArrayList<StandardParcel> actual = box.getParcels();
        assertEquals(2, actual.size());
        assertTrue(actual.contains(parcel1));
        assertTrue(actual.contains(parcel2));
    }

    @Test
    void parcelWeightExceedsLimit() {
        StandardParcel parcel2 = new StandardParcel("Parcel2", 3, "Address", 2);
        box.addParcel(parcel2);
        ArrayList<StandardParcel> actual = box.getParcels();
        assertEquals(1, actual.size());
        assertTrue(actual.contains(parcel1));
        assertFalse(actual.contains(parcel2));
    }

}