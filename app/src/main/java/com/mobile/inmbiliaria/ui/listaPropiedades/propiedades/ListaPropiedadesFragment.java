package com.mobile.inmbiliaria.ui.listaPropiedades.propiedades;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.mobile.inmbiliaria.ListaAdapter;
import com.mobile.inmbiliaria.R;
import com.mobile.inmbiliaria.ui.contratos.ContratoFragment;
import com.mobile.inmbiliaria.ui.model.Propiedad;

import java.util.ArrayList;


public class ListaPropiedadesFragment extends Fragment {

    private ArrayList<Propiedad> lista = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_lista_propiedades, container, false);
        cargarDatos();
        ArrayAdapter<Propiedad> adapter= new ListaAdapter(getContext(), R.layout.item, lista, getLayoutInflater());
        ListView lv= view.findViewById(R.id.milista);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Propiedad propiedad= (Propiedad)adapterView.getItemAtPosition(i);
                if(propiedad!=null) {


                    Bundle bundle = new Bundle();
                    bundle.putString("NombrePropiedad", propiedad.getDireccion());
                    CharSequence destino=Navigation.findNavController(view).getCurrentDestination().getLabel();
                    Log.d("destino", "onItemClick: "+destino);

                    if("Contratos".equals(destino)){
                        Navigation.findNavController(view).navigate(R.id.nav_contratos, bundle);
                    }else {
                        Navigation.findNavController(view).navigate(R.id.nav_pagos, bundle);
                    }

                }
            }

        });

        return view;
    }

    public  void  cargarDatos(){
        lista.clear();
        lista.add(new Propiedad(1,R.drawable.casa1, "Juana Koslay", 900000));
        lista.add(new Propiedad(2,R.drawable.casa2, "La Punta", 2000000));
        lista.add(new Propiedad(3, R.drawable.casa3, "San Luis", 800000));

    }

}
