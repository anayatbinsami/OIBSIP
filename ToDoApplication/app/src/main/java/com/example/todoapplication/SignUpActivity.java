package com.example.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.todoapplication.databinding.ActivitySignUpBinding;

import DB.DbHelper;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        DbHelper dbHelper = new DbHelper(this);
        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                

//                checking edit view

                if (binding.Name.getText().toString().isEmpty()) {
                    binding.Name.setError("Please Enter Valid Name");
                    return;
                }

                if (binding.Email.getText().toString().equals("")) {
                    binding.Email.setError("PleaseEnter Valid Email");
                    return;
                }
                if (binding.Password.getText().toString().isEmpty()) {
                    binding.Password.setError("Please Enter Your Password");
                    return;
                }

                String email = binding.Email.getText().toString();
                binding.Name.setText("");
                binding.Email.setText("");
                binding.Password.setText("");

                boolean signup = dbHelper.checkeduser(email);
                if (signup==true) {

                    Toast.makeText(SignUpActivity.this, "You Have Already Account PLease Login", Toast.LENGTH_SHORT).show();//
                }
//                    inserted



                   
                    else {
                        boolean isInserted = dbHelper.SignUp(binding.Name.getText().toString(), binding.Email.getText().toString(),
                                binding.Password.getText().toString());
                        binding.Name.setText("");
                        binding.Email.setText("");
                        binding.Password.setText("");



                        if (isInserted) {
                            Toast.makeText(SignUpActivity.this, "SignUp Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                            startActivity(intent);
                        }

                        else {
                            Toast.makeText(SignUpActivity.this, "not signup", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        });



        binding.Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });


    }
}