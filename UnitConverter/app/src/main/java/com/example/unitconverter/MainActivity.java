package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.unitconverter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.centimeterToMeters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String num = binding.editText.getText().toString();
               int number = Integer.parseInt(num);
               double cm =(number * 0.01);
               binding.resultView.setText("Value in Meter is:"+cm);
            }
        });
        binding.meterToCentimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = binding.editText.getText().toString();
                int number = Integer.parseInt(num);
                double m = (number * 100);
                binding.resultView.setText("Value in Centimeter is :"+m);
            }
        });

        binding.gramToKilogram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = binding.editText.getText().toString();
                int number = Integer.parseInt(num);
                double kilogram = (number * 0.001);
                binding.resultView.setText("Value in Kilogram is :"+kilogram);
            }
        });
        binding.kilogramToGram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = binding.editText.getText().toString();
                int number = Integer.parseInt(num);
                double gram = (number * 1000);
                binding.resultView.setText("Value in Gram is :"+gram);
            }
        });
    }
}