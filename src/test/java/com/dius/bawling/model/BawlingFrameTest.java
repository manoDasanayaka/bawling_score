package com.dius.bawling.model;

import com.dius.bawling.exception.BawlingException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BawlingFrameTest {

    @Test
    void getTotalOfTries() throws BawlingException {
        BawlingTry[] triesArray1 = new BawlingTry[]{ new BawlingTry(3), new BawlingTry(7)};
        List<BawlingTry> frameTries = new ArrayList<>( Arrays.asList(triesArray1));
        BawlingFrame testFrame = new BawlingFrame(frameTries);
        assertEquals(10,testFrame.getTotalOfTries(), "Total of tries does not match the Frame score calculations!");
    }

    @Test
    void getTotalOfTriesTake2() throws BawlingException {
        BawlingTry[] triesArray1 = new BawlingTry[]{ new BawlingTry(3), new BawlingTry(4)};
        List<BawlingTry> frameTries = new ArrayList<>( Arrays.asList(triesArray1));
        BawlingFrame testFrame = new BawlingFrame(frameTries);
        assertEquals(7,testFrame.getTotalOfTries(), "Total of tries does not match the Frame score calculations!");
    }
    @Test
    void frameWithSpare() throws BawlingException {

        BawlingTry[] triesArray1 = new BawlingTry[]{ new BawlingTry(3), new BawlingTry(7)};
        List<BawlingTry> frameTries = new ArrayList<>( Arrays.asList(triesArray1));
        BawlingFrame testFrame = new BawlingFrame(frameTries);
        testFrame.populateFrame();
        assertTrue(testFrame.isSpareFrame(),"Total of frame tries did not result in a Spare !");
    }

    @Test
    void frameWithStrike() throws BawlingException {

        BawlingTry[] triesArray1 = new BawlingTry[]{ new BawlingTry(10)};
        List<BawlingTry> frameTries = new ArrayList<>( Arrays.asList(triesArray1));
        BawlingFrame testFrame = new BawlingFrame(frameTries);
        assertTrue(testFrame.isWithStrike(),"Total of frame tries did not result in a Strike !");
    }

    @Test
    public void populateFrame_empty_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BawlingFrame(new ArrayList<>());
        });

        String expectedMessage = "Only two or less tries for a Frame!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void populateFrame_MoreThan2_Tries_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BawlingFrame( new ArrayList<>( Arrays.asList(new BawlingTry[]{
                    new BawlingTry(10),
                    new BawlingTry(7),
                    new BawlingTry(4)})));

        });

        String expectedMessage = "Only two or less tries for a Frame!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void populateFrame_No_Tries_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BawlingFrame( null);

        });

        String expectedMessage = "Only two or less tries for a Frame!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}