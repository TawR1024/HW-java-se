package com.epam.training.task_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class used to navigate at file System
 * <p>
 * Can show directories (folders) and file at current path.
 * Can create and delete directories and files.
 * <p>
 * Created by Ilya Kulakov on 11.03.17.
 */
public class FSViewer {
    private String currentPath;


    public FSViewer() {
    }

    public FSViewer(String rootPath) {
        this.currentPath = rootPath;
    }

    /**
     * Print to screen list of items at current path
     */
    public void showItems() throws FileNotFoundException {
        String path = currentPath;
        if (path.isEmpty())
            setPath(getPathFromSystemIn());

        File dir = new File(path);

        if (!dir.exists())
            throw new FileNotFoundException("File at path: " + path + " not found!");

        if (!currentPath.equals("/")) {
            path += File.separator;
        }
        if (dir.isDirectory()) {
            for (String fileName : dir.list()) {
                File file = new File(path + fileName);
                System.out.println(file.isDirectory() ? (fileName + " d") :
                        file.isFile() ? (fileName + " f") : fileName + " not file or dir");
            }
        }

    }

    /**
     * @return strinf
     * @throws FileNotFoundException
     */
    private String getPathFromSystemIn() throws FileNotFoundException {
        System.out.println("Wrong path. Pleas enter again\n");
        Scanner scanner = new Scanner(System.in);
        String newPath = scanner.nextLine();
        File file = new File(newPath);
        if (!file.exists()) {
            throw new FileNotFoundException("At path" + newPath);
        }
        return newPath;
    }

    /**
     * @param path
     * @param name
     */
    public void createDirHere(String path, String name) {
        StringBuilder nameOfDirectory = new StringBuilder(path).append(File.separator).append(name);

        File directoryToCreate = new File(nameOfDirectory.toString());

        if (!directoryToCreate.exists()) {
            directoryToCreate.mkdir();
        }

    }


    /**
     * Create file at path transmitted at parameters
     * @param path where file will be created
     * @param name name of file
     */
    public void createFileAt(String path, String name) {
        StringBuilder nameOfFile = new StringBuilder(path).append(File.separator).append(name);
        File fileToCreate = new File(nameOfFile.toString());
        if (!fileToCreate.exists()) {
            try {
                fileToCreate.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Append text to file in path
     *
     * @param path - absolute file name (path + name)
     * @param text to append to the file
     */
    public void addTextToFile(String path, String text) {
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            if (!Files.isWritable(Paths.get(file.getAbsolutePath()))) {
                throw new AccessDeniedException("Cannot Write to file invalid licence");
            }
            fileWriter.write(text + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setPath(String path) {
        this.currentPath = path;
    }

    public String getPath() {
        return currentPath;
    }
}
