package com.example.boo.hellomvp;

/**
 * Created by boo on 26.09.17.
 */

public class PresenterCounter implements Presenter {
    private Model model;
    private View view;

    @Override
    public void increaseCounter() {
        model.increaseCounter();
        //TODO: можно исключить из обратной логики участие presenter при помощи callback функции
        view.updateCounter(model.getCounter());
    }



    @Override
    public void decreaseCounter() {
        try {
            model.decreaseCounter();
            //TODO: можно исключить из обратной логики участие presenter при помощи callback функции
            view.updateCounter(model.getCounter());
        } catch (Exception e) {
            view.showNotification(e.getMessage());
        }
    }

    @Override
    public void setBaseCounter() {
        view.updateCounter(model.getCounter());
    }

    public PresenterCounter(View view) {
        this.view = view;
        model = prepareModel();
    }

    /**
     * Именно приготовить модель т.к. её состояние в будущем может где-то храниться.
     * Тогда будет легче менять логику.
     *
     * @return
     */
    private Model prepareModel() {
        return new Model();
    }


}
