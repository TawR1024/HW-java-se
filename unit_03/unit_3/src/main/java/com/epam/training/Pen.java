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
        return (int) ((manufactureName == null) ? 0 : (manufactureName.hashCode() + ((incColor == null) ? 0 : incColor.hashCode() * 47)));
    }

    public boolean myEquals(Object penToCompare) {
        if (this == penToCompare) {
            return true;
        }
        if (penToCompare == null) {
            return false;
        }

        if (getClass() != penToCompare.getClass()) {
            return false;
        }
        if (!this.manufactureName.equals(((Pen)penToCompare).getManufactureName())) {
            return false;
        } else {
            if(!this.incColor.equals(((Pen) penToCompare).getIncColor())){
                return false;
            }
        }
        return true;
    }

    // hashCode(), equals(), toString(); proposed By IDEA


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (!manufactureName.equals(pen.manufactureName)) return false;
        return incColor == pen.incColor;
    }

    @Override
    public int hashCode() {
        int result = manufactureName.hashCode();
        result = 31 * result + incColor.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "manufactureName='" + manufactureName + '\'' +
                ", incColor=" + incColor +
                '}';
    }
}

enum Color {RED, BLUE, GREEN, BLACK}
