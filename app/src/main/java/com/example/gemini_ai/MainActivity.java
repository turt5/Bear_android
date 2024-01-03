package com.example.gemini_ai;

//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import com.example.gemini_ai.Session.SessionManager;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Example usage in another activity or fragment
//        SessionManager sessionManager = new SessionManager(getApplicationContext());
//
//        if (sessionManager.isLoggedIn()) {
//            // User is logged in, get username
////            String username = sessionManager.getUsername();
//            Intent it=new Intent(this,HomeActivity.class);
//            startActivity(it);
//        } else {
//            Intent it=new Intent(this,LoginActivity.class);
//            startActivity(it);
//        }
//
//
//
//    }
//}