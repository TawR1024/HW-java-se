package com.epam.training;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 05.02.17.
 */
public class IntArrayListTest{
    @Test
    public void upRisingMergeSort() throws Exception {
        int[] ints  = { 2,1,4,3,6,5};
        int[] expectedInts = {1,2,3,4,5,6};
        final IntArrayList list = new IntArrayList(ints);
        list.sort();
        for(int i = 0; i < 6;i++){
            System.out.println(list.get(i));
        }
    }

    @Test
    public void binarySearchWithRecomendedPalce() throws Exception {
        final int[] ints = {Integer.MIN_VALUE, -1, 0, 5, 3912, 12356, Integer.MAX_VALUE};
        final int[] expected = Arrays.copyOf(ints, ints.length);
        Arrays.sort(expected);

        final IntArrayList list = new IntArrayList(ints);
        assertEquals(4, list.binarySearchWithRecomendedPalce(6));
        assertEquals(6, list.binarySearchWithRecomendedPalce(Integer.MAX_VALUE-1));
    }

    @Test
    public void sort() throws Exception {
        final int[] ints = {12, 0, -13, 666, 2, 56, 56, 56, 120, -1, 1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        final int[] expected = Arrays.copyOf(ints, ints.length);
        Arrays.sort(expected);

        final IntArrayList list = new IntArrayList(ints);

        list.sort();

        for (int i = 0; i < expected.length; i++) {
            assertEquals("i = " + i, expected[i], list.get(i));
        }
    }


    @Test
    public void binarySearch() throws Exception {

//        final int[] ints = {12, 0, -13, 666, 2, 56, 56, 56, 120, -1, 1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        final int[] ints = {Integer.MIN_VALUE, -1, 0, 5, 3912, 12356, Integer.MAX_VALUE};
        final int[] expected = Arrays.copyOf(ints, ints.length);
        Arrays.sort(expected);

        final IntArrayList list = new IntArrayList(ints);

        list.sort();
        assertEquals(0, list.binarySearch(Integer.MIN_VALUE));
        assertEquals(-1, list.binarySearch(265));
        assertEquals(6, list.binarySearch(Integer.MAX_VALUE));

    }

}