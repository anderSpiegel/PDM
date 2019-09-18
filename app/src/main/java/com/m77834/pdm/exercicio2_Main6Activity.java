package com.m77834.pdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class exercicio2_Main6Activity extends AppCompatActivity {

    TextView textView;

    Spinner meuSpinner;
    ListView meuListView;

    String[] estados = {"RS", "SP", "RJ"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2__main6);
        textView  = findViewById(R.id.userName);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String value = extras.getString("value");
            textView.setText(value);
        }


        meuSpinner = findViewById(R.id.estadoSelector);
        ArrayAdapter<String> arraySpinner = new ArrayAdapter<String>(this, R.layout.advanced_spinner_item, estados);
        meuSpinner.setAdapter(arraySpinner);

        meuSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selected = adapterView.getSelectedItem().toString();
                switch (selected){
                    case "RS":
                        String[] cidades = {"SCS", "POA", "Gramado"};
                        meuListView =  findViewById(R.id.cidadeSelector);
                        ArrayAdapter<String> arrayList = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cidades);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
