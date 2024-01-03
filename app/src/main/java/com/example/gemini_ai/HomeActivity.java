package com.example.gemini_ai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gemini_ai.Session.SessionManager;

public class HomeActivity extends AppCompatActivity {

    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        logout=findViewById(R.id.logout);


        SessionManager sessionManager=new SessionManager(this);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logoutUser();
                Intent it=new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(it);
            }
        });

    }
}