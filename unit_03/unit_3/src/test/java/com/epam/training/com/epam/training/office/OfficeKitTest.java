package com.epam.training.com.epam.training.office;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public class OfficeKitTest {
    @Test
    public void addItemTest() throws Exception {
        OfficeKit officeKit = new OfficeKit();
        Pencil pencil = new Pencil("Luxar", 700);
        Pencil pencil2 = new Pencil("Luxar", 800);
        officeKit.addItem(pencil);
        officeKit.addItem(pencil2);
        assertEquals(1500, officeKit.getCost());

    }

    @Test
    public void getFullKit() throws Exception {
        OfficeKit officeKit = new OfficeKit();
        Pencil pencil = new Pencil("Luxar", 700);
        Scissors scissors = new Scissors("Citizen", 2365);
        officeKit.addItem(pencil);
        officeKit.addItem(scissors);

        List<OfficeAccessories> a = officeKit.getFullKit();
        for (OfficeAccessories i : a) {
            System.out.println(i);
        }

    }

}