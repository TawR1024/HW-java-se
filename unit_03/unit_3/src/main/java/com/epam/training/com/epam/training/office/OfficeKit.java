package com.epam.training.com.epam.training.office;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public class OfficeKit extends OfficeAccessories {

    @Override
    public long getCost() {
        return cost;
    }

    long cost;
    private List<OfficeAccessories> items = new ArrayList<>();

    public <T extends OfficeAccessories> void addItem(T item) {
        items.add(item);
        System.out.println(item.getCost());
        this.cost = this.cost + item.getCost();
    }

    public List<OfficeAccessories> getFullKit() {
        List<OfficeAccessories> newKit = items;
        return newKit;
    }
}
