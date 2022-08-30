package com.dius.bawling.util;

import com.dius.bawling.exception.BawlingException;
import com.dius.bawling.model.BallingFrame;
import com.dius.bawling.model.BallingTry;

import java.util.ArrayList;
import java.util.List;

public class BawlingBuilderUtil {
    public static BallingFrame generateBallingFrame(int try1, int try2) throws BawlingException {
        List<BallingTry> frameTries = new ArrayList<>();
        frameTries.add(new BallingTry(try1));
        frameTries.add(new BallingTry(try2));
        BallingFrame frame = new BallingFrame(frameTries);
        return  frame;
    }
   public static BallingFrame generateBallingFrame(int strikeTry) throws BawlingException {
        List<BallingTry> frameTries = new ArrayList<>();
        frameTries.add(new BallingTry(strikeTry));
        BallingFrame frame = new BallingFrame(frameTries);
        return  frame;
    }
}
