package com.example.formula;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class Spi extends AppCompatActivity {
    TextView spifactor;
    TextView result2;
    EditText time;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spi);
        result2 = findViewById(R.id.result2);
        spifactor = findViewById(R.id.spifactor);
        time = findViewById(R.id.time);

        Calendar rightNow = Calendar.getInstance();
        int tH = rightNow.get(Calendar.HOUR);
        int tm = rightNow.get(Calendar.MINUTE);
        int ts = rightNow.get(Calendar.SECOND);

        time.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double spfactor = fact(tH)/((tm*tm*tm)+ts);
                String b = String.valueOf(spfactor);
                spifactor.setText(b);


            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });
        Calendar calender = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
        String Time = simpleDateFormat.format(calender.getTime());
        time.setText((Time));



    }


    private double fact(double tH) {
        double i,fact = 1;
        double number = tH;
        for(i=1;i<=number;i++){
            fact=fact*i;

        }
        return fact;
    }








}