package com.mobile.inmbiliaria.ui.exit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.mobile.inmbiliaria.NavigationActivity;
import com.mobile.inmbiliaria.R;

public class ExitFragment extends Fragment {

    private ExitViewModel exitViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exitViewModel =
                ViewModelProviders.of(this).get(ExitViewModel.class);
        View root = inflater.inflate(R.layout.fragment_exit, container, false);
        //add confirmation dialog
           new AlertDialog.Builder(getContext())
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Cerrando Sesion")
                    .setMessage("¿Desea cerrar su sesion?")
                    .setPositiveButton("si", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        getActivity().getParent().onBackPressed();
                        }

                    })
                    .setNegativeButton("no", null)
                    .show();



        exitViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

}