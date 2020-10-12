package com.example.navigatio.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.navigatio.R;
import com.example.navigatio.database.Persona;
import com.example.navigatio.database.PersonaLab;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;
    private ListAdapter listItemAdapter;
    private ArrayList<Persona> listaNombres=new ArrayList<>();
    private ListView listView;
    private PersonaLab mPersonaLab;
    private Persona mPersona;
    private TextView guardar;
    private Button bguardar,blimpiar,beliminar;
    private EditText editText,text;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mPersonaLab=new PersonaLab(getContext());
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);


        View root = inflater.inflate(R.layout.fragment_home, container, false);
        guardar = root.findViewById(R.id.editTextTextPersonName);
        listView = root.findViewById(R.id.list);
        bguardar = root.findViewById(R.id.buttonGuardar);
        blimpiar = root.findViewById(R.id.buttonLimpiar);
        beliminar  = root.findViewById(R.id.buttonEliminar);





        getAllPersonas();
        listItemAdapter=new com.example.navigatio.adapter.ListAdapter(getContext(),listaNombres);
        listView.setAdapter(listItemAdapter);
        bguardar.setOnClickListener(this);
        blimpiar.setOnClickListener(this);
        beliminar.setOnClickListener(this);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;

    }

    /**
     * GUARDA EN LA BASE DE DATOS
     */
    public void insertPersonas() {
        mPersona=new Persona();
        mPersona.setNombre(guardar.getText().toString());
        mPersonaLab.addPersona(mPersona);
        guardar.setText(" ");

    }
    // CONSULTA A LA BASE DE DATOS
    public void getAllPersonas(){
        listaNombres.clear();
        listaNombres.addAll(mPersonaLab.getPersonas());

    }
    public void eliminar(){
       mPersona.getNombre();
       if (guardar.getText().equals( mPersona.getNombre())){
           mPersonaLab.deleteAllPersona();
           listaNombres.clear();


       }

            }


    // ACCION DE LOS BOTONES
    @Override
    public void onClick(View v) {
        if (v==blimpiar){

            mPersonaLab.deleteAllPersona();
            listaNombres.clear();


        }
        if (v==bguardar){
            insertPersonas();
            getAllPersonas();



        }
        if (v==beliminar){
            get.p


        }
    }

}