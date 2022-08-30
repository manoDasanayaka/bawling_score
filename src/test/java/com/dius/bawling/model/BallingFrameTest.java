package com.dius.bawling.model;

import com.dius.bawling.exception.BawlingException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BallingFrameTest {

    @Test
    void getTotalOfTries() throws BawlingException {
        BallingTry[] triesArray1 = new BallingTry[]{ new BallingTry(3), new BallingTry(7)};
        List<BallingTry> frameTries = new ArrayList<>( Arrays.asList(triesArray1));
        BallingFrame testFrame = new BallingFrame(frameTries);
        assertEquals(10,testFrame.getTotalOfTries(), "Total of tries does not match the Frame score calculations!");
    }

    @Test
    void getTotalOfTriesTake2() throws BawlingException {
        BallingTry[] triesArray1 = new BallingTry[]{ new BallingTry(3), new BallingTry(4)};
        List<BallingTry> frameTries = new ArrayList<>( Arrays.asList(triesArray1));
        BallingFrame testFrame = new BallingFrame(frameTries);
        assertEquals(7,testFrame.getTotalOfTries(), "Total of tries does not match the Frame score calculations!");
    }
    @Test
    void frameWithSpare() throws BawlingException {

        BallingTry[] triesArray1 = new BallingTry[]{ new BallingTry(3), new BallingTry(7)};
        List<BallingTry> frameTries = new ArrayList<>( Arrays.asList(triesArray1));
        BallingFrame testFrame = new BallingFrame(frameTries);
        testFrame.populateFrame();
        assertTrue(testFrame.isSpareFrame(),"Total of frame tries did not result in a Spare !");
    }

    @Test
    void frameWithStrike() throws BawlingException {

        BallingTry[] triesArray1 = new BallingTry[]{ new BallingTry(10)};
        List<BallingTry> frameTries = new ArrayList<>( Arrays.asList(triesArray1));
        BallingFrame testFrame = new BallingFrame(frameTries);
        assertTrue(testFrame.isWithStrike(),"Total of frame tries did not result in a Strike !");
    }

    @Test
    public void populateFrame_empty_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BallingFrame(new ArrayList<>());
        });

        String expectedMessage = "Only two or less tries for a Frame!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    public void populateFrame_MoreThan2_Tries_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BallingFrame( new ArrayList<>( Arrays.asList(new BallingTry[]{
                    new BallingTry(10),
                    new BallingTry(7),
                    new BallingTry(4)})));

        });

        String expectedMessage = "Only two or less tries for a Frame!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void populateFrame_No_Tries_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BallingFrame( null);

        });

        String expectedMessage = "Only two or less tries for a Frame!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}