package com.example.ebooks;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Login_Activity extends AppCompatActivity {

    private EditText numberEditText;
    private EditText passwordEditText;
    private View submitButton;
    private TextView signUpTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        numberEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        signUpTextView = findViewById(R.id.sign_up);
        submitButton = findViewById(R.id.group_3);


        signUpTextView.setOnClickListener(v -> handleSignUp());
        submitButton.setOnClickListener(v -> handleSubmit());
    }

    private void handleSubmit() {
        String mobileNumber = numberEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(mobileNumber)) {
            Toast.makeText(this, "Please enter your number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mobileNumber.length() != 10) {
            Toast.makeText(this, "Please enter a correct number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + mobileNumber,
                60,
                TimeUnit.SECONDS,
                Login_Activity.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(Login_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        Intent intent = new Intent(getApplicationContext(), Varification_Activity.class);
                        intent.putExtra("mobile", mobileNumber);
                        intent.putExtra("backendotp", backendotp);
                        startActivity(intent);
                    }
                }
        );
    }

    private void handleSignUp() {
        Toast.makeText(this, "Sign up clicked", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Login_Activity.this, Create_Activity.class));
    }
}
