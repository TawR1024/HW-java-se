package com.epam.training.task_2;

import java.util.*;

/**
 * Created by Ilya Kulakov on 13.03.17.
 */
public class UniversalPropertyLoader {

    String resource;
    ResourceBundle resourceBundle;
    Map<String, String> hashMap = new HashMap<>();

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
        try {
            resourceBundle = ResourceBundle.getBundle("catalog", locale);
            List<String> keys = Collections.list(resourceBundle.getKeys());
            for (String key : keys) {
                hashMap.put(key, resourceBundle.getString(key));
            }
        } catch (MissingResourceException e) {
            System.out.println("Resource" + resourceName + "not found");
            e.printStackTrace();
        }
    }

    public String getKey(String key) {
        try {
            return hashMap.get(key);
        } catch (MissingResourceException e) {
            System.out.println("Ключ " + key + " не найден");
            e.printStackTrace();
            return null;
        }
    }
}
