package com.android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.adapter.ListAdapter;
import com.android.entity.Dish;
import com.android.orderme.R;

import java.util.ArrayList;

/**
 * Created by binhb on 13/11/2016.
 */

public class MenuFragment extends Fragment {
    private ArrayList<Dish> arrDish=new ArrayList<>();
    private ListView lvDish;
    private ListAdapter listAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.activity_list,container,false);


        addControls(view);
        addEvents();

        return view;
    }
    private void addEvents() {

    }

    private void addControls(View view) {
        initialData();

        lvDish= (ListView) view.findViewById(R.id.lvFood);
        listAdapter=new ListAdapter(arrDish,getActivity());

        lvDish.setAdapter(listAdapter);
    }

    private void initialData() {
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.beefbob,"50.000"));
        arrDish.add(new Dish("name",R.mipmap.pilau,"50.000"));


    }
}
