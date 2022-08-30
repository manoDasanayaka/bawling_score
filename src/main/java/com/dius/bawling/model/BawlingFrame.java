package com.dius.bawling.model;

import com.dius.bawling.exception.BawlingException;

import java.util.List;

import static com.dius.bawling.constants.IBawlingGameConstants.NUMBER_OF_PINS_PER_FRAME;
import static com.dius.bawling.constants.IBawlingGameConstants.NUMBER_OF_TRIES_PER_FRAME;

/**
 * Denotes a Bawling frame.
 * It contains a list of {@linkplain BawlingTry}.
 */
public class BawlingFrame {

    private List<BawlingTry> triesList;

    public BawlingFrame(List<BawlingTry> triesList) throws BawlingException {
        this.triesList = triesList;
        this.populateFrame();
    }

    private boolean isSpareFrame;

    private boolean isWithStrike;

    public List<BawlingTry> getTriesList() {
        return triesList;
    }

    public void setTriesList(List<BawlingTry> triesList) {
        this.triesList = triesList;
    }



    public int getTotalOfTries(){
        return this.triesList.stream().mapToInt(BawlingTry::getKnockedNumberOfPins).sum();
    }

    /**
     * Flags the frame is with a Strike hit or Spare.
     * @throws BawlingException when empty tries list or more than two tries.
     */
    public void populateFrame() throws BawlingException {
        if(this.getTriesList() == null || this.getTriesList().size() > NUMBER_OF_TRIES_PER_FRAME || this.getTriesList().size() == 0)
            throw new BawlingException("Only two or less tries for a Frame!");
        int totalKnocked = this.getTotalOfTries();
        if(this.triesList.size() == 1 && totalKnocked == NUMBER_OF_PINS_PER_FRAME){
            setWithStrike(true);
        }else if( totalKnocked == NUMBER_OF_PINS_PER_FRAME){ //spare frame.
            setSpareFrame(true);
        }
    }

    public boolean isSpareFrame() {
        return isSpareFrame;
    }

    public void setSpareFrame(boolean spareFrame) {
        isSpareFrame = spareFrame;
    }

    public boolean isWithStrike() {
        return isWithStrike;
    }

    public void setWithStrike(boolean withStrike) {
        isWithStrike = withStrike;
    }
}
