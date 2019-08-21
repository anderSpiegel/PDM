package com.m77834.pdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import  android.view.View;

public class aula3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula3);
    }

    public void exerc1Click(View view){
        Intent intent = new Intent(this, exercicio1_aula3.class);
        startActivity(intent);
    }

    public void exerc2Click(View view){
        Intent intent = new Intent(this, exercicio2_aula3.class);
        startActivity(intent);
    }

    public void exerc3Click(View view){

    }

    public void exerc4Click(View view){

    }
}
