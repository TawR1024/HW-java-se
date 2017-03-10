package com.epam.training.task2;

import com.epam.training.task1.ByteIOStreamss;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya Kulakov on 07.03.17.
 */
public class SymbolStream extends ByteIOStreamss {
    public File file;
    private String fromFile;
    public List<String> keyWords;
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
        result = new HashMap<>();
        for (String key : keyWords) {
            Pattern pattern = Pattern.compile(key);
            Matcher matcher = pattern.matcher(fromFile);
            int counter = 0;
            while (matcher.find()) {
                counter++;
            }
            result.put(key, counter);
        }
    }


    public void getBasicKeyWords() {
        try (FileReader fileReader = new FileReader("src/main/resources/JavaKeyWords")) {
            try (Scanner scanner = new Scanner(fileReader)) {
                keyWords = new ArrayList<>();
                while (scanner.hasNext()) {
                    keyWords.add(scanner.next());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeResultToFile(String path) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
