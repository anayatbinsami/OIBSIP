package com.example.calculater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.calculater.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Float v1 ,v2;

    boolean divd,mltp,add,sbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Clicklistener();

    }

    private void Clicklistener() {

//NUMBER CLICK LISTENER

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"1");
            }
        });

        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"2");
            }
        });

        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"3");
            }
        });

        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"4");
            }
        });

        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"5");
            }
        });

        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"6");
            }
        });

        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"7");
            }
        });

        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"8");
            }
        });

        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"9");
            }
        });

        binding.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+".");
            }
        });

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText(binding.e1.getText()+"0");
            }
        });


//        Operator Clicklitener

        binding.btnDivd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Float.valueOf(binding.e1.getText()+"");
                divd=true;
                binding.e1.setText(null);
            }
        });

        binding.btnMltp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Float.valueOf(binding.e1.getText()+"");
                mltp=true;
                binding.e1.setText(null);
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Float.valueOf(binding.e1.getText()+"");
                add=true;
                binding.e1.setText(null);
            }
        });

        binding.btnSbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Float.valueOf(binding.e1.getText()+"");
                sbt=true;
                binding.e1.setText(null);
            }
        });




        binding.btnCLer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.e1.setText("");
            }
        });


        binding.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String res= binding.e1.getText().toString();
                if (res.length()>0){
                    res = res.substring(0,res.length()-1);
                    binding.e1.setText(res);
                }
            }
        });

//        Equals Clicklistener

        binding.btnEql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v2 = Float.valueOf(binding.e1.getText()+"");
                if (divd==true){
                    binding.e1.setText(v1/v2+"");
                    divd=false;
                }

                if (mltp==true){
                    binding.e1.setText(v1*v2+"");
                    mltp=false;
                }

                if (add==true){
                    binding.e1.setText(v1+v2+"");
                    add=false;
                }

                if (sbt==true){
                    binding.e1.setText(v1+-v2+"");
                    sbt=false;
                }
            }
        });

    }
}