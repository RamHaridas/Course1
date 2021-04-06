package com.oceans.course1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String mail;
    private TextView name;
    private Button logout;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        logout = findViewById(R.id.logout);
        name = findViewById(R.id.name);
        Intent intent = getIntent();
        mail = intent.getStringExtra("email");
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean("isLogin",false);
                editor.apply();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
        //print
        try {
            name.setText(mail);
        }catch (Exception e){
            Toast.makeText(this, "Mail is null or empty", Toast.LENGTH_SHORT).show();
        }
    }
}