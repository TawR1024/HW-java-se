package com.epam.training.task2;

import com.epam.training.task1.ByteIOStreamss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Ilya Kulakov on 07.03.17.
 */
public class SymbolStream extends ByteIOStreamss {
    public File file;
    private String fromFile;
    private List<String> keysWords;
    private Map<String, Integer> result;

    @Override
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


    @Override
    public void readFile() {
        StringBuilder stringFromFile = new StringBuilder();
        try (FileReader reader = new FileReader(this.file)) {
            int charFromStream;
            do {
                charFromStream = reader.read();
                if (charFromStream >= 0) {
                    stringFromFile.append((char) charFromStream);
                }
            } while (charFromStream != -1);
            fromFile = stringFromFile.toString();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void analyseJavaFile() {

    }

    @Override
    public void writeResultToFile(String path) {

    }

    public void getBasicKeyWords() {
        try (FileReader fileReader = new FileReader("src/main/resources/JavaKeyWords")) {
            try (Scanner scanner = new Scanner(fileReader)) {
                while (scanner.hasNext()) {
                    System.out.println(scanner.next());
                    //keysWords.add(scanner.next());
                }
            }

            //scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
