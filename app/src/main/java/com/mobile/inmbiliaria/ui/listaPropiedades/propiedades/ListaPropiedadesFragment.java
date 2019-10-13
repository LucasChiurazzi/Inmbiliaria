package com.mobile.inmbiliaria.ui.listaPropiedades.propiedades;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.mobile.inmbiliaria.ListaAdapter;
import com.mobile.inmbiliaria.R;
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
                    bundle.putString("NombrePropiedad", propiedad.getDomicilio());
                    CharSequence destino=Navigation.findNavController((View)view.getParent()).getCurrentDestination().getLabel();

                    Log.d("destino", "onItemClick: "+destino);
                    if( propiedad.isDisponible()){
                        Toast.makeText(getContext(), "La Propiedad esta disponible, no posee datos de contrato o de pagos.", Toast.LENGTH_SHORT).show();
                    }else {
                        if ("Contratos".equalsIgnoreCase(destino.toString())) {
                            Navigation.findNavController(view).navigate(R.id.action_nav_contratos_to_nav_contratos_propiedad, bundle);
                        } else {
                            Navigation.findNavController(view).navigate(R.id.nav_pagos_propiedad, bundle);
                        }
                    }



                }
            }

        });

        return view;
    }

    public  void  cargarDatos(){
        lista.clear();
        lista.add(new Propiedad(1,R.drawable.casa1, "Justo Daract 300", 2, "casa", "residencial", 6500, true));
        lista.add(new Propiedad(2,R.drawable.casa2, "Serranias Puntanas 4010", 3, "casa","residencial", 3000, false));
        lista.add(new Propiedad(3, R.drawable.casa3, "Bolivar 930", 1, "casa", "comercial",4000, false));

    }

}
