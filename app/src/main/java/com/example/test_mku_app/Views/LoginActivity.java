package com.example.test_mku_app.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test_mku_app.MainActivity;
import com.example.test_mku_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText edtEmail, edtPassword;
    TextView tvforgetpassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        tvforgetpassword = findViewById(R.id.tvforgetpassword);

        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed before text changed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // No action needed before text changed
            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                String filteredInput = filterSpecialCharacters(input);
                if (!input.equals(filteredInput)) {
                    // Replace the input text with filtered text
                    edtPassword.setText(filteredInput);
                    // Move the cursor to the end of the filtered text
                    edtPassword.setSelection(filteredInput.length());
                }
            }
        });
    }
    private String filterSpecialCharacters(String input) {
        StringBuilder filteredInput = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c)) {
                // Keep letters, digits, and whitespaces
                filteredInput.append(c);
            }
        }
        return filteredInput.toString();
    }
    private void loginUser(){
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            edtEmail.setError("Email rỗng");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            edtPassword.setError("Mật khẩu rỗng");
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String userID = mAuth.getCurrentUser().getUid();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("userID", userID);
                    startActivity(intent);
                }else
                    Toast.makeText(LoginActivity.this, "Email hoặc mật khẩu sai", Toast.LENGTH_SHORT).show();
            }
        });
    }
}