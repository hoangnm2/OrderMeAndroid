package com.android.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.adapter.ListAdapter;
import com.android.entity.Dish;
import com.android.orderme.DishDetailsActivity;
import com.android.orderme.R;

import java.util.ArrayList;

/**
 * Created by binhb on 13/11/2016.
 */
public class MenuFragment extends Fragment {

    private ArrayList<Dish> arrDish = new ArrayList<>();
    private ListView lvDish;
    private ListAdapter listAdapter;
    private OnFragmentInteractionListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_list,container,false);

        addControls(view);
        addEvents();

        return view;
    }

    private void addEvents() {

    }

    private void addControls(View view) {
        initialData();
        lvDish= (ListView) view.findViewById(R.id.lvFood);
        listAdapter= new ListAdapter(arrDish , getActivity());
        lvDish.setAdapter(listAdapter);

        lvDish.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Click Pos: " + position, Toast.LENGTH_SHORT).show();
                triggerDishDetailsAcitivty(view);
            }
        });
    }

    private void triggerDishDetailsAcitivty(final View v) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int[] startingLocation = new int[2];
                v.getLocationOnScreen(startingLocation);
                startingLocation[0] += v.getWidth() / 2;
                DishDetailsActivity.startActivityFromLocation(startingLocation, getActivity());
                getActivity().overridePendingTransition(0, 0);
            }
        }, 200);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
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
