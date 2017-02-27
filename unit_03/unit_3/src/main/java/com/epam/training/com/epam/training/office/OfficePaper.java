package com.epam.training.com.epam.training.office;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public class OfficePaper extends OfficeAccessories implements Cost {
    private long costInCoins;
    private int width;
    private int height;
    private String text;

    public OfficePaper() {
    }

    public OfficePaper(String manufactureName) {
        this.manufactureName = manufactureName;
    }

    public OfficePaper(String manufactureName, long costInCoins) {
        this.manufactureName = manufactureName;
        this.costInCoins = costInCoins;
    }

    public OfficePaper(String manufactureName, int width, int heght) {
        this.manufactureName = manufactureName;
        this.width = width;
        this.height = height;
    }

    public OfficePaper(String manufactureName, long costInCoins, int width, int height) {
        this.manufactureName = manufactureName;
        this.costInCoins = costInCoins;
        this.width = width;
        this.height = height;
    }

    @Override
    public long getCost() {
        return costInCoins;
    }

    @Override
    public void setCost(long costInCoins) {
        this.costInCoins = costInCoins;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
