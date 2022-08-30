package com.dius.bawling.model;

import com.dius.bawling.exception.BawlingException;

import java.util.List;
import java.util.ListIterator;

import static com.dius.bawling.constants.IBawlingGameConstants.NUMBER_OF_FRAMES_PER_GAME;

/**
 *  Denotes a Game, game contains a list of {@linkplain BawlingFrame}
 */
public class BawlingGame {

    private List<BawlingFrame> gameFrames;

    public List<BawlingFrame> getGameFrames() {
        return gameFrames;
    }

    /**
     *
     * @param gameFrames
     * @throws BawlingException when the passed in list of Frames are empty, null or having more than maximum capacity.(10)
     */
    public void setGameFrames(List<BawlingFrame> gameFrames) throws BawlingException {
        if(gameFrames == null || gameFrames.size() !=  NUMBER_OF_FRAMES_PER_GAME)
            throw new BawlingException("Only 10  frames per Game!");
        this.gameFrames = gameFrames;
    }

    /**
     * Get the next {@linkplain BawlingFrame} from the passed in iterator.
     * It will return null if it is the last element.
     * @param framesIterator
     * @return
     */
    public BawlingFrame getNextBallingFrame(ListIterator<BawlingFrame> framesIterator){
        int nextIndex =   framesIterator.nextIndex();
        if(nextIndex == 10)
            return  null;
        return gameFrames.get(nextIndex);
    }

    /**
     * Returns the Strike score for a given Iterator of {@linkplain BawlingFrame}
     * @param framesIterator Iterator of {@linkplain BawlingFrame}
     * @return The score of Strike hit.
     */
    public int getStrikeScore(ListIterator<BawlingFrame> framesIterator){
        int nextIndex =   framesIterator.nextIndex();
        if(nextIndex == NUMBER_OF_FRAMES_PER_GAME)
            return  0;
        BawlingFrame nextFrame = gameFrames.get(nextIndex);
        if(nextFrame.isWithStrike()){
            int nextImmediateIndex = nextIndex+1;
            BawlingFrame nextImmediateFrame = (nextImmediateIndex < gameFrames.size()) ? gameFrames.get(nextImmediateIndex) : null;
            return (nextImmediateFrame!=null? nextImmediateFrame.getTotalOfTries(): 0) + nextFrame.getTotalOfTries();
        }else{
            return nextFrame.getTotalOfTries();
        }
    }

    /**
     * Returns the total Bonus score for the Game.
     *
     * @return
     */
    public int getBonusScore(){
        int bonusScoreTotal = 0;
        ListIterator<BawlingFrame> framesIterator = gameFrames.listIterator();
        while(framesIterator.hasNext()){
            BawlingFrame bawlingFrame =   framesIterator.next();
            if(bawlingFrame.isSpareFrame()){ // spare frame!
                System.out.println("***********It's a Spare!****************");

                  BawlingFrame nextFrame =   getNextBallingFrame(framesIterator);
                  int nextBawlScore = (nextFrame!=null) ? nextFrame.getTriesList().get(0).getKnockedNumberOfPins() : 0;
                System.out.println("scoreFromNext =>"+nextBawlScore);
                  bonusScoreTotal = bonusScoreTotal + nextBawlScore;
            }else if(bawlingFrame.isWithStrike()){ // strike!
                System.out.println("****************It's a strike!*****************");
                int scoreFromNextTwo = getStrikeScore(framesIterator);// add the next two
                System.out.println("scoreFromNextTwo =>"+scoreFromNextTwo);
                bonusScoreTotal= bonusScoreTotal + scoreFromNextTwo;
              }
        }
        return bonusScoreTotal;
    }

    /**
     * Get the total knocked pins for this Game.
     * It collects all the knocked number of pins from all frames played for this Game.
     * @return
     */
    public int getTotalKnockedScore(){
       return this.gameFrames.stream().mapToInt(BawlingFrame::getTotalOfTries).sum();
    }

    /**
     * Main method to get the score of the Game.
     * It is the combination of Bonus score and knocked down pins score.
     *
     * @return The score of the Game.
     */
    public int getScore(){
        if(this.gameFrames.stream().filter(BawlingFrame::isWithStrike).count() == this.gameFrames.size())// Optional case
            return 300;
        return getTotalKnockedScore() + getBonusScore();
    }
}
