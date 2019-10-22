package com.m77834.pdm.Controles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.m77834.pdm.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import model.ClasseOperacao;
import model.ContactModel;
import model.matriculaModel;

public class MeuAdapterRevisao extends ArrayAdapter<matriculaModel> {
    List<Map<String, Object>> lista;

    Context ctx;
    int resource;
    List<matriculaModel> matriculaModelList;

    public MeuAdapterRevisao(Context ctx, int resource, List<matriculaModel> matriculaList){
        super(ctx, resource, matriculaList);
        this.ctx = ctx;
        this.resource = resource;
        this.matriculaModelList = matriculaList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);

        View view = inflater.inflate(R.layout.layoutrevisao, null);

        TextView textMatricula = view.findViewById(R.id.matriculaMatricula);
        TextView textNome = view.findViewById(R.id.nomeMatricula);

        matriculaModel matricula = matriculaModelList.get(position);

        textNome.setText(matricula.nome);
        textMatricula.setText(matricula.matricula);


        return  view;
    }

}
