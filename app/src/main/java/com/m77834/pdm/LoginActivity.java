package com.m77834.pdm;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.m77834.pdm.db.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    public DatabaseHelper helper;
    private EditText usuario;
    private EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper = new DatabaseHelper(this);
        usuario  = findViewById(R.id.idUser);
        senha = findViewById(R.id.senhaUser);
    }

    @Override
    protected void onDestroy(){
        helper.close();
        super.onDestroy();
    }



    public void tryLogin(View view, String usuario, String senha){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = null;
        String sql ="SELECT * FROM users_app WHERE usuario="+usuario+" and senha = "+senha+";";
        cursor= db.rawQuery(sql, null);
        Toast.makeText(this, cursor.getCount(), Toast.LENGTH_SHORT).show();

        if(cursor.getCount()>0){

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(getApplicationContext(), NewLoginActivity.class);
            startActivity(intent);
        }
        cursor.close();
    }



}
