package com.epam.training.task_2;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Ilya Kulakov on 13.03.17.
 */
public class UniversalPropertyLoader {

    String resource;

    public UniversalPropertyLoader() {
    }

    public UniversalPropertyLoader(String resourceName) {
        this.resource = resourceName;
    }


    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void loadBundle(String resourceName) {
        Locale locale = new Locale("ru_Ru");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("catalog", locale);
        List<String> keys = Collections.list(resourceBundle.getKeys());
        for (String s : keys) {
            System.out.println(s);
        }
    }
}
