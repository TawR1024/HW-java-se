package com.epam.training;

/**
 * Created by Ilya Kulakov on 21.02.17.
 */
public class Pen {
    private String manufactureName;
    private Color incColor;

    public Pen() {
    }

    public Pen(String manufactureName, Color incColor) {
        this.manufactureName = manufactureName;
        this.incColor = incColor;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public void setIncColor(Color incColor) {
        this.incColor = incColor;
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public Color getIncColor() {
        return incColor;
    }

    public String myToString() {
        return getClass().getName() + '@' + "Manufacture: " + getManufactureName() + ", Inc Color: " + getIncColor();
    }

    public int myHashCode() {
        return (int) ((manufactureName == null) ? 0 : (manufactureName.hashCode() + ((incColor == null) ? 0 : incColor.hashCode())));
    }

}

enum Color {RED, BLUE, GREEN, BLACK}
