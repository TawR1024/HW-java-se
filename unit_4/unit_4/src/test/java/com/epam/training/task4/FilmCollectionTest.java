package com.epam.training.task4;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 06.03.17.
 */
public class FilmCollectionTest {

    FilmCollection filmCollection;
    Actor actor1;
    Actor actor2;
    Actor actor3;
    Film film3;

    @Before
    public void init() {
        filmCollection = new FilmCollection("MyCollection");
        actor1 = new Actor("Bob", 15);
        actor2 = new Actor("Jack", 89);
        actor3 = new Actor("John", 45);
        film3 = new Film("Kin-dza-dza", "genre 2");
    }

    @Test
    public void saveCollectionAsFile() throws Exception {
        Film film1 = new Film("Film Name 1", "comedy");
        Film film2 = new Film("Film name 2", "genre 1");
        filmCollection.addFilm(film1, actor1);
        filmCollection.addFilm(film2, actor2);
        filmCollection.addFilm(film3, actor3);
        filmCollection.saveCollectionAsFile("src/main/resources/task_4.serialized");
    }

    @Test
    public void AddToCollectionOneFilmWithThreeActors() {
        filmCollection.addFilm(film3, actor1, actor2, actor3);
    }


    @Test
    public void addToCollection() {
        Actor actor1 = new Actor("Bob", 15);
        Film film = new Film("Kin-dza-dza", "comedy");
        filmCollection.addFilm(film, actor1);
    }

    @Test(expected = NullPointerException.class)
    public void addEmptyArguments() {
        Actor actor = null;
        Film film = null;
        filmCollection.addFilm(film, actor);
    }

@Test

    public  void openCollectionFromTest(){
       FilmCollection fc =  filmCollection.openCollectionFrom("src/main/resources/task_4.serialized");
    System.out.println(fc.toString());

}

}