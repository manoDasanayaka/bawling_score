package com.dius.bawling.model;

import com.dius.bawling.exception.BawlingException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dius.bawling.util.BawlingBuilderUtil.generateBallingFrame;
import static org.junit.jupiter.api.Assertions.*;

class BawlingGameTest {

    @Test
    void getBonusScoreWithSpare() throws BawlingException {
        BawlingFrame testFrame1 = generateBallingFrame(4,5);
        BawlingFrame testFrame2 = generateBallingFrame(4,6);
        BawlingFrame testFrame3 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);

        assertEquals(4,game.getBonusScore(), "Bonus score is wrong for a Spare!");
    }

    @Test
    void getBonusScoreWithStrike() throws BawlingException {
        BawlingFrame testFrame1 = generateBallingFrame(4,5);

        BawlingFrame testFrame2 = generateBallingFrame(10);
        BawlingFrame testFrame3 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);

        assertEquals(6,game.getBonusScore(), "Bonus score is wrong for a Strike!");
    }


    @Test
    void getBonusScoreWithSpareAndStrike() throws BawlingException {
        BawlingFrame testFrame1 = generateBallingFrame(4,5);

        BawlingFrame testFrame2 = generateBallingFrame(10);
        BawlingFrame testFrame3 = generateBallingFrame(4,2);
        BawlingFrame testFrame4 = generateBallingFrame(3,7);
        BawlingFrame testFrame5 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);
        gameFrames.add(testFrame4);
        gameFrames.add(testFrame5);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);

        assertEquals(10,game.getBonusScore(), "Bonus score is wrong when both a Strike and a Spare!");
    }

    @Test
    void getBonusScoreWithManySpare() throws BawlingException {
        BawlingFrame testFrame1 = generateBallingFrame(4,5);
        BawlingFrame testFrame2 = generateBallingFrame(5,5);
        BawlingFrame testFrame3 = generateBallingFrame(2,8);
        BawlingFrame testFrame4 = generateBallingFrame(3,7);
        BawlingFrame testFrame5 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);
        gameFrames.add(testFrame4);
        gameFrames.add(testFrame5);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);

        assertEquals(9,game.getBonusScore(), "Bonus score is wrong when multiple Spare!");
    }

    @Test
    void getBonusScoreWithManyStrikes() throws BawlingException {
        BawlingFrame testFrame1 = generateBallingFrame(4,5);

        BawlingFrame testFrame2 = generateBallingFrame(10);
        BawlingFrame testFrame3 = generateBallingFrame(4,2);
        BawlingFrame testFrame4 = generateBallingFrame(3,7);
        BawlingFrame testFrame5 = generateBallingFrame(10);
        BawlingFrame testFrame6 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);
        gameFrames.add(testFrame4);
        gameFrames.add(testFrame5);
        gameFrames.add(testFrame6);
        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);

        assertEquals(22,game.getBonusScore(), "Bonus score is wrong when many Strikes!");
    }

    @Test
    void getScoreWithAllStrikes() throws BawlingException {
        BawlingFrame testFrame1 = generateBallingFrame(10);

        BawlingFrame testFrame2 = generateBallingFrame(10);
        BawlingFrame testFrame3 = generateBallingFrame(10);
        BawlingFrame testFrame4 = generateBallingFrame(10);
        BawlingFrame testFrame5 = generateBallingFrame(10);
        BawlingFrame testFrame6 = generateBallingFrame(10);
        BawlingFrame testFrame7 = generateBallingFrame(10);
        BawlingFrame testFrame8 = generateBallingFrame(10);
        BawlingFrame testFrame9 = generateBallingFrame(10);
        BawlingFrame testFrame10 = generateBallingFrame(10);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);
        gameFrames.add(testFrame4);
        gameFrames.add(testFrame5);
        gameFrames.add(testFrame6);
        gameFrames.add(testFrame7);
        gameFrames.add(testFrame8);
        gameFrames.add(testFrame9);
        gameFrames.add(testFrame10);
        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);

        assertEquals(300,game.getScore(), "Bonus score is wrong when all Strikes [with OPTIONAL 300 rule]!");
    }

    @Test
    void getBonusScoreWithAllStrikesExceptFinal() throws BawlingException {
        BawlingFrame testFrame1 = generateBallingFrame(10);

        BawlingFrame testFrame2 = generateBallingFrame(10);
        BawlingFrame testFrame3 = generateBallingFrame(10);
        BawlingFrame testFrame4 = generateBallingFrame(10);
        BawlingFrame testFrame5 = generateBallingFrame(10);
        BawlingFrame testFrame6 = generateBallingFrame(10);
        BawlingFrame testFrame7 = generateBallingFrame(10);
        BawlingFrame testFrame8 = generateBallingFrame(10);
        BawlingFrame testFrame9 = generateBallingFrame(10);
        BawlingFrame testFrame10 = generateBallingFrame(5);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);
        gameFrames.add(testFrame4);
        gameFrames.add(testFrame5);
        gameFrames.add(testFrame6);
        gameFrames.add(testFrame7);
        gameFrames.add(testFrame8);
        gameFrames.add(testFrame9);
        gameFrames.add(testFrame10);
        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);

        assertEquals(160,game.getBonusScore(), "Bonus score is wrong when all Strikes except final one!");
    }


    @Test
    void getTotalKnockedScore() throws BawlingException {

        BawlingFrame testFrame1 = generateBallingFrame(4,5);
        BawlingFrame testFrame2 = generateBallingFrame(4,3);
        BawlingFrame testFrame3 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);
        assertEquals(22, game.getTotalKnockedScore(), "Total knocked score is wrong for a Game!");
    }

    @Test
    public void setGameFrames_Null_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BawlingGame().setGameFrames(null);
        });

        String expectedMessage = "Only 10 or less frames per Game!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void setGameFrames_Empty_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BawlingGame().setGameFrames(new ArrayList<>());
        });

        String expectedMessage = "Only 10 or less frames per Game!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void setGameFrames_MoreThan10_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BawlingGame().setGameFrames(new ArrayList<>(
                    Arrays.asList(new BawlingFrame[]{
                        generateBallingFrame(2,3),
                        generateBallingFrame(3,6),
                        generateBallingFrame(6,2),
                            generateBallingFrame(6,2),
                            generateBallingFrame(6,2),
                            generateBallingFrame(6,2),
                            generateBallingFrame(6,2),
                            generateBallingFrame(6,2),
                            generateBallingFrame(6,2),
                            generateBallingFrame(6,2),
                            generateBallingFrame(6,2),
                            generateBallingFrame(6,2)

                    })));
        });

        String expectedMessage = "Only 10 or less frames per Game!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getScore() {
    }
}