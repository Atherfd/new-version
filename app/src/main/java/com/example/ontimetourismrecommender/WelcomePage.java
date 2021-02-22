package com.example.ontimetourismrecommender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class WelcomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);
//هذا الشرط راح يحفظ حالة المستخدم لان صفحة الويلكم هي اول صفحة يفتحها البرنامج لو المستخدم سجل دخوله وسكر البرنامج وحب يدخله مره ثانيه هذا الشرط راح يتاكد اؤذا هذا المستخدم للحين مسجل دخوله او لا عن طريق كلاس الشيرد برفرنس
        if(Sheardpref.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, profile1.class));
            return;
        }


        Thread thead= new Thread(){
            public void run(){
                try {
                    sleep(3000);
                    Intent intent= new Intent(getApplication(),Logon_Signup.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thead.start();

    }
}