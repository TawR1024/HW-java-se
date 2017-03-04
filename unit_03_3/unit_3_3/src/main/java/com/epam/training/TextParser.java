package com.epam.training;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ilya Kulakov on 04.03.17.
 */
public class TextParser {
    File fileToParse;

    public void openFile(String filePath) {
        fileToParse = new File(filePath);
    }

    public void parseFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileToParse),"utf-8"));
            while (bufferedReader.readLine()!=null){
               showSentenseWithRegExp("([\\.!?]|^)((([Рр]ис\\.\\s?(\\d+))|[^\\.!?])+[\\.!?])", bufferedReader.readLine());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("File at path " + fileToParse.getAbsolutePath()+ " not found" );
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSentenseWithRegExp(String pattern, String toMatch) {
        Pattern compilePattern = Pattern.compile(pattern);
        Matcher matcher = compilePattern.matcher(toMatch);
        if (matcher.find())
            System.out.println(matcher);
    }
}
