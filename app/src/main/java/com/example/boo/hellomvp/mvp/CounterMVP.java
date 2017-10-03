package com.example.boo.hellomvp.mvp;

/**
 * Created by boo on 04.10.17.
 */

public interface CounterMVP {
    interface Presenter {
        void increaseCounter();
        void decreaseCounter();
        void setBaseCounter();
    }

    interface View  {
        void updateCounter(int value);
        void showNotification(String message);
    }

    interface Model {
        int getCounter();
        void increaseCounter();
        void decreaseCounter() throws Exception;
    }
}
