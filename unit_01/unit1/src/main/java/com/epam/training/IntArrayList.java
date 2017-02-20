package com.epam.training;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntArrayList {
    private int[] data;
    private int size;

    public IntArrayList(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
        size = data.length;
    }

    public IntArrayList() {
        data = new int[10];
        size = 0;
    }

    /**
     * @param value
     */
    public void add(int value) {
        ensureCapasity(size + 1);
        data[size] = value;
        size += 1;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return data[i];
    }

    public int getSize() {
        return size;
    }

    /**
     * @return
     */
    public int maxValueInefficient() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return maxValueRec(data, 0, size);
    }

    private int maxValueRec(int[] data, int startInclusive, int endExlusive) {
        final int length = endExlusive - startInclusive;

        if (length == 1) {
            return data[startInclusive];
        } else if (length == 0) {
            return Integer.MIN_VALUE;
        }

        final int mid = startInclusive + length / 2;
        return Math.max(
                maxValueRec(data, startInclusive, mid),
                maxValueRec(data, mid, endExlusive)
        );
    }

    public void sort() {
        // mergeSort(data, 0, getSize(), new int[getSize()]);
        upRisingMergeSort(data,1);
    }


    /**
     * Expects collection to be sorted.
     *
     * @param value value to find in collection  @return index of the value or -indexToInsert - 1
     */
    public int binarySearch(int value) {
        return searcher(data, 0, data.length - 1, value);
    }

    /**
     * @param value
     * @return
     */
    public int binarySearchWithRecomendedPalce(int value) {
//        throw new UnsupportedOperationException();
        return seacherRecomendPlace(data, 0, data.length - 1, value);
    }

    /**
     * @param data
     * @param startInclusive
     * @param endExclusive
     * @param free
     */
    private static void mergeSort(int[] data, int startInclusive, int endExclusive, int[] free) {
        final int length = endExclusive - startInclusive;
        if (length <= 1) {
            return;
        }

        final int mid = startInclusive + length / 2;

        mergeSort(data, startInclusive, mid, free);
        mergeSort(data, mid, endExclusive, free);

        merger(data, startInclusive, mid, endExclusive, free);
    }

    /**
     * @param data
     * @param startInclusive
     * @param mid
     * @param endExclusive
     * @param free
     */
    private static void merger(int[] data, int startInclusive, int mid, int endExclusive, int[] free) {
        System.arraycopy(data, startInclusive, free, startInclusive, endExclusive - startInclusive);

        int i = startInclusive;
        int j = mid;
        for (int k = startInclusive; k < endExclusive; k++) {
            if (i >= mid) data[k] = free[j++];
            else if (j >= endExclusive) data[k] = free[i++];
            else if (free[i] < free[j]) data[k] = free[i++];
            else data[k] = free[j++];
        }
    }

    /**
     * @param requiredCapacity
     */
    private void ensureCapasity(int requiredCapacity) {
        if (requiredCapacity <= getCapacity()) {
            return;
        }
        final int newCapasity = Math.max(requiredCapacity, (getCapacity() * 3) / 2 + 1);
        data = Arrays.copyOf(data, newCapasity);
    }

    /**
     * @return
     */
    private int getCapacity() {
        return data.length;
    }

    /**
     * @param inputArray
     * @param startInclusive
     * @param endExlusive
     * @param searchingValue
     * @return
     */
    private int searcher(int[] inputArray, int startInclusive, int endExlusive, int searchingValue) {
        int middle = (startInclusive + endExlusive) / 2;
        if (endExlusive < startInclusive) {
            return -1;
        }
        if (searchingValue == inputArray[middle]) {
            return middle;
        } else if (searchingValue < inputArray[middle]) {
//            return binarySearch(inputArray, startInclusive, middle - 1, searchingValue);
            return searcher(inputArray, startInclusive, middle - 1, searchingValue);
        } else {
//            return binarySearch(inputArray, middle + 1, endExlusive, searchingValue);
            return searcher(inputArray, middle + 1, endExlusive, searchingValue);
        }
    }

    /**
     * @param inputArray
     * @param start
     * @param end
     * @param searchingValue
     * @return
     */
    private int seacherRecomendPlace(int[] inputArray, int start, int end, int searchingValue) {
        int middle = (start + end) / 2;
        if (end < start) {
            return end + 1;
        }
        if (searchingValue == inputArray[middle]) {
            return middle;
        } else if (searchingValue < inputArray[middle]) {
//            return binarySearch(inputArray, start, middle - 1, searchingValue);
            return seacherRecomendPlace(inputArray, start, middle - 1, searchingValue);
        } else {
//            return binarySearch(inputArray, middle + 1, end, searchingValue);
            return seacherRecomendPlace(inputArray, middle + 1, end, searchingValue);
        }
    }

    public void upRisingMergeSort(int[] data,int offset) {
        if (offset >=data.length) {
            return;
        }
        int[] newData = new int[data.length];
        for(int i=offset-1, j=i+1; i<data.length-1; i++, j++) {
            if(data[i]>data[j]) {
                newData[i] = data[j];
                newData[j]=data[i];
            }
        }
        data = newData;
        upRisingMergeSort(data,offset+1);
    }
}