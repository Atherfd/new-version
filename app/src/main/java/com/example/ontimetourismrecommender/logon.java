package com.example.ontimetourismrecommender;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class logon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);
        //Start ProgressBar first (Set visibility VISIBLE)
        EditText username= findViewById(R.id.username);
        EditText pass= findViewById(R.id.pass);
        Button log= findViewById(R.id.button);
        ProgressBar pro= findViewById(R.id.progress);


        log.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                String name= username.getText().toString();
                String p= pass.getText().toString();

                if(name.equals("") || p.equals("")) {
                    Toast.makeText(getApplicationContext(), "All filed are require",Toast.LENGTH_SHORT).show();

                }else{
                    pro.setVisibility(View.VISIBLE);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "pwd";
                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = name;
                            data[1] = p;
                            PutData putData = new PutData("http://10.0.2.2/login/login.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    pro.setVisibility(View.GONE);

                                    String result = putData.getResult();
                                    if(result.equals("Login Success")){
                                        Sheardpref.getInstance(getApplicationContext()).userLogin(name);
                                        Intent i = new Intent(getApplicationContext(), profile1.class);
                                        startActivity(i);
                                        finish();
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), result ,Toast.LENGTH_SHORT).show();
                                    }


                                }
                            }
                            //End Write and Read data with URL
                        }
                    });



                }  }
        });
            }}
