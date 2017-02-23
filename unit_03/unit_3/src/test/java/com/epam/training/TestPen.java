package com.epam.training;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Ilya Kulakov on 23.02.17.
 */
public class TestPen {


    @Test
    public void createPenObjectPenUsingDefaultConsructorTest() {
        assertNotNull(new Pen());
    }

    @Test
    public void createPenObjectTest() {
        assertNotNull(new Pen("Parker", Color.BLACK));
    }

    @Test
    public void myToStringMethodTest() {
        Pen myPen = new Pen("Parker", Color.GREEN);
        System.out.println(myPen.myToString());
    }

    @Test
    public void myHashCodeTest() {
        Pen myPen = new Pen();
        assertEquals(0, myPen.myHashCode());

        myPen.setIncColor(Color.GREEN);
        myPen.setManufactureName("Pelican");
        int hash = Color.GREEN.hashCode() + "Pelican".hashCode();
        System.out.println(myPen.hashCode());
        assertEquals(hash, myPen.myHashCode());
    }


}
