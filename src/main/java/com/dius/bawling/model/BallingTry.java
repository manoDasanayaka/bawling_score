package com.dius.bawling.model;

public class BallingTry {

    private int  knockedNumberOfPins;
    private boolean isStrike = false;

    public BallingTry(int numberOfPins){
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
