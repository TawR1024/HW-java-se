package com.epam.training;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 06.03.17.
 */
public class RecoderUTF8To16Test {
    @Test
    public void decodeFileToUTF16() throws Exception {
        RecoderUTF8To16 recoderUTF8To16 = new RecoderUTF8To16();
        recoderUTF8To16.decodeFileToUTF16();
    }

}