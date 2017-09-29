package com.example.boo.hellomvp;

/**
 * Created by boo on 26.09.17.
 */

public class Model {
    private int counter;

    public Model(int initCounter) {
        counter = initCounter;
    }

    public Model(){
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void increaseCounter() {
        counter++;
    }

    public void decreaseCounter() throws Exception {
        //Business logic here
        if(counter > 0)
            counter--;
        else throw new Exception("Warning! Can't set negative count.");
    }
}