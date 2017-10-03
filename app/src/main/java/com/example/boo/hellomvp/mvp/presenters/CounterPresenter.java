package com.example.boo.hellomvp.mvp.presenters;

import com.example.boo.hellomvp.mvp.CounterMVP;
import com.example.boo.hellomvp.mvp.models.CounterModel;

/**
 * Created by boo on 26.09.17.
 */

public class CounterPresenter implements CounterMVP.Presenter {
    private CounterModel counterModel;
    private CounterMVP.View view;

    @Override
    public void increaseCounter() {
        counterModel.increaseCounter();
        //TODO: можно исключить из обратной логики участие presenter при помощи callback функции
        view.updateCounter(counterModel.getCounter());
    }



    @Override
    public void decreaseCounter() {
        try {
            counterModel.decreaseCounter();
            //TODO: можно исключить из обратной логики участие presenter при помощи callback функции
            view.updateCounter(counterModel.getCounter());
        } catch (Exception e) {
            view.showNotification(e.getMessage());
        }
    }

    @Override
    public void setBaseCounter() {
        view.updateCounter(counterModel.getCounter());
    }

    public CounterPresenter(CounterMVP.View view) {
        this.view = view;
        counterModel = prepareModel();
    }

    /**
     * Именно приготовить модель т.к. её состояние в будущем может где-то храниться.
     * Тогда будет легче менять логику.
     *
     * @return
     */
    private CounterModel prepareModel() {
        return new CounterModel();
    }


}
