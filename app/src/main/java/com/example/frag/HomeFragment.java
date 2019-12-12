package com.example.frag;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment{

    ListView listaDatos;
    ArrayList<Datos> Lista;
    Button button;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        StrictMode.ThreadPolicy permiso = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(permiso);

        final View root = inflater.inflate(R.layout.fragment_home,container,false);



        listaDatos = (ListView)root.findViewById(R.id.lstDatos);

        Lista = new ArrayList<Datos>();
        Lista.add(new Datos(1,"Ejemplo de dato","Primera prueba de dato.", R.drawable.hola));
        Lista.add(new Datos(2,"Otro ejemplo de dato","Prueba dos de dato", R.drawable.gato2));
        Lista.add(new Datos(3,"Algún ejemplo","Prueba tres de dato", R.drawable.gato3));
        Lista.add(new Datos(4,"Otro ejemplo cualquiera.","¡Finalizado!", R.drawable.gato5));

        Adaptador miadaptador = new Adaptador(getContext(),Lista);

        listaDatos.setAdapter(miadaptador);

        listaDatos.setOnItemClickListener(new OnItemClickListener() {




            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Datos obj = (Datos)parent.getItemAtPosition(position);
                Intent paso = new Intent(getContext(),Detalle.class);
                paso.putExtra("objeto",(Serializable) obj);
                startActivity(paso);

            }
        });


        return root;
    }

}
