package com.epam.training.task_1;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by Ilya Kulakov on 11.03.17.
 */
public class FSViewerTest {

    String rootPath;
    FSViewer fsViewer;

    @Before
    public void init() {
        fsViewer = new FSViewer(rootPath);
    }

    @Test(expected = FileNotFoundException.class)
    public void showItemsAtWrongPathTest() {
        fsViewer.showItems();
    }

    @Test
    public void showItemsAtPathTest() {
        fsViewer.showItems();
    }

    @Test
    public void createDirAtTest() {
        fsViewer.createDirHere("Path");
    }


}