package com.example.ebooks;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Varification_Activity extends AppCompatActivity {

    private EditText inputnumber1, inputnumber2, inputnumber3, inputnumber4, inputnumber5, inputnumber6;
    private String getotpbackend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varification);

        final View otp = findViewById(R.id.group_3);
        inputnumber1 = findViewById(R.id.line_7);
        inputnumber2 = findViewById(R.id.line_8);
        inputnumber3 = findViewById(R.id.line_9);
        inputnumber4 = findViewById(R.id.line_10);
        inputnumber5 = findViewById(R.id.line_11);
        inputnumber6 = findViewById(R.id.line_12);

        TextView textView = findViewById(R.id.we_have_sen);
        textView.setText(String.format("+91-%s", getIntent().getStringExtra("mobile")));

        getotpbackend = getIntent().getStringExtra("backendotp");

        otp.setOnClickListener(v -> {
            if (!inputnumber1.getText().toString().trim().isEmpty() &&
                    !inputnumber2.getText().toString().trim().isEmpty() &&
                    !inputnumber3.getText().toString().trim().isEmpty() &&
                    !inputnumber4.getText().toString().trim().isEmpty() &&
                    !inputnumber5.getText().toString().trim().isEmpty() &&
                    !inputnumber6.getText().toString().trim().isEmpty()) {

                String entercodeotp = inputnumber1.getText().toString() +
                        inputnumber2.getText().toString() +
                        inputnumber3.getText().toString() +
                        inputnumber4.getText().toString() +
                        inputnumber5.getText().toString() +
                        inputnumber6.getText().toString();
                if (getotpbackend != null) {
                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(getotpbackend, entercodeotp);
                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        SharedPreferences preferences = getSharedPreferences("LoanAppPrefs", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putBoolean("isVerified", true);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(Varification_Activity.this, "Enter the correct OTP", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(Varification_Activity.this, "Please check internet connection", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Varification_Activity.this, "Please enter all numbers", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.don_t_get_t).setOnClickListener(v -> resendOtp());

        numberOtpMove();
    }



    private void resendOtp() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + getIntent().getStringExtra("mobile"),
                60,
                TimeUnit.SECONDS,
                Varification_Activity.this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {}

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(Varification_Activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCodeSent(@NonNull String newbackendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        getotpbackend = newbackendotp;
                        Toast.makeText(Varification_Activity.this, "OTP successfully sent", Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }



    private void numberOtpMove() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    if (inputnumber1.isFocused()) inputnumber2.requestFocus();
                    else if (inputnumber2.isFocused()) inputnumber3.requestFocus();
                    else if (inputnumber3.isFocused()) inputnumber4.requestFocus();
                    else if (inputnumber4.isFocused()) inputnumber5.requestFocus();
                    else if (inputnumber5.isFocused()) inputnumber6.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };
        inputnumber1.addTextChangedListener(textWatcher);
        inputnumber2.addTextChangedListener(textWatcher);
        inputnumber3.addTextChangedListener(textWatcher);
        inputnumber4.addTextChangedListener(textWatcher);
        inputnumber5.addTextChangedListener(textWatcher);
        inputnumber6.addTextChangedListener(textWatcher);
    }
}
