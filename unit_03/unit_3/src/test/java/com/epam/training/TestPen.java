package com.epam.training;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Ilya Kulakov on 23.02.17.
 */
public class TestPen {


    @Test
    public void createPenObjectPenUsingDefaultConsructorTest(){
        assertNotNull(new Pen());
    }

    @Test
    public void createPenObjectTest() {
        assertNotNull(new Pen("Parker", Color.BLACK));
    }

    @Test

    public  void myToStringMethodTest() {
        Pen myPen = new Pen("Parker", Color.GREEN);
        System.out.println(myPen.myToString());
    }
}
