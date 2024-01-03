package com.example.gemini_ai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gemini_ai.Apis.Login;
import com.example.gemini_ai.Session.SessionManager;
import com.google.android.material.textfield.TextInputLayout;

import app.rive.runtime.kotlin.RiveAnimationView;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout emailInputLayout, passwordInputLayout;
    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private RiveAnimationView mrBear;
    private TextView signUp;
    private ConstraintLayout mainLayout, innerLayout;

    private String stateMachine = "State Machine 1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailInputLayout = findViewById(R.id.email);
        emailEditText = emailInputLayout.getEditText(); // Corrected line

        mrBear = findViewById(R.id.riveAnimationView);

        passwordInputLayout = findViewById(R.id.password);
        passwordEditText = passwordInputLayout.getEditText();

        mainLayout = findViewById(R.id.mainLayout);
        innerLayout = findViewById(R.id.innerLayout);

        final boolean isChecked[] = {false};

        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mrBear.getController().setBooleanState(stateMachine, "Check", true);
                    isChecked[0] = true;
//                    mainLayout.setTranslationY(-100);
                } else {
                    mrBear.getController().setBooleanState(stateMachine, "Check", false);
                    isChecked[0] = false;
//                    mainLayout.setTranslationY(100);
                }
            }
        });

        final boolean[] isUp = {false};

        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUp[0] || isChecked[0]) {
                    mrBear.getController().setBooleanState(stateMachine, "hands_up", false);
                    mrBear.getController().setBooleanState(stateMachine, "Check", false);
                    isUp[0] = false;
                    isChecked[0] = false;
                }
            }
        });

        emailEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mrBear.getController().setBooleanState(stateMachine, "Check", true);
                isChecked[0] = true;
//                mainLayout.setTranslationY(-100);
            }
        });

        passwordEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mrBear.getController().setBooleanState(stateMachine, "hands_up", true);
                isUp[0] = true;
            }
        });


        innerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUp[0] || isChecked[0]) {
                    mrBear.getController().setBooleanState(stateMachine, "hands_up", false);
                    mrBear.getController().setBooleanState(stateMachine, "Check", false);
                    isUp[0] = false;
                    isChecked[0] = false;
//                    mainLayout.setTranslationY(100);
                }
            }
        });


        passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mrBear.getController().setBooleanState(stateMachine, "hands_up", true);
                    isUp[0] = true;
                } else {
                    mrBear.getController().setBooleanState(stateMachine, "hands_up", false);
                    isUp[0] = false;// Set to false when losing focus
                }
            }
        });

//        passwordInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int key=0;
//                if(key%2==0){
//
//                    key++;
//                }
//            }
//        });


        loginButton = findViewById(R.id.loginBtn);
        signUp = findViewById(R.id.signUp);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                Login api = new Login(email, password, getApplicationContext());
                if(api.login()){
                    SessionManager sessionManager=new SessionManager(getApplicationContext());
                    sessionManager.createLoginSession(email);
                    Toast.makeText(getApplicationContext(),"Your password",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
