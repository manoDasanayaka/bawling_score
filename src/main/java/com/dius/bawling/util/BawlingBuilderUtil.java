package com.dius.bawling.util;

import com.dius.bawling.exception.BawlingException;
import com.dius.bawling.model.BawlingFrame;
import com.dius.bawling.model.BawlingTry;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to hold all the common util methods.
 */
public class BawlingBuilderUtil {
    /**
     * Generates a {@linkplain BawlingFrame} with two tries {@linkplain BawlingTry}.
     * @param try1 Number of knocked pins from Try #1
     * @param try2 Number of knocked pins from Try #2
     * @return {@linkplain BawlingFrame}.
     * @throws BawlingException
     */
    public static BawlingFrame generateBallingFrame(int try1, int try2) throws BawlingException {
        List<BawlingTry> frameTries = new ArrayList<>();
        frameTries.add(new BawlingTry(try1));
        frameTries.add(new BawlingTry(try2));
        BawlingFrame frame = new BawlingFrame(frameTries);
        return  frame;
    }

    /**
     * Generates a {@linkplain BawlingFrame} with a Strike hit. So it contains only one number. Should be only 10.
     * @param strikeTry Strike value.
     * @return {@linkplain BawlingFrame}.
     * @throws BawlingException
     */
   public static BawlingFrame generateBallingFrame(int strikeTry) throws BawlingException {
        List<BawlingTry> frameTries = new ArrayList<>();
        frameTries.add(new BawlingTry(strikeTry));
        BawlingFrame frame = new BawlingFrame(frameTries);
        return  frame;
    }
}
