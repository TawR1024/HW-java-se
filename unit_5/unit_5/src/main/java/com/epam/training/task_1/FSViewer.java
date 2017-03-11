package com.epam.training.task_1;

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
    private String path;


    public FSViewer() {
    }

    public FSViewer(String rootPath) {
        this.path = rootPath;
    }

    /**
     * Print to screen list of items at current path
     */
    public void showItems() {
        if (path == null) {
            System.out.println("Wrong path. Pleas enter again\n");
            setPath(getPathFromSystemIn());
        }
    }

    private String getPathFromSystemIn() {
        Scanner scanner = new Scanner(System.in);
        String newPath = scanner.nextLine();
        return newPath;
    }

    public void createDirHere(String path) {

        throw new UnsupportedOperationException();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


}
