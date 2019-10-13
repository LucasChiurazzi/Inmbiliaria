package com.mobile.inmbiliaria;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.mobile.inmbiliaria.ui.model.Propiedad;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Button btlogin;
    private EditText user;
    private EditText pass;
    private ArrayList<Propiedad> lista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btlogin= findViewById(R.id.login);
        user= findViewById(R.id.username);
        pass= findViewById(R.id.password);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(StringUtils.isNoneEmpty(user.getText().toString())&&StringUtils.isNoneEmpty(pass.getText().toString())){
                    if(user.getText().toString().equals("Lucas")&&pass.getText().toString().equals("123")) {

                        Intent i = new Intent(getApplicationContext(), NavigationActivity.class);
                        i.putExtra("usuario",user.getText());
                        startActivity(i);

                    }else{
                        Toast.makeText(getApplicationContext(), "Usuario y/o Password incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Debe ingresar un usuario y una contraseña", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Cerrando Inmbiliaria")
                .setMessage("¿Desea salir de la aplicación?")
                .setPositiveButton("si", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                     finish();
                    }

                })
                .setNegativeButton("no", null)
                .show();

    }





}
