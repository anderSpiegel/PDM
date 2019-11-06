package com.m77834.pdm.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "pdm";
    private static int VERSAO = 1;

    public DatabaseHelper(Context context){
        super(context,BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users_app (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "usuario TEXT," +
                "senha TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase  db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS users_app");
    }



}
