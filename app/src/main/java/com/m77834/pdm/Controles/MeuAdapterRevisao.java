package com.m77834.pdm.Controles;

import android.content.Context;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class MeuAdapterRevisao extends SimpleAdapter {
    List<Map<String, Object>> lista;

    public MeuAdapterRevisao(Context ctx, List<Map<String, Object>> lista,
                             int uma_linha, String[] strings, int[] ints){
        super(ctx, lista, uma_linha, strings, ints);

    }
}
