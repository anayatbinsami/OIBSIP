package com.example.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.todoapplication.databinding.ActivityAddDataBinding;

import DB.DbHelper;

public class DataAddActivity extends AppCompatActivity {
    ActivityAddDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ActivityAddDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


//        Create DataBase Object
        DbHelper dbHelper = new DbHelper(this);



        if (getIntent().getIntExtra("type",0)==1){
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Check edit text is not empty
                if (binding.eTitle.getText().toString().isEmpty()) {
                    binding.eTitle.setError("Please Enter Title");
                    return;
                }
                if (binding.eDiscription.getText().toString().isEmpty()) {
                    binding.eDiscription.setError("Please Enter Discription");
                    return;
                }


//                inserte data
               boolean isInserted =  dbHelper.insirtdata(binding.eTitle.getText().toString(),binding.eDiscription.getText().toString());
               binding.eDiscription.setText("");
               binding.eTitle.setText("");
               Intent intent = new Intent(DataAddActivity.this,MainActivity.class);
               startActivity(intent);
               if (isInserted){
                   Toast.makeText(DataAddActivity.this, "data saved successfuly", Toast.LENGTH_SHORT).show();
               }
               else {
                   Toast.makeText(DataAddActivity.this, "data not saved", Toast.LENGTH_SHORT).show();
               }
            }
        });}

       //Data Update

        else {
            String title = getIntent().getStringExtra("title");
            String discription = getIntent().getStringExtra("discription");
            int id = getIntent().getIntExtra("id",0);
            binding.eDiscription.setText(discription);
            binding.eTitle.setText(title);
            binding.add.setText("Update");
            binding.add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    //Check edit text is not empty

                    if (binding.eTitle.getText().toString().isEmpty()) {
                        binding.eTitle.setError("Please Enter Title");
                        return;
                    }
                    if (binding.eDiscription.getText().toString().isEmpty()) {
                        binding.eDiscription.setError("Please Enter Discription");
                        return;
                    }

//                    data updated
                  boolean isInserted =  dbHelper.updatedata(binding.eTitle.getText().toString(),binding.eDiscription.getText().toString(),id);

                    binding.eDiscription.setText("");
                    binding.eTitle.setText("");
                    Intent intent = new Intent(DataAddActivity.this,MainActivity.class);
                    startActivity(intent);
                    if (isInserted){
                        Toast.makeText(DataAddActivity.this, "data Updated successfuly", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(DataAddActivity.this, "data not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }

}