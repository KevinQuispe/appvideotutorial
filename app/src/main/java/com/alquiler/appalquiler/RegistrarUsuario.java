package com.alquiler.appalquiler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarUsuario extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    //declare variables
    EditText nombre,username,password,correo;
    Button registrar,nuevo;

    public RegistrarUsuario() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RegistrarUsuario newInstance(String param1, String param2) {
        RegistrarUsuario fragment = new RegistrarUsuario();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
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

    // Inflate the layout for this fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            //llamamos al identi,ficador
         View view=inflater.inflate(R.layout.fragment_registrar_usuario, container, false);

        nombre=(EditText)view.findViewById(R.id.editTextFulname);
        username=(EditText)view.findViewById(R.id.editTextusername);
        correo=(EditText)view.findViewById(R.id.editTextcorreo);
        password=(EditText)view.findViewById(R.id.editTextpassword);
        registrar=(Button) view.findViewById(R.id.btnregistrar);
        nuevo=(Button) view.findViewById(R.id.btnnuevo);
        nuevo.setOnClickListener(this);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnregistrar:
                        //declaramos el fragemento
                        Fragment fragment =new ListaUsuarios();
                        //bundle para pasar los datos
                        Bundle bundle = new Bundle();
                        bundle.putString("nombreKey", nombre.getText().toString());
                        bundle.putString("userKey", username.getText().toString());
                        bundle.putString("correoKey", correo.getText().toString());
                        bundle.putString("paswordKey",password.getText().toString());
                        fragment.setArguments(bundle);
                        //declaramos el fragment managmet para hacer coming y transat
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.contenedorfragment, fragment).commit();
                        Toast.makeText(getActivity(), "Se registro con exito", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        return view;
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

    @Override
    public void onClick(View v) {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
