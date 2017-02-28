package com.epam.training;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Locale;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Unix;

/**
 * Created by Ilya Kulakov on 28.02.17.
 */
public class QueezTest {
    @Test
    public void chooseLanguage() {
        Quize queez = new Quize("Math for children");
        queez.chaooseLanguage(new Locale("ru", "Ru", Unix));

    }
}
