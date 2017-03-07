package com.epam.training.com.epam.training.office;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public class OfficeAccessories implements Cost {
    long cost;
    String manufactureName;

    public String getManufactureName() {
        return manufactureName;
    }

    public void setManufactureName(String manufactureName) {
        this.manufactureName = manufactureName;
    }


    @Override
    public long getCost() {
        return cost;
    }

    @Override
    public void setCost(long costInCoins) {

    }
}
