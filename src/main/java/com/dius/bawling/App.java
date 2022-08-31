package com.dius.bawling;

import com.dius.bawling.exception.BawlingException;
import com.dius.bawling.model.BawlingFrame;
import com.dius.bawling.model.BawlingGame;

import java.util.ArrayList;
import java.util.List;

import static com.dius.bawling.util.BawlingBuilderUtil.generateBallingFrame;

public class App
{
    public static void main( String[] args ) throws BawlingException {

        System.out.println( "Welcome to Bawling!" );

        App gameApp = new App();
        gameApp.runBawlingGame();
        gameApp.runBawlingGameWithASpare();
        gameApp.runBawlingGameWithAStrike();
        gameApp.runBawlingGameWithAStrikeAndSpare();

    }

    public void runBawlingGameWithAStrikeAndSpare() throws BawlingException {
        System.out.println("Running with a Spare and a Strike sequence---------");
        BawlingFrame frame1 = generateBallingFrame(4,5);
        BawlingFrame frameSpare = generateBallingFrame(4,6);
        BawlingFrame frameStrike= generateBallingFrame(10);
        BawlingFrame frame3 = generateBallingFrame(4,2);
        BawlingFrame frame4 = generateBallingFrame(4,2);
        BawlingFrame frame5 = generateBallingFrame(4,2);
        BawlingFrame frame6 = generateBallingFrame(4,2);
        BawlingFrame frame7 = generateBallingFrame(4,2);
        BawlingFrame frame8 = generateBallingFrame(4,2);
        BawlingFrame frame9 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(frame1);
        gameFrames.add(frameSpare);
        gameFrames.add(frameStrike);
        gameFrames.add(frame3);
        gameFrames.add(frame4);
        gameFrames.add(frame5);
        gameFrames.add(frame6);
        gameFrames.add(frame7);
        gameFrames.add(frame8);
        gameFrames.add(frame9);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);
        int score = game.getScore();
        System.out.println("Score is ===>"+ score);
    }
    public void runBawlingGameWithAStrike() throws BawlingException {
        System.out.println("Running with a Strike sequence---------");
        BawlingFrame frame1 = generateBallingFrame(4,5);
        BawlingFrame frame2 = generateBallingFrame(4,3);
        BawlingFrame frame3= generateBallingFrame(10);
        BawlingFrame frame4 = generateBallingFrame(4,2);
        BawlingFrame frame5 = generateBallingFrame(4,2);
        BawlingFrame frame6 = generateBallingFrame(4,2);
        BawlingFrame frame7 = generateBallingFrame(4,2);
        BawlingFrame frame8 = generateBallingFrame(4,2);
        BawlingFrame frame9 = generateBallingFrame(4,2);
        BawlingFrame frame10 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(frame1);
        gameFrames.add(frame2);
        gameFrames.add(frame3);
        gameFrames.add(frame4);
        gameFrames.add(frame5);
        gameFrames.add(frame6);
        gameFrames.add(frame7);
        gameFrames.add(frame8);
        gameFrames.add(frame9);
        gameFrames.add(frame10);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);
        int score = game.getScore();
        System.out.println("Score is ===>"+ score);
    }
    public void runBawlingGameWithASpare() throws BawlingException {
        System.out.println("Running with a Spare sequence---------");
        BawlingFrame frame1 = generateBallingFrame(4,5);
        BawlingFrame frame2 = generateBallingFrame(4,3);
        BawlingFrame frame3= generateBallingFrame(2,8);
        BawlingFrame frame4 = generateBallingFrame(4,2);
        BawlingFrame frame5 = generateBallingFrame(4,2);
        BawlingFrame frame6 = generateBallingFrame(4,2);
        BawlingFrame frame7 = generateBallingFrame(4,2);
        BawlingFrame frame8 = generateBallingFrame(4,2);
        BawlingFrame frame9 = generateBallingFrame(4,2);
        BawlingFrame frame10 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(frame1);
        gameFrames.add(frame2);
        gameFrames.add(frame3);
        gameFrames.add(frame4);
        gameFrames.add(frame5);
        gameFrames.add(frame6);
        gameFrames.add(frame7);
        gameFrames.add(frame8);
        gameFrames.add(frame9);
        gameFrames.add(frame10);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);
        int score = game.getScore();
        System.out.println("Score is ===>"+ score);
    }
    public void runBawlingGame() throws BawlingException {
        System.out.println("Running with a usual sequence---------");
        BawlingFrame frame1 = generateBallingFrame(4,5);
        BawlingFrame frame2 = generateBallingFrame(4,3);
        BawlingFrame frame3= generateBallingFrame(2,4);
        BawlingFrame frame4 = generateBallingFrame(4,2);
        BawlingFrame frame5 = generateBallingFrame(4,2);
        BawlingFrame frame6 = generateBallingFrame(4,2);
        BawlingFrame frame7 = generateBallingFrame(4,2);
        BawlingFrame frame8 = generateBallingFrame(4,2);
        BawlingFrame frame9 = generateBallingFrame(4,2);
        BawlingFrame frame10 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(frame1);
        gameFrames.add(frame2);
        gameFrames.add(frame3);
        gameFrames.add(frame4);
        gameFrames.add(frame5);
        gameFrames.add(frame6);
        gameFrames.add(frame7);
        gameFrames.add(frame8);
        gameFrames.add(frame9);
        gameFrames.add(frame10);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);
        int score = game.getScore();
        System.out.println("Score is ===>"+ score);
    }
}
