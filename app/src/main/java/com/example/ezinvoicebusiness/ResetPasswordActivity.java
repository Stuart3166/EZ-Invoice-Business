package com.example.ezinvoicebusiness;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText inputEmail;
    private Button btnReset, btnBack;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        inputEmail = findViewById(R.id.email);
        btnReset = findViewById(R.id.btn_reset_password);
        btnBack = findViewById(R.id.btn_back);
        progressBar = findViewById(R.id.progressBar);

        auth = FirebaseAuth.getInstance();

        // Detect when the back button is clicked
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Detect when the reset password button is clicked
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();

                // Check if the email field is empty
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplication(), "Enter your email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Attempt to send a reset password email to the email entered by the user
                auth.sendPasswordResetEmail(email)
                        .addOnCompleteListener(task -> {
                            // Email sent
                            if (task.isSuccessful()) {
                                Toast.makeText(ResetPasswordActivity.this, "Check your email for instructions to reset your password!", Toast.LENGTH_SHORT).show();
                            }
                            // Address not registered, email not sent
                            else {
                                Toast.makeText(ResetPasswordActivity.this, "This email is not registered to an account", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

}