package com.m77834.pdm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.m77834.pdm.Controles.MyCustomListAdapter;

import java.io.Console;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.ClasseOperacao;

public class Activity_Desafio extends AppCompatActivity {

    private List<ClasseOperacao> listaOperacoes = new ArrayList<ClasseOperacao>();
    private String op;
    Button calculaResultado;
    EditText valor1;
    EditText valor2;
    EditText resultadoText;
    Spinner operacaoSelector;
    ListView listaResultado;

    String[] operacoes = {"+","-","*", "/"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__desafio);


        calculaResultado = findViewById(R.id.calcularButton);
        valor1 = findViewById(R.id.valor1);
        valor2 = findViewById(R.id.valor2);
        resultadoText = findViewById(R.id.resultadoValue);
        operacaoSelector = findViewById(R.id.operacaoSelector);
        listaResultado = findViewById(R.id.resultadoList);

        ArrayAdapter<String> arraySpinner = new ArrayAdapter<String>(this, R.layout.advanced_spinner_item, operacoes);
        operacaoSelector.setAdapter(arraySpinner);


        operacaoSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object selected = adapterView.getSelectedItem();
                switch (selected.toString()){
                    case "*":
                        op = "*";
                        break;
                    case "-":
                        op = "-";
                        break;
                    case "+":
                        op = "+";
                        break;
                    case "/":
                        op = "/";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        calculaResultado.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClasseOperacao nova_operacao = new ClasseOperacao();
                resultadoText.setText("");
                float resultado;
                float valor_1 = Float.parseFloat(valor1.getText().toString());
                float valor_2 = Float.parseFloat(valor2.getText().toString());
                nova_operacao.valor1 = valor1.getText().toString();
                nova_operacao.valor2 = valor2.getText().toString();
                switch (op){
                    case "*":
                        resultado = valor_1 * valor_2;
                        resultadoText.setText(Float.toString(resultado));
                        nova_operacao.operacao = "Multiplicação";
                        nova_operacao.resultado = Float.toString(resultado);
                        break;
                    case "-":
                        resultado = valor_1 - valor_2;
                        resultadoText.setText(Float.toString(resultado));
                        nova_operacao.operacao = "Subtração";
                        nova_operacao.resultado = Float.toString(resultado);
                        break;
                    case "+":
                        resultado = valor_1 + valor_2;
                        resultadoText.setText(Float.toString(resultado));
                        nova_operacao.operacao = "Adição";
                        nova_operacao.resultado = Float.toString(resultado);
                        break;
                    case "/":
                        resultado = valor_1/valor_2;
                        resultadoText.setText(Float.toString(resultado));
                        nova_operacao.operacao = "Divisão";
                        nova_operacao.resultado = Float.toString(resultado);
                        break;
                }
                nova_operacao.data_operacao = Calendar.getInstance().getTime();


                Log.d("Tag", nova_operacao.resultado);
                listaOperacoes.add(nova_operacao);


                MyCustomListAdapter customAdapter = new MyCustomListAdapter(Activity_Desafio.this, R.layout.lista_desafio, listaOperacoes);
                listaResultado.setAdapter(customAdapter);

            }
        });

    }

}
