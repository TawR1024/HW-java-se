package com.epam.training.threads.task_3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by Ilya Kulakov on 30.03.17.
 */

public class UserResourceThread {
    private static int THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        SharedResource res = new SharedResource();
        List<IntegerSetterGetter> threadPool = new ArrayList<>();
        for (int i = 0; i < THREADS; i++)
            threadPool.add(new IntegerSetterGetter(String.valueOf(i + 1), res));


    }
}
