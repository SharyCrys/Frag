package com.example.frag;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {

    ListView leerdatos;
    Button boton;


    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        StrictMode.ThreadPolicy permiso = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(permiso);


        final View root = inflater.inflate(R.layout.fragment_book,container,false);
        leerdatos = (ListView)root.findViewById(R.id.leer_datos);
        boton = (Button)root.findViewById(R.id.boton_leer);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    CargaDatos(getView());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        return root;
    }

    public void CargaDatos(View view) throws IOException {

        List<String> listado = new ArrayList<String>();
        String linea;

        InputStream is =  this.getResources().openRawResource(R.raw.data);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        if (is!=null){
            while ((linea=reader.readLine())!=null){
                //listado.add(linea.split(";")[0]);
                listado.add(linea); //Leer toda la linea

            }
        }
        is.close();

        //Toast.makeText(getContext(),"Carga" + listado.size(), Toast.LENGTH_LONG).show();

        String datos[] = listado.toArray(new String[listado.size()]);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,datos);
        leerdatos.setAdapter(adapter);



    }



}
