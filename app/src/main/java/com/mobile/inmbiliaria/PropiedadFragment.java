package com.mobile.inmbiliaria;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.mobile.inmbiliaria.ui.model.Propiedad;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PropiedadFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PropiedadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PropiedadFragment extends Fragment  {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "aaaaa";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PropiedadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment PropiedadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PropiedadFragment newInstance(Propiedad propiedad) {
        PropiedadFragment fragment = new PropiedadFragment();
        Bundle args = new Bundle();
        args.putString("domicilio", propiedad.getDomicilio());
        args.putString("ambientes", propiedad.getAmbientes()+"");
        args.putString("tipo", propiedad.getTipo());
        args.putString("uso", propiedad.getUso());
        args.putString("precio", propiedad.getPrecio()+"");
        args.putBoolean("disponible", propiedad.isDisponible());

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View root= inflater.inflate(R.layout.fragment_propiedad, container, false);
        EditText editTextDomiclio= root.findViewById(R.id.editTextDomicilio);
        editTextDomiclio.setText(getArguments().getString("domicilio"));
        editTextDomiclio.setInputType(InputType.TYPE_NULL);
        editTextDomiclio.setFocusable(false);
        editTextDomiclio.setCursorVisible(false);


        EditText editTextAmbientes= root.findViewById(R.id.editTextAmbientes);
        editTextAmbientes.setText(getArguments().getString("ambientes"));
        editTextAmbientes.setInputType(InputType.TYPE_NULL);
        editTextAmbientes.setFocusable(false);
        editTextAmbientes.setCursorVisible(false);

        EditText editTextTipo= root.findViewById(R.id.editTextTipo);
        editTextTipo.setText(getArguments().getString("tipo"));
        editTextTipo.setInputType(InputType.TYPE_NULL);
        editTextTipo.setFocusable(false);
        editTextTipo.setCursorVisible(false);

        EditText editTextUso= root.findViewById(R.id.editTextUso);
        editTextUso.setText(getArguments().getString("uso"));
        editTextUso.setInputType(InputType.TYPE_NULL);
        editTextUso.setFocusable(false);
        editTextUso.setCursorVisible(false);

        EditText editTextPrecio= root.findViewById(R.id.editTextPrecio);
        editTextPrecio.setText(getArguments().getString("precio"));
        editTextPrecio.setInputType(InputType.TYPE_NULL);
        editTextPrecio.setFocusable(false);
        editTextPrecio.setCursorVisible(false);

        CheckBox checkBox=root.findViewById(R.id.checkBoxDisponible);
        checkBox.setChecked(getArguments().getBoolean("disponible"));



        return root;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
           throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }



}
