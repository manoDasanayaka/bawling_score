package com.dius.bawling.model;

import com.dius.bawling.exception.BawlingException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.dius.bawling.util.BawlingBuilderUtil.generateBallingFrame;
import static org.junit.jupiter.api.Assertions.*;

class BallingGameTest {

    @Test
    void getBonusScoreWithSpare() throws BawlingException {
        BallingFrame testFrame1 = generateBallingFrame(4,5);
        BallingFrame testFrame2 = generateBallingFrame(4,6);
        BallingFrame testFrame3 = generateBallingFrame(4,2);
        List<BallingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);

        BallingGame game = new BallingGame();
        game.setGameFrames(gameFrames);

        assertEquals(4,game.getBonusScore(), "Bonus score is wrong for a Spare!");
    }

    @Test
    void getBonusScoreWithStrike() throws BawlingException {
        BallingFrame testFrame1 = generateBallingFrame(4,5);

        BallingFrame testFrame2 = generateBallingFrame(10);
        BallingFrame testFrame3 = generateBallingFrame(4,2);
        List<BallingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);

        BallingGame game = new BallingGame();
        game.setGameFrames(gameFrames);

        assertEquals(6,game.getBonusScore(), "Bonus score is wrong for a Strike!");
    }


    @Test
    void getBonusScoreWithSpareAndStrike() throws BawlingException {
        BallingFrame testFrame1 = generateBallingFrame(4,5);

        BallingFrame testFrame2 = generateBallingFrame(10);
        BallingFrame testFrame3 = generateBallingFrame(4,2);
        BallingFrame testFrame4 = generateBallingFrame(3,7);
        BallingFrame testFrame5 = generateBallingFrame(4,2);
        List<BallingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);
        gameFrames.add(testFrame4);
        gameFrames.add(testFrame5);

        BallingGame game = new BallingGame();
        game.setGameFrames(gameFrames);

        assertEquals(10,game.getBonusScore(), "Bonus score is wrong when both a Strike and a Spare!");
    }

    @Test
    void getBonusScoreWithManySpare() throws BawlingException {
        BallingFrame testFrame1 = generateBallingFrame(4,5);
        BallingFrame testFrame2 = generateBallingFrame(5,5);
        BallingFrame testFrame3 = generateBallingFrame(2,8);
        BallingFrame testFrame4 = generateBallingFrame(3,7);
        BallingFrame testFrame5 = generateBallingFrame(4,2);
        List<BallingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);
        gameFrames.add(testFrame4);
        gameFrames.add(testFrame5);

        BallingGame game = new BallingGame();
        game.setGameFrames(gameFrames);

        assertEquals(9,game.getBonusScore(), "Bonus score is wrong when multiple Spare!");
    }

    @Test
    void getBonusScoreWithManyStrikes() throws BawlingException {
        BallingFrame testFrame1 = generateBallingFrame(4,5);

        BallingFrame testFrame2 = generateBallingFrame(10);
        BallingFrame testFrame3 = generateBallingFrame(4,2);
        BallingFrame testFrame4 = generateBallingFrame(3,7);
        BallingFrame testFrame5 = generateBallingFrame(10);
        BallingFrame testFrame6 = generateBallingFrame(4,2);
        List<BallingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);
        gameFrames.add(testFrame4);
        gameFrames.add(testFrame5);
        gameFrames.add(testFrame6);
        BallingGame game = new BallingGame();
        game.setGameFrames(gameFrames);

        assertEquals(22,game.getBonusScore(), "Bonus score is wrong when many Strikes!");
    }

    @Test
    void getScoreWithAllStrikes() throws BawlingException {
        BallingFrame testFrame1 = generateBallingFrame(10);

        BallingFrame testFrame2 = generateBallingFrame(10);
        BallingFrame testFrame3 = generateBallingFrame(10);
        BallingFrame testFrame4 = generateBallingFrame(10);
        BallingFrame testFrame5 = generateBallingFrame(10);
        BallingFrame testFrame6 = generateBallingFrame(10);
        BallingFrame testFrame7 = generateBallingFrame(10);
        BallingFrame testFrame8 = generateBallingFrame(10);
        BallingFrame testFrame9 = generateBallingFrame(10);
        BallingFrame testFrame10 = generateBallingFrame(10);
        List<BallingFrame> gameFrames = new ArrayList<>();
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
        BallingGame game = new BallingGame();
        game.setGameFrames(gameFrames);

        assertEquals(300,game.getScore(), "Bonus score is wrong when all Strikes [with OPTIONAL 300 rule]!");
    }

    @Test
    void getBonusScoreWithAllStrikesExceptFinal() throws BawlingException {
        BallingFrame testFrame1 = generateBallingFrame(10);

        BallingFrame testFrame2 = generateBallingFrame(10);
        BallingFrame testFrame3 = generateBallingFrame(10);
        BallingFrame testFrame4 = generateBallingFrame(10);
        BallingFrame testFrame5 = generateBallingFrame(10);
        BallingFrame testFrame6 = generateBallingFrame(10);
        BallingFrame testFrame7 = generateBallingFrame(10);
        BallingFrame testFrame8 = generateBallingFrame(10);
        BallingFrame testFrame9 = generateBallingFrame(10);
        BallingFrame testFrame10 = generateBallingFrame(5);
        List<BallingFrame> gameFrames = new ArrayList<>();
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
        BallingGame game = new BallingGame();
        game.setGameFrames(gameFrames);

        assertEquals(160,game.getBonusScore(), "Bonus score is wrong when all Strikes except final one!");
    }


    @Test
    void getTotalKnockedScore() throws BawlingException {

        BallingFrame testFrame1 = generateBallingFrame(4,5);
        BallingFrame testFrame2 = generateBallingFrame(4,3);
        BallingFrame testFrame3 = generateBallingFrame(4,2);
        List<BallingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(testFrame1);
        gameFrames.add(testFrame2);
        gameFrames.add(testFrame3);

        BallingGame game = new BallingGame();
        game.setGameFrames(gameFrames);
        assertEquals(22, game.getTotalKnockedScore(), "Total knocked score is wrong for a Game!");
    }

    @Test
    public void setGameFrames_Null_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BallingGame().setGameFrames(null);
        });

        String expectedMessage = "Only 10 or less frames per Game!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void setGameFrames_Empty_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BallingGame().setGameFrames(new ArrayList<>());
        });

        String expectedMessage = "Only 10 or less frames per Game!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void setGameFrames_MoreThan10_with_Exceptions() {
        Exception exception = assertThrows(BawlingException.class, () -> {
            new BallingGame().setGameFrames(new ArrayList<>(
                    Arrays.asList(new BallingFrame[]{
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