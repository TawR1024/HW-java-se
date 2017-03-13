package com.epam.training.task_2;

import org.junit.Before;
import org.junit.Test;


/**
 * Created by Ilya Kulakov on 13.03.17.
 */
public class UniversalPropertyLoaderTest {

    UniversalPropertyLoader loader;

    @Before
    public void init() {
        loader = new UniversalPropertyLoader();
    }

    @Test
    public void loadBundleTest() {
        loader.loadBundle("catalog");
    }

}