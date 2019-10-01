package com.m77834.pdm.Controles;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.List;

public class MeuSimpleAdapter extends SimpleAdapter {

    public MeuSimpleAdapter(Context context, List<HashMap<String, Object>> items, int resource,
                            String[] from, int[] to){
        super(context, items, resource, from, to);
    }


    

}
