package com.alquiler.appalquiler;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarHabitacion extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    EditText edit_message;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    EditText campoNumHab,campoPrecio,campoServicio,campoDni,campoNombres,campoTelefono,campoCorreo;
    Button registrar;
    public RegistrarHabitacion() {
        // Required empty public constructor
    }

    public static RegistrarHabitacion newInstance(String param1, String param2) {
        RegistrarHabitacion fragment = new RegistrarHabitacion();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_registrar_habitacion, container, false);
        campoNumHab=(EditText) view.findViewById(R.id.editTextnumero);
        campoPrecio=(EditText) view.findViewById(R.id.editTextprecio);
        campoServicio=(EditText) view.findViewById(R.id.editTextservicio);
        registrar=(Button) view.findViewById(R.id.btnregistrarh);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnregistrarh:
                        //declaramos el fragemento
                        Fragment fragment =new HabitacionesDisponibles();
                        //bundle para pasar los datos
                        Bundle bundle = new Bundle();
                        bundle.putString("nuemroKey", campoNumHab.getText().toString());
                        bundle.putString("precioKey", campoPrecio.getText().toString());
                        bundle.putString("servicioKey", campoServicio.getText().toString());

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
