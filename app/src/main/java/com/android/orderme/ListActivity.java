package com.android.orderme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.android.adapter.ListAdapter;
import com.android.entity.Dish;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<Dish> arrDish=new ArrayList<>();
    private ListView lvDish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        addControls();
        addEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private void addEvents() {

    }

    private void addControls() {
        initialData();

        lvDish= (ListView) findViewById(R.id.lvFood);
        ListAdapter adapter=new ListAdapter(arrDish,ListActivity.this);

        lvDish.setAdapter(adapter);
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
