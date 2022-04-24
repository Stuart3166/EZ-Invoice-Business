package com.example.ezinvoicebusiness;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public class AccountDetailsActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    //    private Button btnSignOut;
    protected void onCreate(Bundle savedInstanceState) {
//        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_account_details);
        auth = FirebaseAuth.getInstance();
        Button btnSignOut = findViewById(R.id.btnSignOut);

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
//                startActivity(new Intent(AccountDetailsActivity.this, RegisterActivity.class));
            }
        });

// this listener will be called when there is change in firebase user session
        FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(AccountDetailsActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
    }
}