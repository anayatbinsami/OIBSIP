package com.example.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.todoapplication.databinding.ActivitySignInBinding;

import DB.DbHelper;

public class SignInActivity extends AppCompatActivity {
ActivitySignInBinding binding;
    public static String PREFS = "prefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DbHelper helper = new DbHelper(this);



        binding.Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (binding.Email.getText().equals("")||binding.Password.getText().equals("")){
                    Toast.makeText(SignInActivity.this, "Please Enter Valide Filled", Toast.LENGTH_SHORT).show();
                }

                else {
                    String email = binding.Email.getText().toString();
                    String ps = binding.Password.getText().toString();

                binding.Email.setText("");
                binding.Password.setText("");
                boolean login = helper.loginUser(email,ps);
                if (login==true){
                    Toast.makeText(SignInActivity.this, "login successfuly", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(SignInActivity.this, "email And Password Not Match", Toast.LENGTH_SHORT).show();
                }
                SharedPreferences sharedPreferences = getSharedPreferences(SignInActivity.PREFS,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("hasLoggedIn",true);
                editor.clear();
                editor.commit();
            }}

        });



        binding.Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

}