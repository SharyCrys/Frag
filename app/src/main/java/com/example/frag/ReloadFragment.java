package com.example.frag;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReloadFragment extends Fragment {

    Button button;

    public ReloadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        StrictMode.ThreadPolicy permiso = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(permiso);
        final View root = inflater.inflate(R.layout.fragment_reload,container,false);
        button = (Button)root.findViewById(R.id.menu_activity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), activity_menu.class);
                startActivityForResult(intent, 0);
            }
        });
        setHasOptionsMenu(true);
        return root;
    }


    @Override
    public void onCreateOptionsMenu( Menu menu,  MenuInflater inflater) {

        inflater.inflate(R.menu.menufrag, menu);

        return;
    }

     @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.cambiar)  {

            Toast.makeText(getActivity(),"Sort",Toast.LENGTH_LONG).show();

        }

        if (id == R.id.salir)  {

            Toast.makeText(getActivity(),"Sdort",Toast.LENGTH_LONG).show();

        }

        return super.onOptionsItemSelected(item);
    }
}
