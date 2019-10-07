package com.mobile.inmbiliaria.ui.contratos;

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

public class ContratoFragment extends Fragment {
    private TextView nombrePropiedad;

    private ContratoViewModel contratoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contratoViewModel =ViewModelProviders.of(this).get(ContratoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contratos, container, false);
        nombrePropiedad= root.findViewById(R.id.textViewPropiedadNombre);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String propiedadDireccion = bundle.getString("NombrePropiedad");
            nombrePropiedad.setText(propiedadDireccion);

        }
        contratoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}