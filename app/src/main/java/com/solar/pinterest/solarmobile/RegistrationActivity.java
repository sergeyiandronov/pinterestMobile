package com.solar.pinterest.solarmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

    Button toLoginBtn;
    Button registrationBtn;

    TextInputLayout textInputEmail;
    TextInputLayout textInputNickname;
    TextInputLayout textInputPassword;
    TextView errorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        textInputEmail = findViewById(R.id.registration_view_email_layout);
        textInputNickname = findViewById(R.id.registration_view_nickname_layout);
        textInputPassword = findViewById(R.id.registration_view_password_layout);
        errorTextView = findViewById(R.id.registration_error_text_under_title);

        toLoginBtn = findViewById(R.id.registration_to_login_button);
        toLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        registrationBtn = findViewById(R.id.registration_view_button);
        registrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmInput(v);
            }
        });
    }

    private boolean emailValidation() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Поле должно быть заполнено");
            return false;
        } else {
            textInputEmail.setError(null);
//            textInputEmail.setErrorEnabled(false);
            return true;
        }
    }

    private boolean nicknameValidation() {
        String nicknameInput = textInputNickname.getEditText().getText().toString().trim();

        if (nicknameInput.isEmpty()) {
            textInputNickname.setError("Поле должно быть заполнено");
            return false;
        } else if (nicknameInput.length() < 3 || nicknameInput.length() > 30) {
            textInputNickname.setError("Длина никнейма от 3 до 30 символов");
            return false;
        } else {
            textInputNickname.setError(null);
            return  true;
        }
    }

    private boolean passwordValidation() {
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Поле должно быть заполнено");
            return false;
        } else if (passwordInput.length() < 6 || passwordInput.length() > 30) {
            textInputPassword.setError("Длина никнейма от 6 до 30 символов");
            return false;
        } else {
            textInputPassword.setError(null);
            return  true;
        }
    }

    public void confirmInput(View v) {
        if (!emailValidation() | !nicknameValidation() | !passwordValidation()) {
            return;
        }

        String input = textInputEmail.getEditText().getText().toString();
        input += "\n";
        input += textInputNickname.getEditText().getText().toString();
        input += "\n";
        input += textInputPassword.getEditText().getText().toString();

        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}