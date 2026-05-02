package ru.yandex.practicum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerishableParcelTest {
    PerishableParcel perishableParcel = new PerishableParcel("Еда", 2, "Адрес",
            2, 3);

    @Test
    void isNotExpiredWhenNotOutOfDate() {
       assertFalse(perishableParcel.isExpired(4));
    }

    @Test
    void isNotExpiredWhenOutOfDateToday() {
        assertFalse(perishableParcel.isExpired(5));
    }

    @Test
    void isExpiredWhenOutOfDate() {
        assertTrue(perishableParcel.isExpired(6));
    }
}