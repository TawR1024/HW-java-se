package com.epam.training;

/**
 * Created by Ilya Kulakov on 16.02.17.
 */
public class Generic<T extends Number> {
    T ob;


    Generic(T o) {
        ob = o;
    }

    T getob() {
        return ob;
    }

    void showType() {
        System.out.println("Тип T: " + ob.getClass().getName());
    }

}
