package com.example.boo.hellomvp.mvp.models;

import com.example.boo.hellomvp.mvp.CounterMVP;

/**
 * Created by boo on 26.09.17.
 */

public class CounterModel implements CounterMVP.Model{
    private int counter;

    public CounterModel(int initCounter) {
        counter = initCounter;
    }

    public CounterModel(){
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