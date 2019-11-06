package com.m77834.pdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aula2Click(View view){
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);
    }

    public void aula3Click(View view){
        Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
        startActivity(intent);
    }

    public void aula4Click(View view){
        //Intent intent = new Intent(getApplicationContext(), aula4.class);
        //startActivity(intent);
    }

    public void aula6Click(View view){
        Intent intent = new Intent(getApplicationContext(), Main6Activity.class);
        startActivity(intent);
    }

    public void Revisao(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivityRevisao.class);
        startActivity(intent);
    }


    public void desafio(View view){
        Intent intent = new Intent(getApplicationContext(), Activity_Desafio.class);
        startActivity(intent);
    }

    public void web(View view){
        Intent intent = new Intent(getApplicationContext(), Activity_Web.class);
        startActivity(intent);
    }

    public void login(View view){
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }



}
