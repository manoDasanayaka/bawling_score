package com.dius.bawling;

import com.dius.bawling.exception.BawlingException;
import com.dius.bawling.model.BallingFrame;
import com.dius.bawling.model.BallingGame;

import java.util.ArrayList;
import java.util.List;

import static com.dius.bawling.util.BawlingBuilderUtil.generateBallingFrame;

public class App
{
    public static void main( String[] args ) throws BawlingException {

        System.out.println( "Welcome to Bawling!" );

        BallingFrame frame1 = generateBallingFrame(4,5);
        BallingFrame frame2 = generateBallingFrame(4,6);
        BallingFrame frame3 = generateBallingFrame(4,2);
        List<BallingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(frame1);
        gameFrames.add(frame2);
        gameFrames.add(frame3);

        BallingGame game = new BallingGame();
        game.setGameFrames(gameFrames);
        int score = game.getScore();
        System.out.println("Score is ===>"+ score);
    }
}
