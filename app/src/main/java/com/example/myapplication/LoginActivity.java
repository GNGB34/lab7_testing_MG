package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.*;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText userName;
    EditText password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        userName=(EditText)findViewById(R.id.edtUsername);
        password=(EditText)findViewById(R.id.edtPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(userName.getText().toString(),password.getText().toString());
            }
        });
    }
    public LoginActivity(Context context){

    }

    public String validate(String userName, String password)
    {
        if(userName.equals("admin") && password.equals("admin"))
            return "Login was successful";
        else
            return "Invalid login!";
    }

    public String emailValidate(String email){

        System.out.println("email: " + email);

         if(Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
             return "Login was successful";
         }else
             return "Invalid login!";
    }
}