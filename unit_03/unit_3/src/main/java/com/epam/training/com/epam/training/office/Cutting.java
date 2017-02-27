package com.epam.training.com.epam.training.office;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public interface Cutting {
    OfficePaper[] cut(OfficePaper pieceOfPaper, int numberOfSections,CutDirection direction);
}
