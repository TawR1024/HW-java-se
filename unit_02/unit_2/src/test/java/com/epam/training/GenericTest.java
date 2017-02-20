package com.epam.training;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Ilya Kulakov on 16.02.17.
 */
public class GenericTest {
    @Test
    public void showType() throws Exception {
        Generic<Number> integerGen = new Generic<>(1234.);
        integerGen.showType();
        assertNotNull(integerGen);
    }
}