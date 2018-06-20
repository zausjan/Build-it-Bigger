package com.udacity.gradle.jokelib;


import java.util.Random;

public class Jokes{

    private static String[] jokes = {"My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
            "Can a kangaroo jump higher than a house? \nOf course, a house doesn’t jump at all.",
            "What is the difference between a snowman and a snowwoman?\nSnowballs."};

    public String[] getJokes(){
        return jokes;
    }

    public String getRandomJoke(){
        Random random = new Random();
        return jokes[random.nextInt(jokes.length)];
    }
}