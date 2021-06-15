package com.example.formula;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class Lorentz extends AppCompatActivity {
    double speed;
    double VOspeed = 3*power(10,8);
    EditText ed1;
    Button result1,practice;
    TextView answer;
    static int power(int N, int P)
    {
        int pow = 1;
        for (int i = 1; i <= P; i++)
            pow *= N;
        return pow;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorentz);

        ed1 = findViewById(R.id.ed1);
        result1 = findViewById(R.id.result1);
        answer = findViewById(R.id.answer);
        practice = findViewById(R.id.practice);

        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lorentz.this,Practice.class);
                startActivity(intent);

            }
        });


        result1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputspeed = ed1.getText().toString();
                speed = Double.parseDouble(inputspeed);
                result(speed);

            }
        });

    }
    void result(double speed){
        double lorentzfactor = 1/(1-((speed*speed)/(VOspeed*VOspeed)));
        if(speed==VOspeed){
            Toast.makeText(getApplicationContext(),"Change the Speed",Toast.LENGTH_SHORT).show();
        }
        answer.setText(String.valueOf(lorentzfactor));
    }



}