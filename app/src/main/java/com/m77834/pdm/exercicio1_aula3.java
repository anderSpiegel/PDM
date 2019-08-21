package com.m77834.pdm;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class exercicio1_aula3 extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1_aula3);
        text1 = findViewById(R.id.editExerc11);
        text2 = findViewById(R.id.editExerc12);
        text3 = findViewById(R.id.editExerc13);
        text4 = findViewById(R.id.editExerc14);

    }

    public void onBtnClick(View view){
        String valorInicialString = text1.getText().toString();
        Double valorInicial = Double.parseDouble(valorInicialString);

        String aplicacaoMensalString = text2.getText().toString();
        Double aplicacaoMensal = Double.parseDouble(aplicacaoMensalString);

        String tempoMesesString = text3.getText().toString();
        int tempoMeses = Integer.parseInt(tempoMesesString);

        String taxasString = text4.getText().toString();
        Double taxas = Double.parseDouble(taxasString);

    }

    public void mudaLingua(View view){
        String languageToLoad  = "en"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        this.setContentView(R.layout.activity_exercicio1_aula3);
    }


}
