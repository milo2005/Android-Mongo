package com.example.samaracatalina.mongo.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.samaracatalina.mongo.R;
import com.example.samaracatalina.mongo.models.Pelicula;

import java.util.List;

/**
 * Created by Samara Catalina on 25/03/2015.
 */
public class PeliculaAdapter extends BaseAdapter{


    Context context;
    List<Pelicula> data;

    public PeliculaAdapter(Context context, List<Pelicula> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {//// Numero elemtos
        return data.size();
    }

    @Override
    public Object getItem(int position) {///// Retorna obj de acuerdo a posicion
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {//// retorna Id posicion
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v;
        TextView txt_nombre, txt_duracion, txt_director, txt_idioma;

        if(convertView!=null){
            v=convertView;
        }
        else {
            v=View.inflate(context, R.layout.item_list,null);
        }

        Pelicula p= (Pelicula) getItem(position);

        txt_nombre= (TextView) v.findViewById(R.id.txt_nombre);
        txt_nombre.setText(p.getNombre());

        txt_duracion= (TextView) v.findViewById(R.id.txt_duracion);
        txt_duracion.setText(p.getNombre());

        txt_director= (TextView) v.findViewById(R.id.txt_director);
        txt_director.setText(p.getNombre());

        txt_idioma=(TextView) v.findViewById(R.id.txt_idioma);
        txt_idioma.setText(p.getIdioma());


        return  v;

        ///ConvertView es el view utilizado para el Template
    }
}
