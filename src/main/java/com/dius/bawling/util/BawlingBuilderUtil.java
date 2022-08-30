package com.dius.bawling.util;

import com.dius.bawling.exception.BawlingException;
import com.dius.bawling.model.BawlingFrame;
import com.dius.bawling.model.BawlingTry;

import java.util.ArrayList;
import java.util.List;

public class BawlingBuilderUtil {
    public static BawlingFrame generateBallingFrame(int try1, int try2) throws BawlingException {
        List<BawlingTry> frameTries = new ArrayList<>();
        frameTries.add(new BawlingTry(try1));
        frameTries.add(new BawlingTry(try2));
        BawlingFrame frame = new BawlingFrame(frameTries);
        return  frame;
    }
   public static BawlingFrame generateBallingFrame(int strikeTry) throws BawlingException {
        List<BawlingTry> frameTries = new ArrayList<>();
        frameTries.add(new BawlingTry(strikeTry));
        BawlingFrame frame = new BawlingFrame(frameTries);
        return  frame;
    }
}
