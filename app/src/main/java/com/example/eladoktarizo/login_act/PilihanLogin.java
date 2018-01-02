package com.example.eladoktarizo.login_act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Elad Oktarizo on 14/05/2017.
 */

public class PilihanLogin extends AppCompatActivity {

    Button btnLoginOrtu,btnLoginGuru;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan_login);
        btnLoginGuru = (Button)findViewById(R.id.buttonlogin2);
        btnLoginOrtu=(Button)findViewById(R.id.buttonlogin1);


        btnLoginOrtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });
        btnLoginGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(getApplicationContext(),Login2Activity.class);
                startActivity(i);
            }
        });
    }
}
