package com.epam.training.task4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ilya Kulakov on 06.03.17.
 */
public class FilmCollectionTest {

    @Test
    public void addToCollection(){
        FilmCollection filmCollection = new FilmCollection("MyCollection");
        Actor actor1 = new Actor("Bob", 15);
        Film film = new Film("Kin-dza-dza", "comedy");

        filmCollection.addFilm(film, actor1);
    }

}