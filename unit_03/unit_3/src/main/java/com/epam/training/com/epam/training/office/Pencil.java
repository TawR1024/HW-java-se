package com.epam.training.com.epam.training.office;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public class Pencil extends OfficeAccessories implements Writable {
    long cost;
    public Pencil(String manufactureName, long cost) {
        this.cost = cost;
        this.manufactureName = manufactureName;
    }
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

}
