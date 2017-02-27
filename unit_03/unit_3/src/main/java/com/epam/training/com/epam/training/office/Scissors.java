package com.epam.training.com.epam.training.office;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public class Scissors implements Cutting {
    @Override
    public OfficePaper[] cut(OfficePaper pieceOfPaper, int numberOfSections, CutDirection direction) {
        if (direction == CutDirection.ACROSS) {
            OfficePaper[] papers = new OfficePaper[numberOfSections];
            for (int i = 0; i < numberOfSections; i++) {
                papers[i].setWidth(pieceOfPaper.getWidth() / numberOfSections);

            }
            return papers;
        } else {
            OfficePaper[] papers = new OfficePaper[numberOfSections];
            for (int i = 0; i < numberOfSections; i++) {
                papers[i].setHeight(pieceOfPaper.getHeight() / numberOfSections);

            }
            return papers;

        }
    }
}
    enum CutDirection {
        ACROSS, ALONG
    }