package com.epam.training;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Ilya Kulakov on 11.02.17.
 */
public class IntSetTest {
    @Test
    public void add() throws Exception {
        IntSet set = new IntSet();
        set.add(6);
        set.add(394);
        set.add(687);
        set.add(0);
        try{
            set.add(Integer.MAX_VALUE);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Try insert too big number");
        }

        try{
            set.add(Integer.MIN_VALUE);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Try insert negative number");
        }
    }

    @Test
    public void remove() throws Exception {
        IntSet intSet = new IntSet();
        intSet.add(0);
        intSet.add(48);
        intSet.add(68);
        intSet.add(354);

        intSet.remove(0);
        intSet.remove(48);
        intSet.remove(354);
        intSet.remove(54);


        assertTrue(intSet.contains(68));

        assertFalse(intSet.contains(0));
        assertFalse(intSet.contains(48));
        assertFalse(intSet.contains(354));
        assertFalse(intSet.contains(54));
    }

    @Test
    public void contains() throws Exception {
        IntSet intSet = new IntSet();
        intSet.add(6);
        intSet.add(394);
        intSet.add(687);
        intSet.add(0);
        try {
            intSet.add(Integer.MAX_VALUE);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Try insert too big number");
        }


        assertTrue(intSet.contains(6));
        assertTrue(intSet.contains(394));
        assertTrue(intSet.contains(687));
        assertTrue(intSet.contains(0));


        assertFalse(intSet.contains(8));
        assertFalse(intSet.contains(56));
        assertFalse(intSet.contains(99999999));
        assertFalse(intSet.contains(1568));
        assertFalse(intSet.contains(Integer.MIN_VALUE));
    }

    @Test
    public void union() throws Exception {
        IntSet intSet = new IntSet();
        IntSet subSet = new IntSet();

        intSet.add(1);// case when intSet > subSet
        intSet.add(326); //2

        subSet.add(0); //1
        subSet.add(62);

        intSet.union(subSet);

        assertTrue(intSet.contains(62));
        assertTrue(intSet.contains(0));

        intSet.remove(1);
        intSet.remove(326);
        subSet.remove(0);
        subSet.remove(62);
//            case when intSet < subSet
        intSet.add(0);
        intSet.add(3);

        subSet.add(56);
        subSet.add(72);

        intSet.union(subSet);

        assertTrue(intSet.contains(3));
        assertTrue(intSet.contains(56));
        assertTrue(intSet.contains(72));

    }

}