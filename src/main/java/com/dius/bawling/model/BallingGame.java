package com.dius.bawling.model;

import com.dius.bawling.exception.BawlingException;

import java.util.List;
import java.util.ListIterator;

public class BallingGame {

    private List<BallingFrame> gameFrames;

    public List<BallingFrame> getGameFrames() {
        return gameFrames;
    }

    public void setGameFrames(List<BallingFrame> gameFrames) throws BawlingException {
        if(gameFrames == null || gameFrames.size() == 0 || gameFrames.size() > 10)
            throw new BawlingException("Only 10 or less frames per Game!");
        this.gameFrames = gameFrames;
    }

    public BallingFrame getNextBallingFrame(ListIterator<BallingFrame> framesIterator){
        int nextIndex =   framesIterator.nextIndex();
        if(nextIndex == 10)
            return  null;
        return gameFrames.get(nextIndex);
    }

    public int getStrikeScore(ListIterator<BallingFrame> framesIterator){
        int nextIndex =   framesIterator.nextIndex();
        if(nextIndex == 10)
            return  0;
        BallingFrame nextFrame = gameFrames.get(nextIndex);
        if(nextFrame.isWithStrike()){
            int nextImmediateIndex = nextIndex+1;
            BallingFrame nextImmediateFrame = (nextImmediateIndex < gameFrames.size()) ? gameFrames.get(nextImmediateIndex) : null;
            return (nextImmediateFrame!=null? nextImmediateFrame.getTotalOfTries(): 0) + nextFrame.getTotalOfTries();
        }else{
            return nextFrame.getTotalOfTries();
        }
    }

    public int getBonusScore(){
        int bonusScoreTotal = 0;
        ListIterator<BallingFrame> framesIterator = gameFrames.listIterator();
        while(framesIterator.hasNext()){
            BallingFrame ballingFrame =   framesIterator.next();
            if(ballingFrame.isSpareFrame()){ // spare frame!
                  BallingFrame nextFrame =   getNextBallingFrame(framesIterator);
                  int nextBawlScore = (nextFrame!=null) ? nextFrame.getTriesList().get(0).getKnockedNumberOfPins() : 0;
                  bonusScoreTotal = bonusScoreTotal + nextBawlScore;
            }else if(ballingFrame.isWithStrike()){ // strike!
                System.out.println("It's a strike!");
                int scoreFromNextTwo = getStrikeScore(framesIterator);// add the next two
                System.out.println("scoreFromNextTwo =>"+scoreFromNextTwo);
                bonusScoreTotal= bonusScoreTotal + scoreFromNextTwo;
              }
        }
        return bonusScoreTotal;
    }
    public int getTotalKnockedScore(){
       return this.gameFrames.stream().mapToInt(BallingFrame::getTotalOfTries).sum();
    }
    public int getScore(){
        if(this.gameFrames.stream().filter(BallingFrame::isWithStrike).count() == this.gameFrames.size())// Optional case
            return 300;
        return getTotalKnockedScore() + getBonusScore();
    }
}
