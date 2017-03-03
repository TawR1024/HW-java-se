package com.epam.training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Ilya Kulakov on 03.03.17.
 */
public class ArithmeticExample {
    public static void main(String[] args) {
        int d, a = 5;
        try {
            d = a / 0;
            System.out.println(d);
            FileInputStream fileInputStream = new FileInputStream("a");
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println(e.getClass());
        }catch (ArithmeticException e) {
            System.out.println(e.getClass());
        }



    }
}
