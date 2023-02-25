package com.example.todoapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.todoapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

import Adapters.Adapter;
import DB.DbHelper;
import Models.Model;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    public static String PRE_FS = "prefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        Create DataBase Object
        DbHelper dbHelper = new DbHelper(this);

        ArrayList<Model> list = dbHelper.getdata();
        Adapter adapter = new Adapter(list,this);
        binding.RecyclerView.setAdapter(adapter);
        binding.RecyclerView.setLayoutManager(new LinearLayoutManager(this));



        binding.floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DataAddActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu:
                Intent intent = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);
                finish();
                SharedPreferences sp = getSharedPreferences(MainActivity.PRE_FS,0);
                SharedPreferences.Editor editor = sp.edit();
                editor.putBoolean("hasLoggedOut",true);
                editor.clear();
                editor.commit();
                break;
        }
        return true;
    }
}