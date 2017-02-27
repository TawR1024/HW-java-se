package com.epam.training.com.epam.training.office;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public class Scissors extends OfficeAccessories implements Cutting {
    public  Scissors() {}
    public Scissors(String manufatureName, long cost) {
            this.manufactureName = manufatureName;
            this.cost = cost;
    }

    @Override
    public OfficePaper[] cut(OfficePaper pieceOfPaper, int numberOfSections, CutDirection direction) throws ArithmeticException {
        if (numberOfSections <= 0) {
            throw new ArithmeticException("Can not devide by null. At " + getClass().getName() + " constructor " +
                    "numberOfSections expected notNull but was " + numberOfSections);
        }
        OfficePaper[] papers = new OfficePaper[numberOfSections];
        if (direction == CutDirection.ACROSS) {
            for (int i = 0; i < numberOfSections; i++) {
                int newWidth = pieceOfPaper.getWidth() / numberOfSections;
                System.out.println(newWidth);
                OfficePaper newPaper = new OfficePaper(pieceOfPaper.getManufactureName(),
                        pieceOfPaper.getWidth() / numberOfSections,
                        pieceOfPaper.getHeight());
                papers[i] = newPaper;

            }
        } else {
            for (int i = 0; i < numberOfSections; i++) {
                int newWidth = pieceOfPaper.getHeight() / numberOfSections;
                System.out.println(newWidth);
                OfficePaper newPaper = new OfficePaper(pieceOfPaper.getManufactureName(),
                        pieceOfPaper.getWidth(), pieceOfPaper.getHeight() / numberOfSections);
                papers[i] = newPaper;
            }
        }
        return papers;
    }
}

enum CutDirection {
    ACROSS, ALONG
}