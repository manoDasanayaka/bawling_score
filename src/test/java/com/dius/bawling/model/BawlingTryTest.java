package com.dius.bawling.model;

import static org.junit.jupiter.api.Assertions.*;

class BawlingTryTest {

    @org.junit.jupiter.api.Test
    void getKnockedNumberOfPins() {
        BawlingTry testTry = new BawlingTry(5);
        assertEquals(5, testTry.getKnockedNumberOfPins(),"New BallingTry() did not set the # of knocked Pins!");
    }




    @org.junit.jupiter.api.Test
    void isStrike() {
        BawlingTry testTry = new BawlingTry(10);
        assertTrue(testTry.isStrike(), "Setting a Knocked number of pins to 10 did not set a Strike!");
    }

}