package com.m77834.pdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    final String TAG = "TAGxyz";

    private TextView tempC;

    public void onClickBtnCalcTemo(View view){
        Intent intent = new Intent(this, TempActivity.class);
        String c = tempC.getText().toString();
        double d = Double.parseDouble(c);
        Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tempC = findViewById(R.id.textView2);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "onStart");
        //A Activity está prestes a se tornar visivel
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "onRestart");
        //A Activity está voltando a receber o foco, depois de estar pausada
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume");
        //A Activity está visivel
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "onPause");
        //Outra activity está recebendo o foco, está ficara pausada
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop");
        //A Activity não está mais visivel, mas permanece em memoria
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy");
        //A Activity está prestes a ser destruida (removida da memoria)
    }
}
