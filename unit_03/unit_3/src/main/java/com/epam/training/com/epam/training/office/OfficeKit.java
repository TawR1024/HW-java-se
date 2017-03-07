package com.epam.training.com.epam.training.office;

import com.epam.training.Pen;

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
        this.cost = this.cost + item.getCost();
    }

    public List<OfficeAccessories> getFullKit() {
        List<OfficeAccessories> newKit = items;
        return newKit;
    }

    public <T extends OfficeAccessories> OfficeAccessories getTheMostEpensiveItem() {
        long maxCost=0;
        int index=0;
        for (OfficeAccessories i : items) {
            if(i.getCost() > maxCost) {
                maxCost = i.getCost();
                index++;
            }
        }
        return items.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OfficeKit officeKit = (OfficeKit) o;

        if (cost != officeKit.cost) return false;
        return items != null ? items.equals(officeKit.items) : officeKit.items == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (cost ^ (cost >>> 32));
        result = 31 * result + (items != null ? items.hashCode() : 0);
        return result;
    }
}
