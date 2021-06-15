package com.example.formula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Practice extends AppCompatActivity {
    EditText ped1,ped2;
    Button pcal;
    TextView panswer;
    double pspeed;
    double plorentz;
    double VOspeed = 3*power(10,8);
    Vibrator vibrator;

    static double power(double N, double P)
    {
        double pow = 1;
        for (double i = 1; i <= P; i++)
            pow *= N;
        return pow;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        ped1 = findViewById(R.id.ped1);
        ped2 = findViewById(R.id.ped2);
        pcal = findViewById(R.id.pcal);
        panswer = findViewById(R.id.panswer);
        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);


        pcal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputspeed = ped1.getText().toString();
                pspeed = Double.parseDouble(inputspeed);
                result2(pspeed);
                String inputlorentz = ped2.getText().toString();
                plorentz = Double.parseDouble(inputlorentz);
                result1(plorentz);


            }

            private void result1(double plorentz) {
                double a = 1/(1-((pspeed*pspeed)/(VOspeed*VOspeed)));
                if(plorentz != a){
                    panswer.setText(String.valueOf(a));
                    panswer.setBackgroundColor(Color.RED);
                    vibrator.vibrate(1000);
                }
                else {
                    panswer.setText(String.valueOf(a));
                    panswer.setBackgroundColor(Color.GREEN);
                }

            }
            private void result2(double pspeed){

            }
        });



    }


    
}