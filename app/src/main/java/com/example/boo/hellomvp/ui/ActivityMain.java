package com.example.boo.hellomvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boo.hellomvp.R;
import com.example.boo.hellomvp.mvp.CounterMVP;
import com.example.boo.hellomvp.mvp.presenters.CounterPresenter;

/**
 * Created by boo on 26.09.17.
 */

public class ActivityMain extends AppCompatActivity implements CounterMVP.View {
    private CounterMVP.Presenter presenter;
    private Button incButton;
    private Button decButton;
    private TextView counterView;

    /**
     * Week 2 TODO:
     *
     * View (представления) и всё что с ними связано:
     *      XML и пользовательские элементы (кнопки, текст, ввод текста, картинки),
     *      получение с них информации
     *
     *      Size (dp, sp, px, %)
     *
     *      Layout (контейнеры)
     *
     *      Dialogs (получение с них информации)
     *
     *      Advanced: подключить пользовательский элемент с чужого github - кастомный
     *
     *      Вы ещё живы? Поговорить про второе Activity, цикл жизни Activity, поворот экрана.
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new CounterPresenter(this);

        //TODO: Gooogle "Butterknife" to make it simple, clever 
        incButton = (Button) findViewById(R.id.main_button_inc);
        decButton = (Button) findViewById(R.id.main_button_dec);
        counterView = (TextView) findViewById(R.id.main_counter);

        presenter.setBaseCounter();

        //TODO: Google "Retrolambda" to make it cleaner
        decButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                presenter.decreaseCounter();
            }
        });
        incButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                presenter.increaseCounter();
            }
        });
    }

    @Override
    public void updateCounter(int value) {
        if(counterView != null)
            counterView.setText(value + "");
    }

    @Override
    public void showNotification(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
