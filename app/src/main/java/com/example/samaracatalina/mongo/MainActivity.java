package com.example.samaracatalina.mongo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.samaracatalina.mongo.adapters.PeliculaAdapter;
import com.example.samaracatalina.mongo.models.Pelicula;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView list;

    PeliculaAdapter adapter;
    List<Pelicula> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list= (ListView) findViewById(R.id.list);

        data=new ArrayList<Pelicula>();
        adapter= new PeliculaAdapter(this, data);

        list.setAdapter(adapter);

    }

////   adapter.notifyDataSetChanged() ;

}
