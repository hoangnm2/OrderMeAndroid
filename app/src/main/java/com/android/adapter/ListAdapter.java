package com.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.entity.Dish;
import com.android.orderme.R;

import java.util.ArrayList;

/**
 * Created by binhb on 12/11/2016.
 */

public class ListAdapter extends BaseAdapter {

    private ArrayList<Dish> listDish = new ArrayList<>();
    private Context context;


    public ListAdapter(ArrayList<Dish> listDish,Context context) {
        this.listDish= listDish;
        this.context = context;
    }

    private class Row{
        ImageView img;
        TextView txtName;
        TextView txtPrice;
    }

    @Override
    public int getCount() {
        if(listDish!=null)
            return listDish.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return listDish.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Row row=new Row();
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        if(convertView==null){
            convertView=inflater.inflate(R.layout.item,parent,false);
            row.img= (ImageView) convertView.findViewById(R.id.imageView);
            row.txtName= (TextView) convertView.findViewById(R.id.txtName);
            row.txtPrice= (TextView) convertView.findViewById(R.id.txtPrice);
            convertView.setTag(row);
        }else{
            row=(Row)convertView.getTag();
        }
        Dish dish=listDish.get(position);
        row.img.setImageResource(dish.getImage());
        row.txtName.setText(dish.getName());
        row.txtPrice.setText(dish.getPrice());

        return convertView;
    }
}
