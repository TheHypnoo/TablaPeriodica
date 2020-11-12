package com.sergigonzalez.tablaperiodica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class menuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menuprincipal);
        Button Boton_Elementos = findViewById(R.id.bt_Elementos);
        Button Boton_Juego = findViewById(R.id.bt_Juego);
        Button Boton_Puntuacion = findViewById(R.id.bt_Puntuacion);
        Boton_Juego.setOnClickListener(v -> {
            Intent Juego = new Intent (v.getContext(), Game.class);
            startActivityForResult(Juego, 0);
        });
        Boton_Puntuacion.setOnClickListener(v -> {
            Toast.makeText(this,"Tu puntuación es de: ", Toast.LENGTH_LONG).show();
        });
        Boton_Elementos.setOnClickListener(v -> {
            Intent Elementos = new Intent (v.getContext(), allElementos.class);
            startActivityForResult(Elementos, 0);
        });
    }

}