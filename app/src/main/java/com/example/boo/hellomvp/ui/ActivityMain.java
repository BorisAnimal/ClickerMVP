package com.example.boo.hellomvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boo.hellomvp.R;
import com.example.boo.hellomvp.mvp.CounterMVP;
import com.example.boo.hellomvp.mvp.presenters.CounterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by boo on 26.09.17.
 */

public class ActivityMain extends AppCompatActivity implements CounterMVP.View {
    /**
     * week 1
     */
    private CounterMVP.Presenter presenter;
    @BindView(R.id.main_button_inc)
    Button incButton;
    @BindView(R.id.main_button_dec)
    Button decButton;
    @BindView(R.id.main_counter)
    TextView counterView;

    /**
     * week 2
     */
    @BindView(R.id.image)
    ImageView imageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * week 1
         */

        presenter = new CounterPresenter(this);

        // Gooogle "Butterknife" to make it simple, clever
        ButterKnife.bind(this);
//        incButton = (Button) findViewById(R.id.main_button_inc);
//        decButton = (Button) findViewById(R.id.main_button_dec);
//        counterView = (TextView) findViewById(R.id.main_counter);

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

        /**
         * week 2
         */
        //1. Передача ресурса как аргумент к полю View
        imageView.setImageResource(R.mipmap.no_image);
        //2. Разные способы задать обработчик события для View
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapImageState(view);
            }
        });

    }

    /**
     * week 2
     */

    public void swapImageState(View view) {
        if(imageView.getVisibility() == View.VISIBLE)
            imageView.setVisibility(View.INVISIBLE);
        else imageView.setVisibility(View.VISIBLE);
    }

    /**
     * week 1
     */

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
