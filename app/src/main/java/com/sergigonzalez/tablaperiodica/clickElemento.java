package com.sergigonzalez.tablaperiodica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class clickElemento extends AppCompatActivity {

    TextView muestraNombre;
    TextView muestraSimbolo;
    TextView muestraEstado;
    TextView muestraNumeroAtomico;
    TextView muestraSerieQuimica;
    TextView muestraPeso;
    ImageView clickURL;
    Button bt_compartir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_click_elemento);
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();

        // Mostrem el botó enrera que cal capturar en l'envent onOptionsItemSelected
        actionBar.setDisplayHomeAsUpEnabled(true);
        findID();
        Bundle bundle = getIntent().getExtras();
        String[] InfoElemento = bundle.getStringArray("Elemento");
        muestraNombre.setText(InfoElemento[0]);
        muestraSimbolo.setText(InfoElemento[1]);
        muestraEstado.setText(InfoElemento[2]);
        muestraNumeroAtomico.setText(InfoElemento[3]);
        muestraSerieQuimica.setText(InfoElemento[4]);
        muestraPeso.setText(InfoElemento[5]);
        actionBar.setTitle("                   "+muestraNombre.getText().toString()); // set the top title
        clickURL.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(InfoElemento[6]));
            startActivity(i);
        });
        bt_compartir.setOnClickListener(v -> {
            Intent compartir = new Intent(android.content.Intent.ACTION_SEND);
            compartir.setType("text/plain");
            String mensaje = "Elemento: "+InfoElemento[0]+" \nSimbolo: "+InfoElemento[1]+" \nEstado: "+InfoElemento[2]+" \nNumero Atomico: "+InfoElemento[3]+" \nSerie Quimica: "+InfoElemento[4]+" \nPeso del elemento: "+InfoElemento[5]+" \n+Info: "+InfoElemento[6];
            compartir.putExtra(android.content.Intent.EXTRA_SUBJECT, "Tabla Periodica");
            compartir.putExtra(android.content.Intent.EXTRA_TEXT, mensaje);
            startActivity(Intent.createChooser(compartir, "Compartir vía"));
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    public void findID(){
        muestraNombre = findViewById(R.id.muestraNombre);
        muestraSimbolo = findViewById(R.id.muestraSimbolo);
        muestraEstado = findViewById(R.id.muestraEstado);
        muestraNumeroAtomico = findViewById(R.id.muestraNumeroAtomico);
        muestraSerieQuimica = findViewById(R.id.muestraSerieQuimica);
        muestraPeso = findViewById(R.id.muestraPeso);
        clickURL = findViewById(R.id.clickURL);
        bt_compartir = findViewById(R.id.bt_compartir);
    }
}