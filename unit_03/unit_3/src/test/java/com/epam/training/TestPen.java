package com.epam.training;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Ilya Kulakov on 23.02.17.
 */
public class TestPen {


    @Test
    public void createPenObjectPenusingDefaultConsructorTest(){
        assertNotNull(new Pen());
    }
}
