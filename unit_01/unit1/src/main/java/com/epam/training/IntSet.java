package com.epam.training;

/**
 * IntSet aka Java standart BinSet.
 * <p>
 * Created by Ilya Kulakov on 02.02.17.
 * IntSet aka BitSet.
 */

public class IntSet {

    private long[] data = new long[1]; // contains main data
    private int arraySize;

    public IntSet() {
    }

    /**
     * @param data
     */
    private IntSet(long[] data) {
        this.data = data;
    }

    /**
     *Resize set if it`s enable
     * in case u try to insert  value grather than max value in set
     * @param valueToInput
     * @return
     */
    private long[] resizeData(int valueToInput) {
        if (valueToInput + 1 > data.length) {
            long[] newData = new long[valueToInput + 1];
            System.arraycopy(data, 0, newData, 0, data.length);
            return newData;
        }
        return data;
    }

    /**
     * Add new element to IntSet.
     *
     * @param value what will insert to IntSet
     * @throws ArrayIndexOutOfBoundsException when u try to insert value < 0
     */
    public void add(int value) throws ArrayIndexOutOfBoundsException {
        if (value < 0) throw new ArrayIndexOutOfBoundsException();
        data = resizeData(value / 64);
        data[value / 64] |= 1L << value % 64;
        setArraySize();
    }

    /**
     * Remove value from IntSet if available
     *
     * @param value
     */
    public void remove(int value) throws ArrayIndexOutOfBoundsException {
        if (value < 0 || arraySize < value) throw new IndexOutOfBoundsException();
        data[value / 64] &= ~(1L << value % 64);
    }

    /**
     * Check if value conntains in IntSet
     *
     * @param value
     * @return true if value contains in IntSet, false if value not contains in
     * the IntSet
     */
    public boolean contains(int value) {
        if (value < 0 || value > arraySize) {
            return false;
        }
        final long result = data[value / 64] & (1L << value % 64);
        return result != 0;
    }


    /**
     * @param set
     */
    public void union(IntSet set) {
        if (data.length > set.data.length) {
            set.data = set.resizeData(this.data.length - 1);
        }
        if (data.length < set.data.length) {
            this.data = this.resizeData(set.data.length - 1);
        }
        long[] newData = new long[this.data.length];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i] | set.data[i];
        }
        data = newData;
    }


    public void setArraySize() {
        this.arraySize = data.length * 64 - 1;
    }
}