package com.epam.training.task1;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya Kulakov on 05.03.17.
 */
public class ByteIOStreamss {
    private File file;
    private List<String> keys;
    private byte[] arrayOfSymbols;
    private Map<String, Integer> result;

    public ByteIOStreamss() {
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

    /**
     * Read .java file using Byte I\O Stream.
     * Shows reading result at the console
     */
    public void readFile() {
        keys = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(this.file)) { // i understand how to use try-with-resources )
            arrayOfSymbols = new byte[inputStream.available()];
            inputStream.read(arrayOfSymbols);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * read file which contains Java keywords
     */
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


    /**
     * Analyse file and count keywords.
     */
    public void analyseJavaFile() {
        String analyseMe = new String(arrayOfSymbols);
        result = new HashMap<>();
        for (String keyword : keys) {
            Pattern pattern = Pattern.compile(keyword);
            Matcher matcher = pattern.matcher(analyseMe);
            int counter = 0;
            while (matcher.find()) {
                counter++;
            }
            result.put(keyword, counter);
        }
    }

    public void writeResultToFile(String path) {
        File resultFile = new File(path);
        if (!resultFile.exists()) {
            try {
                if (resultFile.createNewFile()) {
                    System.out.println("Can`t create file!");
                }
                FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
                fileOutputStream.write(result.toString().getBytes());
            } catch (IOException e) {
                System.out.println("Problem with creating file at" + resultFile.getAbsolutePath());
                e.printStackTrace();
            }
        }
    }

    public List<String> getKeys() {
        return keys;
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
