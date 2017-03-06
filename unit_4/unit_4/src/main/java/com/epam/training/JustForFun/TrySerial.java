package com.epam.training.JustForFun;

import java.io.*;

/**
 * Created by Ilya Kulakov on 02.03.17.
 */
public class TrySerial {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream  =    new FileOutputStream("myObject.out");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            TrySerializ serializ = new TrySerializ();
            objectOutputStream.writeObject(serializ);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "File not found ex");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("myObject.out");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            TrySerializ trySerializ = (TrySerializ) objectInputStream.readObject();
            System.out.println(trySerializ.aChar + " " + trySerializ.anInt);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
