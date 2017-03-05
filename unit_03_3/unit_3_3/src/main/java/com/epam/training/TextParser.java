package com.epam.training;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya Kulakov on 04.03.17.
 */
public class TextParser {
    File fileToParse;
    FileInputStream fileInputStream;

    public void openFile(String filePath) {
        fileToParse = new File(filePath);
    }

    public String readFile() {
        try {
            fileInputStream = new FileInputStream(fileToParse);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
            int data = inputStreamReader.read();
            StringBuilder stringFromFile = new StringBuilder();
            while (data != -1) {
                stringFromFile.append((char) data);
                data = inputStreamReader.read();
            }
            inputStreamReader.close();
            return stringFromFile.toString();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("File at path " + fileToParse.getAbsolutePath() + " not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void showSentenseWithRegExp(String pattern, String toMatch) {
        Pattern compilePattern = Pattern.compile(pattern);
        Matcher matcher = compilePattern.matcher(toMatch);
        if (matcher.find())
            System.out.println(matcher);
    }

    public void showStringsWithPictures(String stringsFromFile) {
            Pattern sentencePattern  = Pattern.compile("[A-ZA-Яa-zа-я].*[.!;?]");
            Pattern picture  = Pattern.compile("[Рр]ис\\. \\d?");

            Matcher sentenceMatcher = sentencePattern.matcher(stringsFromFile);
            Matcher pictureMatcher;

            StringBuilder stringBuilder = new StringBuilder();

            while (sentenceMatcher.find() != false) {
                pictureMatcher = picture.matcher(sentenceMatcher.group());
                if (pictureMatcher.find() != false) {
                    System.out.println(pictureMatcher);
                    stringBuilder.append("Sentence: " + pictureMatcher.group()+ "\n");
                }
            }

            String[] strings  = stringBuilder.toString().split("\n");
        for (String str: strings) {
            System.out.println(str);
        }

    }
}
