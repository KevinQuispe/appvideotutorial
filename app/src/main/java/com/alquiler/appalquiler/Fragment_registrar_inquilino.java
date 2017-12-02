package com.alquiler.appalquiler;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Fragment_registrar_inquilino extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    EditText campoDNI,campoNombre,campoTelefono,campoCorreo;
    Button btnRegistraPerson;


    public Fragment_registrar_inquilino() {
        // Required empty public constructor
    }


    public static Fragment_registrar_inquilino newInstance(String param1, String param2) {
        Fragment_registrar_inquilino fragment = new Fragment_registrar_inquilino();
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
        View view=inflater.inflate(R.layout.fragment_fragment_registrar_inquilino, container, false);

        campoDNI=(EditText) view.findViewById(R.id.ETdni);
        campoNombre=(EditText) view.findViewById(R.id.etNombres);
        campoTelefono=(EditText) view.findViewById(R.id.etTelefono);
        campoCorreo=(EditText) view.findViewById(R.id.etCorreo);
        btnRegistraPerson=(Button) view.findViewById(R.id.btnregistrarInquilino);

        btnRegistraPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnregistrarInquilino:
                        //declaramos el fragemento
                        Fragment fragment =new ListaInquilinos();
                        //bundle para pasar los datos
                        Bundle bundle = new Bundle();
                        bundle.putString("dniKey", campoDNI.getText().toString());
                        bundle.putString("nombreKey", campoNombre.getText().toString());
                        bundle.putString("telefonoKey", campoTelefono.getText().toString());
                        bundle.putString("correoKey", campoCorreo.getText().toString());
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

    public void registrarSQLpersona() {

    }

    private void registrarPersona() {

    }

    private void limpiar() {
        campoDNI.setText("");
        campoNombre.setText("");
        campoTelefono.setText("");
        campoCorreo.setText("");
    }
}
