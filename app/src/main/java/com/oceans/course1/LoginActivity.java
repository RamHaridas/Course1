package com.oceans.course1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init(){
        //initialize
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        //listener on button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate(){
        String mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(mail.isEmpty()){
            // mail is empty
            Toast.makeText(this, "Email is Empty", Toast.LENGTH_SHORT).show();
            return;
        }else if(pass.isEmpty()){
            //pass is empty
            Toast.makeText(this, "Password is Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        //saving login status
        editor.putBoolean("isLogin",true);
        editor.apply();
        editor.putString("email",mail);
        editor.apply();
        //goto main activity
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        intent.putExtra("email",mail);
        intent.putExtra("pass",pass);
        startActivity(intent);
    }
}