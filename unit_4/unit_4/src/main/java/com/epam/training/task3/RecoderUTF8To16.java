package com.epam.training.task3;

import java.io.*;

/**
 * Created by Ilya Kulakov on 06.03.17.
 */
public class RecoderUTF8To16 {
    private String path;
    File inputFile;
    StringBuilder rowsFromFile = new StringBuilder();

    public void decodeFileToUTF16() {
        try {
            File inputFile = new File("src/main/resources/CyrillicDocUTF8.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            String rows;
            while ((rows = reader.readLine()) != null) {
                rowsFromFile.append(rows).append("\n");
            }
            reader.close();
            System.out.println(rowsFromFile.toString());
            File outputFile = new File("src/main/resources/CyrillicDocUTF16.txt");
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-16"));

            writer.write(rowsFromFile.toString());
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
