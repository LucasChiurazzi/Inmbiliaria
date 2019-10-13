package com.mobile.inmbiliaria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mobile.inmbiliaria.ui.model.Propiedad;

import java.util.List;

public class ListaAdapter extends ArrayAdapter<Propiedad> {
private Context context;
private List<Propiedad> lista;
private  LayoutInflater li;


    public ListaAdapter(@NonNull Context context, int resource, @NonNull List<Propiedad> objects, LayoutInflater li) {
            super(context, resource, objects);

            this.context= context;
            this.lista= objects;
            this.li= li;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View itemView= convertView;
       if(itemView==null){
           itemView=li.inflate(R.layout.item, parent, false);
       }
       Propiedad inmueble= lista.get(position);

       ImageView foto= itemView.findViewById(R.id.foto);
       foto.setImageResource(inmueble.getFoto());

       TextView direccion= itemView.findViewById(R.id.direccion);
       direccion.setText(inmueble.getDomicilio());

       TextView precio= itemView.findViewById(R.id.precio);
       precio.setText("$ "+inmueble.getPrecio()+"");

       return itemView;
    }

}
