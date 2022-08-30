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

        BawlingFrame frame1 = generateBallingFrame(4,5);
        BawlingFrame frame2 = generateBallingFrame(4,6);
        BawlingFrame frame3 = generateBallingFrame(4,2);
        List<BawlingFrame> gameFrames = new ArrayList<>();
        gameFrames.add(frame1);
        gameFrames.add(frame2);
        gameFrames.add(frame3);

        BawlingGame game = new BawlingGame();
        game.setGameFrames(gameFrames);
        int score = game.getScore();
        System.out.println("Score is ===>"+ score);
    }
}
