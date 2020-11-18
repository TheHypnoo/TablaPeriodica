package com.sergigonzalez.tablaperiodica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {
    TextView enunciadoJuego;
    TextView Simbolo;
    TextView muestraVidas;
    ImageView tresCorazones;
    ImageView dosCorazones;
    ImageView unCorazon;
    RadioButton bt_radio1;
    RadioButton bt_radio2;
    RadioButton bt_radio3;
    RadioButton bt_radio4;
    Button bt_corregir;
    int Puntuacion;
    TextView PuntMaximo;
    TextView Restante;
    int elementoActual = 0;
    int vida = 3;
    SharedPreferences sharedpreferences;
    String Puntua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);
        sharedpreferences = getSharedPreferences("Puntuacion", Context.MODE_PRIVATE);
        Puntua = sharedpreferences.getString("Puntuacion", "0");
        FindID();
        CargaPuntuacion();
        preguntaActual();
        bt_corregir.setOnClickListener(v -> {
            CheckToNext();
            CargaPuntuacion();
        });
    }

    public void FindID() {
        enunciadoJuego = findViewById(R.id.enunciadoJuego);
        Simbolo = findViewById(R.id.simboloTextView);
        muestraVidas = findViewById(R.id.Vidas);
        tresCorazones = findViewById(R.id.trescorazones);
        dosCorazones = findViewById(R.id.doscorazones);
        unCorazon = findViewById(R.id.uncorazon);
        bt_radio1 = findViewById(R.id.bt_radio1);
        bt_radio2 = findViewById(R.id.bt_radio2);
        bt_radio3 = findViewById(R.id.bt_radio3);
        bt_radio4 = findViewById(R.id.bt_radio4);
        bt_corregir = findViewById(R.id.bt_corregir);
        PuntMaximo = findViewById(R.id.PuntMaximo);
        Restante = findViewById(R.id.Restante);
    }

    public void GuardaPuntuacion() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("Puntuacion", String.valueOf(Puntuacion));
        editor.apply();
    }

    @SuppressLint("SetTextI18n")
    public void CargaPuntuacion() {
        if(Integer.parseInt(Puntua) == 0 && Puntuacion == 0) {
            PuntMaximo.setText("Puntuacion maxima: 0");
        } else if(Integer.parseInt(Puntua) >= Puntuacion) {
            PuntMaximo.setText("Puntuación maxima: "+ Puntua);
        }

    }


    @SuppressLint("SetTextI18n")
    public void preguntaActual(){
        Restante.setText("Restante "+ elementoActual +" / 117");
        enunciadoJuego.setText("Selecciona cual es el nombre que tiene este Simbolo: ");
        Simbolo.setText(allElementos.ArrElemento[elementoActual].getSimbolo());
        int numAux = (int) (Math.random()*4+1);
        muestraVidas.setText(String.valueOf(vida));
        if(numAux==1)
        {
            bt_radio1.setText(allElementos.ArrElemento[elementoActual].getNombre());
            bt_radio2.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
            bt_radio3.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
            bt_radio4.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
        }
        else{
            if(numAux==2)
            {
                bt_radio1.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
                bt_radio2.setText(allElementos.ArrElemento[elementoActual].getNombre());
                bt_radio3.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
                bt_radio4.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
            }
            else{
                if(numAux==3)
                {
                    bt_radio1.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
                    bt_radio2.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
                    bt_radio3.setText(allElementos.ArrElemento[elementoActual].getNombre());
                    bt_radio4.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
                }
                else{
                    if(numAux==4)
                    {
                        bt_radio1.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
                        bt_radio2.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
                        bt_radio3.setText(allElementos.ArrElemento[(int) (Math.random()*116+0)].getNombre());
                        bt_radio4.setText(allElementos.ArrElemento[elementoActual].getNombre());
                    }
                }
            }
        }
    }

    public void unCheckRadioButtons() {
        RadioGroup desm=findViewById(R.id.grupoBotones);
        desm.clearCheck();
    }

    public void CheckToNext() {

        int radioButtonSeleccionado = -1;
        if (bt_radio1.isChecked()) {
            if (bt_radio1.getText().toString().equalsIgnoreCase(allElementos.ArrElemento[elementoActual].getNombre())) {
                radioButtonSeleccionado = 0;
            }
        } else if (bt_radio2.isChecked()) {
            if (bt_radio2.getText().toString().equalsIgnoreCase(allElementos.ArrElemento[elementoActual].getNombre())) {
                radioButtonSeleccionado = 1;
            }
        } else if (bt_radio3.isChecked()) {
            if (bt_radio3.getText().toString().equalsIgnoreCase(allElementos.ArrElemento[elementoActual].getNombre())) {
                radioButtonSeleccionado = 2;
            }
        } else if (bt_radio4.isChecked()) {
            if (bt_radio4.getText().toString().equalsIgnoreCase(allElementos.ArrElemento[elementoActual].getNombre())) {
                radioButtonSeleccionado = 3;
            }
        }
        unCheckRadioButtons();

        if (radioButtonSeleccionado != -1) {

            Puntuacion++;

            Toast.makeText(Game.this, "Muy bien! has acertado", Toast.LENGTH_SHORT).show();
            elementoActual++;

            if (elementoActual < 117) {
                new Handler(Looper.getMainLooper()).postDelayed(this::preguntaActual, 350);
            } else {
                Toast.makeText(Game.this, "Juego terminado!", Toast.LENGTH_SHORT).show();
            }

        } else {
            elementoActual++;

            if (elementoActual < 117) {
                new Handler(Looper.getMainLooper()).postDelayed(this::preguntaActual, 350);
            } else {
                Toast.makeText(Game.this, "Juego terminado!", Toast.LENGTH_SHORT).show();
            }


            vida--;
            if(vida == 2) {
                tresCorazones.setVisibility(View.GONE);
                dosCorazones.setVisibility(View.VISIBLE);
                Toast.makeText(Game.this, "Te queda "+vida+" vidas", Toast.LENGTH_SHORT).show();
            } else if(vida == 1) {
                dosCorazones.setVisibility(View.GONE);
                unCorazon.setVisibility(View.VISIBLE);
                Toast.makeText(Game.this, "Cuidado te queda solamente "+vida+" vida!", Toast.LENGTH_SHORT).show();
            } else if(vida == 0) {
                Toast.makeText(Game.this, "Te has quedado sin vidas!", Toast.LENGTH_SHORT).show();
                new Handler(Looper.getMainLooper()).postDelayed(this::finish, 850);
            }
        }

        String Puntua = sharedpreferences.getString("Puntuacion", "0");
        if(Integer.parseInt(Puntua) <= Puntuacion) {
            GuardaPuntuacion();
        }

    }
}