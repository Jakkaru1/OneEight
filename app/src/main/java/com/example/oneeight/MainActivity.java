package com.example.oneeight;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    //Variables
    boolean[] pole = new boolean[9];
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button reroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init of variables
        /*for(int i = 0; i < pole.length; i++){
            pole[i] = (Math.random() < 0.5);
        };*/
        one = (Button) findViewById(R.id.one);
        one.setOnClickListener(onClickListener);
        two = (Button) findViewById(R.id.two);
        two.setOnClickListener(onClickListener);
        three = (Button) findViewById(R.id.three);
        three.setOnClickListener(onClickListener);
        four = (Button) findViewById(R.id.four);
        four.setOnClickListener(onClickListener);
        five = (Button) findViewById(R.id.five);
        five.setOnClickListener(onClickListener);
        six = (Button) findViewById(R.id.six);
        six.setOnClickListener(onClickListener);
        seven = (Button) findViewById(R.id.seven);
        seven.setOnClickListener(onClickListener);
        eight = (Button) findViewById(R.id.eight);
        eight.setOnClickListener(onClickListener);
        nine = (Button) findViewById(R.id.nine);
        nine.setOnClickListener(onClickListener);
        reroll = (Button) findViewById(R.id.reroll);
        reroll.setOnClickListener(onClickListener);


        rerollClick();
        /* kontrola random boolean
        for(int i = 0; i < pole.length; i++){
            System.out.println(pole[i]);
        };
        */
    }

    //Metoda na rerollnutie buttonov
    private void rerollClick(){
        pole[0] = (Math.random() < 0.5);
        if(pole[0]){one.setBackgroundColor(Color.BLACK);}else{one.setBackgroundColor(Color.WHITE);};
        pole[1] = (Math.random() < 0.5);
        if(pole[1]){two.setBackgroundColor(Color.BLACK);}else{two.setBackgroundColor(Color.WHITE);};
        pole[2] = (Math.random() < 0.5);
        if(pole[2]){three.setBackgroundColor(Color.BLACK);}else{three.setBackgroundColor(Color.WHITE);};
        pole[3] = (Math.random() < 0.5);
        if(pole[3]){four.setBackgroundColor(Color.BLACK);}else{four.setBackgroundColor(Color.WHITE);};
        pole[4] = (Math.random() < 0.5);
        if(pole[4]){five.setBackgroundColor(Color.BLACK);}else{five.setBackgroundColor(Color.WHITE);};
        pole[5] = (Math.random() < 0.5);
        if(pole[5]){six.setBackgroundColor(Color.BLACK);}else{six.setBackgroundColor(Color.WHITE);};
        pole[6] = (Math.random() < 0.5);
        if(pole[6]){seven.setBackgroundColor(Color.BLACK);}else{seven.setBackgroundColor(Color.WHITE);};
        pole[7] = (Math.random() < 0.5);
        if(pole[7]){eight.setBackgroundColor(Color.BLACK);}else{eight.setBackgroundColor(Color.WHITE);};
        pole[8] = (Math.random() < 0.5);
        if(pole[8]){nine.setBackgroundColor(Color.BLACK);}else{nine.setBackgroundColor(Color.WHITE);};
    }

    //Metoda na klikanie buttonov
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch(v.getId()){
                //Rerollne vsetky buttony
                case R.id.reroll:
                    rerollClick();
                //Po kliknuti na urcity button zmeni farby okolitych buttonov
                /*case R.id.one:
                    ColorDrawable buttonColor = (ColorDrawable) two.getBackground();
                    if(buttonColor == black){two.setBackgroundColor(Color.WHITE);}else{two.setBackgroundColor(Color.BLACK)};*/
            }

        }
    };


}