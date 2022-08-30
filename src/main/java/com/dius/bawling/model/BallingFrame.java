package com.dius.bawling.model;

import com.dius.bawling.exception.BawlingException;

import java.util.List;

public class BallingFrame {

    private List<BallingTry> triesList;

    public BallingFrame(List<BallingTry> triesList) throws BawlingException {
        this.triesList = triesList;
        this.populateFrame();
    }

    private boolean isSpareFrame;

    private boolean isWithStrike;

    public List<BallingTry> getTriesList() {
        return triesList;
    }

    public void setTriesList(List<BallingTry> triesList) {
        this.triesList = triesList;
    }



    public int getTotalOfTries(){
        return this.triesList.stream().mapToInt(BallingTry::getKnockedNumberOfPins).sum();
    }


    public void populateFrame() throws BawlingException {
        if(this.getTriesList() == null || this.getTriesList().size() > 2 || this.getTriesList().size() == 0)
            throw new BawlingException("Only two or less tries for a Frame!");
        int totalKnocked = this.getTotalOfTries();
        if(this.triesList.size() == 1 && totalKnocked == 10){
            setWithStrike(true);
        }else if( totalKnocked == 10){ //spare frame.
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
