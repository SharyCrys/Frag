package com.example.frag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {

    ImageView foto;
    TextView titulo;
    TextView detalle;
    Button volver;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);

        foto = (ImageView) findViewById(R.id.foto);
        titulo = (TextView) findViewById(R.id.txtTitulo);
        detalle = (TextView) findViewById(R.id.txtDetalle);

        Datos obj = (Datos) getIntent().getExtras().getSerializable("objeto");

        titulo.setText(obj.getTitulo());
        detalle.setText(obj.getDetalle());
        foto.setImageResource(obj.getImagen());

        volver = (Button)findViewById(R.id.button);

        i = new Intent(Detalle.this, MainActivity.class);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.nav_items, menu);
    return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.salir:

                return true;
            case R.id.cambiar:

                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
