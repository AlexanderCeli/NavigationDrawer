package com.example.navigatio.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.navigatio.R;
import com.example.navigatio.database.Persona;

import java.util.ArrayList;

public  class ListAdapter extends ArrayAdapter<Persona> {

    private Context context;
    private ArrayList<Persona> list;


    public ListAdapter(Context context, ArrayList<Persona> list) {
        super(context, R.layout.content_list);
        this.context=context;
        this.list=list;

    }
    @Override
    public int getCount(){

        return list.size();
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        final ViewHolder viewHolder;

        if (convertView == null || convertView.getTag() == null) {

            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.content_list, parent, false);
            viewHolder.vItemName = (TextView) view.findViewById(R.id.textList);
            viewHolder.vItemImage = (ImageView) view.findViewById(R.id.img);
            view.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
            view = convertView;


        }

        viewHolder.vItemName.setText(list.get(position).getNombre());



        return view;
    }

    static class ViewHolder{
        protected TextView vItemName;
        protected ImageView vItemImage;
    }


}
