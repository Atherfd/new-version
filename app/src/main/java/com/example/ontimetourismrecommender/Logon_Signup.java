package com.example.ontimetourismrecommender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Logon_Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon__signup);
        Button btn= findViewById(R.id.log);

        btn.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),logon.class);
                startActivity(i);
                finish();
            }
        });
    }
}