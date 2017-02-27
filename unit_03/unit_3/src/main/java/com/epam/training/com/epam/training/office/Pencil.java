package com.epam.training.com.epam.training.office;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public class Pencil implements Writable {

    private long cost;
    private String manufactureName;

    public Pencil(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    @Override
    public void write(String text, OfficePaper pieceOfPaper) {
        pieceOfPaper.setText(pieceOfPaper.getText() + text);
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public Pencil(long cost, String manufactureName) {
        this.cost = cost;
        this.manufactureName = manufactureName;
    }
}
