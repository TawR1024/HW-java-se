package com.epam.training.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ilya Kulakov on 05.03.17.
 */
public class ByteIOStreamss {
    private File file;
    private StringBuilder fromFile;
    private List<String> keys;

    public ByteIOStreamss(){
        keys = new ArrayList<>();
    }

    public void openFile(String pathFile) {
        file = new File(pathFile);
        try {
            if (!file.exists())
                throw new FileNotFoundException("File in " + file.getAbsolutePath() + " not found");
            else System.out.println("File successful opened");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void readFile() {
        try {
            FileInputStream inputStream = new FileInputStream(this.file);
            fromFile = new StringBuilder();
            int charFromStream;
            while ((charFromStream = inputStream.read()) != -1) {
                fromFile.append((char)charFromStream);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File at path " + file.getAbsolutePath() + " not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(fromFile.toString());
    }

        public void getBasicKeyWords() {
            try {
                FileInputStream fileInputStream = new FileInputStream("src/main/resources/JavaKeyWords");
                Scanner scanner = new Scanner(fileInputStream);
                while (scanner.hasNext()) {
                    keys.add(scanner.next());
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }


    public List<String> getKeys() {
        return keys;
    }
}
