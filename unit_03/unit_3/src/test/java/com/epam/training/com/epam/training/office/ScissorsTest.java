package com.epam.training.com.epam.training.office;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 27.02.17.
 */
public class ScissorsTest {
    @Test
    public void cut() throws Exception {
        Scissors scissors = new Scissors();
        OfficePaper paper = new OfficePaper("Svetocopy", 50000, 30, 65);
        OfficePaper[] papers = scissors.cut(paper, 2, CutDirection.ACROSS);
        assertEquals(15, papers[0].getWidth());
        assertEquals(papers[0].getWidth(), papers[1].getWidth());
    }

    @Test
    public void cutPaperWithNullSectionsTest() {

        Scissors scissors = new Scissors();
        OfficePaper paper = new OfficePaper("Svetocopy", 50000, 30, 65);
        try {
            OfficePaper[] papers = scissors.cut(paper, 0, CutDirection.ACROSS);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }
}