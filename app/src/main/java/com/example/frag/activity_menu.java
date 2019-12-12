package com.example.frag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class activity_menu extends AppCompatActivity {

    TextView lorem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        lorem = (TextView)findViewById(R.id.lorem);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menufrag, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cambiar: {

                lorem.setTextColor(Color.parseColor("#D4AC0D"));
                break;


            }
            case R.id.salir: {
                 Intent intent = new Intent (this, MainActivity.class);
                startActivityForResult(intent, 0);
                break;


            }
        }
        return super.onOptionsItemSelected(item);
    }

}
