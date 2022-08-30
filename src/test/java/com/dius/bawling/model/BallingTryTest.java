package com.dius.bawling.model;

import static org.junit.jupiter.api.Assertions.*;

class BallingTryTest {

    @org.junit.jupiter.api.Test
    void getKnockedNumberOfPins() {
        BallingTry testTry = new BallingTry(5);
        assertEquals(5, testTry.getKnockedNumberOfPins(),"New BallingTry() did not set the # of knocked Pins!");
    }




    @org.junit.jupiter.api.Test
    void isStrike() {
        BallingTry testTry = new BallingTry(10);
        assertTrue(testTry.isStrike(), "Setting a Knocked number of pins to 10 did not set a Strike!");
    }

}