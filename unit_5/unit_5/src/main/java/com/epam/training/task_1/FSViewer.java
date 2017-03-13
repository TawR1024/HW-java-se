package com.epam.training.task_1;

import java.io.File;
import java.io.FileNotFoundException;
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
        if (path == null)
            setPath(getPathFromSystemIn());

        File dir = new File(path);

        if (!dir.exists())
            setPath(getPathFromSystemIn());

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

    public void createDirHere(String path, String name) {
        StringBuilder nameOfir = new StringBuilder(path);
        nameOfir.append(File.separator).append(name);
        File directoryToCreate = new File(nameOfir.toString());
        if (!directoryToCreate.exists()) {
            directoryToCreate.mkdir();
        }

    }

    public void setPath(String path) {
        this.currentPath = path;
    }

    public String getPath() {
        return currentPath;
    }


}
