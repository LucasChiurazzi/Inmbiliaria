package com.mobile.inmbiliaria.ui.listaPropiedades.propiedades;


import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.tabs.TabLayout;
import com.mobile.inmbiliaria.ListaAdapter;
import com.mobile.inmbiliaria.PropiedadFragment;
import com.mobile.inmbiliaria.R;
import com.mobile.inmbiliaria.ui.contratos.ContratoFragment;
import com.mobile.inmbiliaria.ui.model.Propiedad;
import com.mobile.inmbiliaria.ui.propiedades.PropiedadesFragment;

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
                    ContratoFragment contratoFragment = new ContratoFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("NombrePropiedad", propiedad.getDireccion());
                    contratoFragment.setArguments(bundle);
                    ViewGroup vg= (ViewGroup)getView().getParent();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(vg.getId(), contratoFragment, "findThisFragment")
                            .addToBackStack(null)
                            .commit();
                    DrawerLayout drawer=(DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                    drawer.closeDrawer(GravityCompat.START);
                }
            }

        });

        return view;
    }

    public  void  cargarDatos(){
        lista.add(new Propiedad(1,R.drawable.casa1, "Juana Koslay", 900000));
        lista.add(new Propiedad(2,R.drawable.casa2, "La Punta", 2000000));
        lista.add(new Propiedad(3, R.drawable.casa3, "San Luis", 800000));
    }

}
