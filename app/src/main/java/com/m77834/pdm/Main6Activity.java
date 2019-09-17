package com.m77834.pdm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {

    private ListView meuListView;
    private Spinner meuSpinner;

    String[] values = {"Luz", "Água", "Telefone", "Internet", "Aluguel", "Petshop"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        meuSpinner = findViewById(R.id.meu_spinner);
        meuListView = findViewById(R.id.meu_list_view);

        ArrayAdapter<String> arraySpinner = new ArrayAdapter<String>(this, R.layout.advanced_spinner_item, values);

        ArrayAdapter<String> arrayListView = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        meuSpinner.setAdapter(arraySpinner);

        meuListView.setAdapter(arrayListView);

        meuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void buttonClickAula6(View view){
        Intent intent = new Intent(getApplicationContext(), exercicio1_Main6Activity.class);
        startActivity(intent);
    }
}
