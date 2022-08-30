package com.dius.bawling.exception;

public class BawlingException extends Exception{
    /**
     * Generic exception to denote erroneous scenarios.
     * @param message
     */
    public BawlingException(String message){
       super(message);
    }

}
