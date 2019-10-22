package com.m77834.pdm.Controles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.m77834.pdm.R;

import java.net.ContentHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import model.ClasseOperacao;

public class MyCustomListAdapter extends ArrayAdapter<ClasseOperacao> {

    Context ctx;
    int resource;
    List<ClasseOperacao> operacaoList;

    public MyCustomListAdapter(Context ctx, int resource, List<ClasseOperacao> operacaoList){
super(ctx, resource, operacaoList);
this.ctx = ctx;
this.resource = resource;
this.operacaoList = operacaoList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);

        View view = inflater.inflate(R.layout.lista_desafio, null);

        TextView textViewData = view.findViewById(R.id.data);
        TextView resultadoView = view.findViewById(R.id.resultadoValue);

        ClasseOperacao op = operacaoList.get(position);

        String pattern = "MM/dd/yyyy HH:mm:ss";


        DateFormat df = new SimpleDateFormat(pattern);
        String todayAsString = df.format(op.data_operacao);

        textViewData.setText(todayAsString);
        resultadoView.setText(op.resultado);


        return  view;
    }
}
