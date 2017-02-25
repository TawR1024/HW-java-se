package com.epam.training;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 24.02.17.
 */
public class NuclearSubmarineTest {
    @Test
    public void swimmDistance() throws Exception {

    }

    @Test
    public void submarineEngineTest() {
       NuclearSubmarine submarine = new NuclearSubmarine("fish", 10);
        submarine.swimmDistance(5);
   }

}
