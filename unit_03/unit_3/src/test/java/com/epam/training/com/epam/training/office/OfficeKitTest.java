package com.epam.training.com.epam.training.office;

import org.junit.Test;

import java.util.ArrayList;
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

        List<OfficeAccessories> expectedKit = new ArrayList<>();

        expectedKit.add(pencil);
        expectedKit.add(scissors);

        assertEquals(expectedKit, officeKit.getFullKit());
    }

    @Test
    public  void getTheMostExpensiveItemTest() {
        OfficeKit kit = new OfficeKit();
        Pencil pencil1 = new Pencil("Citizen1", 600);
        Pencil pencil2 = new Pencil("Citizen2", 984);
        Pencil pencil3 = new Pencil("Citizen3", 5);
        Pencil pencil4 = new Pencil("Citizen4", 39876485);
        Pencil pencil5 = new Pencil("Citizen5", 65);
        kit.addItem(pencil1);
        kit.addItem(pencil2);
        kit.addItem(pencil3);
        kit.addItem(pencil4);
        kit.addItem(pencil5);


        OfficeKit newKit = new OfficeKit();
        System.out.println(kit.getTheMostEpensiveItem().getManufactureName());

    }

}