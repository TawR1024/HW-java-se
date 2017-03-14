package com.epam.training.task_2;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created by Ilya Kulakov on 13.03.17.
 */
public class UniversalPropertyLoaderTest {

    UniversalPropertyLoader loader;

    @Before
    public void init() {
        loader = new UniversalPropertyLoader();
        loader.loadBundle("catalog");
    }

    @Test
    public void loadBundleTest() {
        loader.loadBundle("clog");
    }

    @Test
    public void getKeyTest() {
        assertEquals("Крабовидная туманность", loader.getKey("M1")[0]);
    }

    @Test

    public void getWrongKeyTest() {
        assertEquals(null, loader.getKey("M111")[0]);
    }

}