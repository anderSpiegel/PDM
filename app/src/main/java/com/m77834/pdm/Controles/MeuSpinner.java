package com.m77834.pdm.Controles;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.m77834.pdm.R;

public class MeuSpinner extends ArrayAdapter {

    public MeuSpinner(Context context, int textViewResourceId, String[] objects){
        super(context, textViewResourceId, objects);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent){
        View v = super.getView(position, convertView, parent);

        TextView tv1 = v.findViewById(R.id.text1);
        TextView tv2 = v.findViewById(R.id.text2);


        return v;
    }



}
