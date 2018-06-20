package com.udacity.gradle.builditbigger.backend;

import com.udacity.gradle.jokelib.Jokes;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    public String getJoke(){
        Jokes jokes  = new Jokes();
        return jokes.getRandomJoke();
    }
}