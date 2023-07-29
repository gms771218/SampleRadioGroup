package com.gms.sampleradiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.gms.sampleradiogroup.view.CusRadioGroup;

public class MainActivity extends AppCompatActivity {


    CusRadioGroup radioGroupQuestion1;
    CusRadioGroup radioGroupQuestion2;
    CusRadioGroup radioGroupQuestion3;
    CusRadioGroup radioGroupQuestion4;

    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReset = findViewById(R.id.btn_reset);

        radioGroupQuestion1 = findViewById(R.id.radio_group_question1);
        radioGroupQuestion2 = findViewById(R.id.radio_group_question2);
        radioGroupQuestion3 = findViewById(R.id.radio_group_question3);
        radioGroupQuestion4 = findViewById(R.id.radio_group_question4);

        radioGroupQuestion1.SetOnSelectListener((index, result) -> {
            Log.i("Gme" , "Select(1):" +index + " / result : "+result);
        });

        radioGroupQuestion2.SetOnSelectListener((index, result) -> {
            Log.i("Gme" , "Select(2):" +index + " / result : "+result);
        });

        radioGroupQuestion3.SetOnSelectListener((index, result) -> {
            Log.i("Gme" , "Select(3):" +index + " / result : "+result);
        });

        radioGroupQuestion4.SetOnSelectListener((index, result) -> {
            Log.i("Gme" , "Select(4):" +index + " / result : "+result);
        });

        radioGroupQuestion4.setSelect(1);


        btnReset.setOnClickListener(e->{
            radioGroupQuestion1.reset();
            radioGroupQuestion2.reset();
            radioGroupQuestion3.reset();
            radioGroupQuestion4.reset();
        });


    }



}