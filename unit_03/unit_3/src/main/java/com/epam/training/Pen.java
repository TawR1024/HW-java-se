package com.epam.training;

/**
 * Created by Ilya Kulakov on 21.02.17.
 */
public class Pen {
    private String manufactureName;
    private Color incColor;

    public Pen(){}

    public Pen(String manufactureName, Color incColor) {
        this.manufactureName = manufactureName;
        this.incColor = incColor;
    }


    public boolean isEmpty(){
        return false;
    }

}

enum Color {RED, BLUE, GREEN, BLACK};
