package com.dius.bawling.model;

/**
 * This is the model class to denote a Bawling Try
 */
public class BawlingTry {

    private int  knockedNumberOfPins;
    private boolean isStrike = false;

    public BawlingTry(int numberOfPins){
        if(numberOfPins == 10){
            setStrike(true);
        }
        this.knockedNumberOfPins = numberOfPins;
    }

    public int getKnockedNumberOfPins() {
        return knockedNumberOfPins;
    }

    public void setKnockedNumberOfPins(int knockedNumberOfPins) {
        this.knockedNumberOfPins = knockedNumberOfPins;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }
}
