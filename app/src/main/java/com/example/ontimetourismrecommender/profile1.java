
package com.example.ontimetourismrecommender;
import android.app.ProgressDialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class profile1 extends AppCompatActivity {


    public static final String URL = "http://10.0.2.2/login/profile.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);
        TextView logout= findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               if( Sheardpref.getInstance(getApplicationContext()).logout()){
                   Intent i = new Intent(getApplicationContext(), logon.class);
                   startActivity(i);
                   finish();
               }
            }
        });
        userLogin();





    }

    private void userLogin(){

        TextView name=findViewById(R.id.name);
        TextView username=findViewById(R.id.username);
        TextView phone=findViewById(R.id.Phone);
        TextView amount=findViewById(R.id.AmonutOfex);
        TextView location=findViewById(R.id.Location);
        TextView email=findViewById(R.id.Email);
        TextView status=findViewById(R.id.Status);
        TextView education=findViewById(R.id.education);
        TextView Birthdate=findViewById(R.id.Birthdate);
        String Username = Sheardpref.getInstance(getApplicationContext()).getUsername();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject product = array.getJSONObject(i);
                                if(product.getString("UserName").equals(Username)){

                                username.setText(Username);
                                    amount.setText(product.getString("AmountOfexchane"));
                                    Birthdate.setText(product.getString("age"));
                            name.setText(product.getString("Name"));
                            phone.setText(product.getString("phone"));
                                    status.setText(product.getString("status"));
                                    location.setText(product.getString("Location"));
                                    education.setText(product.getString("education"));

                                }

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Toast.makeText(
                                getApplicationContext(),
                                error.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                }
        );

        Volley.newRequestQueue(this).add(stringRequest);    }



}