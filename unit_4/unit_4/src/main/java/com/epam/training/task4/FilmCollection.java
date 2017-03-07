package com.epam.training.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ilya Kulakov on 06.03.17.
 */
public class FilmCollection implements Serializable {
    private HashMap<Film, List<Actor>> films;
    String nameOFCollection;

    public FilmCollection(String name) {
        this.nameOFCollection = name;
        films = new HashMap<>();
    }

    public FilmCollection() {
        films = new HashMap<>();
    }

    public void addFilm(Film film, Actor... actor) {
        if (film == null | actor == null)
            throw new NullPointerException("Empty argument");
        ArrayList actorsFromFilm = new ArrayList();
        for (Actor actorIN : actor) {
            actorsFromFilm.add(actorIN);
        }
        films.put(film, actorsFromFilm);
    }

    public void saveCollectionAsFile(String path) {
        File file = new File(path);

        try {
            if (!file.exists())
                throw new FileNotFoundException();
            ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream(file));
            serializer.writeObject(this);
            serializer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File at path " + file.getAbsolutePath() + " not exist!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FilmCollection openCollectionFrom(String path) {

        File fileToOpen = new File(path);
        try {
            if (!fileToOpen.exists())
                throw new FileNotFoundException();

            ObjectInputStream deserializer = new ObjectInputStream(new FileInputStream(fileToOpen));
            FilmCollection filmCollection  = (FilmCollection )deserializer.readObject();
            deserializer.close();
            return filmCollection;
        } catch (FileNotFoundException e) {
            System.out.println("File at path " + fileToOpen.getAbsolutePath() + " not exist!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
