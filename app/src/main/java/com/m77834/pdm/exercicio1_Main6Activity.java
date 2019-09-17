package com.m77834.pdm;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class exercicio1_Main6Activity extends ListActivity {


    String[] values = {"Luz", "Água", "Telefone", "Internet", "Aluguel", "Petshop"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1__main6);

        ArrayAdapter<String> arrayListView = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        setListAdapter(arrayListView);

        ListView listView = getListView();

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   TextView textView  = (TextView) view;
                   String mensagem = "Opção " + textView.getText();
                   Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
           }
       });
    }
}
