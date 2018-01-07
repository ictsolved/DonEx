package com.example.androidapp.shakyaruja.itsdc;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Pop extends AppCompatActivity {

    private EditText titletext;
    private EditText producttext;
    private EditText quantitytext;
    private Button donate;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        titletext = findViewById(R.id.title);

        donate = findViewById(R.id.button_donate);

        titletext.setText("Flood At Sunsari");

        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Pop.this,"Your request has been sent",Toast.LENGTH_SHORT).show();
            }
        });






    }
}
