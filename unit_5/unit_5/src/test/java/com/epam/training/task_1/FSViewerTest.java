package com.epam.training.task_1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Ilya Kulakov on 11.03.17.
 */
public class FSViewerTest {

    String rootPath = "/home/ilya-kulakov/";
    FSViewer fsViewer;

    @Before
    public void init() {
        fsViewer = new FSViewer(rootPath);
    }

    @Test
    public void showItemsAtWrongPathTest() throws FileNotFoundException {
        String input = "/run";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        fsViewer.showItems();
    }

    @Test(expected = FileNotFoundException.class)
    //TODO: rewrite method.
    public void showItemsAtWrongPathThrowExTest() throws FileNotFoundException {
        String input = "/asdf";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        fsViewer.showItems();
    }

    @After
    public void returnSettings() {
        System.setIn(System.in);
    }

    @Test
    public void showItemsAtPathTest() throws FileNotFoundException {
        fsViewer.showItems();
    }

    @Test
    public void createDirAtTest() {
        //:TODO test logic
        fsViewer.createDirHere(fsViewer.getPath(), "TEstDir");
    }


}