package com.mobile.inmbiliaria.ui.pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mobile.inmbiliaria.R;

public class PagosFragment extends Fragment {
    private TextView nombrePropiedad;

    private PagosViewModel pagosViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pagosViewModel =
                ViewModelProviders.of(this).get(PagosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        nombrePropiedad= root.findViewById(R.id.textViewPropiedadNombre);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String propiedadDireccion = bundle.getString("NombrePropiedad");
            nombrePropiedad.setText(propiedadDireccion);

        }
        pagosViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}