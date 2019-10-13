package com.mobile.inmbiliaria.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.navigation.NavigationView;
import com.mobile.inmbiliaria.R;
import com.mobile.inmbiliaria.ui.model.Propietario;

public class PerfilFragment extends Fragment {
    private Button editar;
    private Button guardar;
    private Propietario propietario;
    private EditText etDni;
    private EditText etNombre;
    private EditText etApellido;
    private EditText etMail;
    private EditText etTelefono;
    private EditText etClave;

    private TextView dni;
    private TextView apellido;
    private TextView nombre;
    private TextView mail;
    private TextView telefono;
    private TextView clave;


    private TextView mailHeaderNav;
    private TextView nameHeaderNav;





    private PerfilViewModel perfilViewModel ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                ViewModelProviders.of(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        nameHeaderNav = (TextView) headerView.findViewById(R.id.NameHeaderNav);
        nameHeaderNav.setText(((TextView)root.findViewById(R.id.nombre)).getText().toString());
        mailHeaderNav = (TextView) headerView.findViewById(R.id.MailHeaderNav);
        mailHeaderNav.setText(((TextView)root.findViewById(R.id.mail)).getText().toString());





        Button button = root.findViewById(R.id.buttonEditar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {   editar(v, dni, etDni, R.id.editTextDocument, R.id.document);
                editar(v, apellido, etApellido, R.id.etApellido, R.id.apellido);
                editar(v, nombre, etNombre, R.id.editTextNombre, R.id.nombre);
                editar(v, mail, etMail, R.id.editTextMail, R.id.mail);
                editar(v, telefono, etTelefono, R.id.editTextTelefono, R.id.telefono);
                editar(v, clave, etClave, R.id.editTextPass, R.id.clave);


                guardar = ((View)v.getParent()).findViewById(R.id.buttonGuardar);
                guardar.setEnabled(true);

            }
        });
        guardar= root.findViewById(R.id.buttonGuardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                guardar(v, dni, etDni, R.id.editTextDocument, R.id.document);
                guardar(v, apellido, etApellido, R.id.etApellido, R.id.apellido);
                guardar(v, nombre, etNombre, R.id.editTextNombre, R.id.nombre);
                guardar(v, mail, etMail, R.id.editTextMail, R.id.mail);
                guardar(v, telefono, etTelefono, R.id.editTextTelefono, R.id.telefono);
                guardar(v, clave, etClave, R.id.editTextPass, R.id.clave);
                nameHeaderNav.setText(((TextView)((View)v.getParent()).findViewById(R.id.nombre)).getText().toString());
                mailHeaderNav.setText(((TextView)((View)v.getParent()).findViewById(R.id.mail)).getText().toString());

                guardar.setEnabled(false);

            }
        });



                perfilViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {



            }
        });
        return root;
    }
    public void editar(View v, TextView tv, EditText et, Integer idEt, Integer idTv){
        et = ((View)v.getParent()).findViewById(idEt);
        et.setVisibility(View.VISIBLE);
        tv = ((View)v.getParent()).findViewById(idTv);
        tv.setVisibility(View.INVISIBLE);
    }
    public void guardar(View v, TextView tv, EditText et, Integer idEt, Integer idTv){
        et = ((View)v.getParent()).findViewById(idEt);
        tv = ((View)v.getParent()).findViewById(idTv);
        tv.setText(et.getText().toString());
        et.setVisibility(View.INVISIBLE);
        tv.setVisibility(View.VISIBLE);
    }


}