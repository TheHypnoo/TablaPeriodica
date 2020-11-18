package com.sergigonzalez.tablaperiodica;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Game extends AppCompatActivity {
    TextView enunciadoJuego;
    TextView muestraVidas;
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
        muestraVidas = findViewById(R.id.Vidas);
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
        enunciadoJuego.setText("Di el nombre del elemento del simbolo:\n "+allElementos.ArrElemento[elementoActual].getSimbolo());
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
                Toast.makeText(Game.this, "Te queda "+vida+" vidas", Toast.LENGTH_SHORT).show();
            } else if(vida == 1) {
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

    /*
    public void Game(){
        int ArrPos = (int)Math.floor(Math.random()*(-(116 + 0))+(116));
        int ArrPos2 = (int)Math.floor(Math.random()*(-(116 + 0))+(116));
        int ArrPos3 = (int)Math.floor(Math.random()*(-(116 + 0))+(116));
        int ArrPos4 = (int)Math.floor(Math.random()*(-(116 + 0))+(116));
        int aleatorio = (int)Math.floor(Math.random()*(-(10 + 0))+(10));
        int aleatorio2 = (int)Math.floor(Math.random()*(1-(4+1))+(4));
        //Hago que no se repitan!
        if(ArrPos == ArrPos2 || ArrPos == ArrPos3 || ArrPos == ArrPos4) {
            ArrPos = (int)Math.floor(Math.random()*(0-(116+1))+(116));
        } else if(ArrPos2 == ArrPos || ArrPos2 == ArrPos3 || ArrPos2 == ArrPos4) {
            ArrPos2 = (int)Math.floor(Math.random()*(0-(116+1))+(116));
        } else if(ArrPos3 == ArrPos || ArrPos3 == ArrPos2 || ArrPos3 == ArrPos4) {
            ArrPos3 = (int)Math.floor(Math.random()*(0-(116+1))+(116));
        } else if(ArrPos4 == ArrPos || ArrPos4 == ArrPos2 || ArrPos4 == ArrPos3) {
            ArrPos4 = (int)Math.floor(Math.random()*(0-(116+1))+(116));
        }

       // if(aleatorio <= 5) {
            enunciadoJuego.setText("Selecciona cual es el nombre de este Simbolo: "+allElementos.ArrElemento[ArrPos].getSimbolo());
            if(aleatorio2 == 1) {
                bt_radio1.setText(allElementos.ArrElemento[ArrPos].getNombre());
                bt_radio2.setText(allElementos.ArrElemento[ArrPos2].getNombre());
                bt_radio3.setText(allElementos.ArrElemento[ArrPos3].getNombre());
                bt_radio4.setText(allElementos.ArrElemento[ArrPos4].getNombre());
            } else if(aleatorio2 == 2) {
                bt_radio1.setText(allElementos.ArrElemento[ArrPos2].getNombre());
                bt_radio2.setText(allElementos.ArrElemento[ArrPos].getNombre());
                bt_radio3.setText(allElementos.ArrElemento[ArrPos3].getNombre());
                bt_radio4.setText(allElementos.ArrElemento[ArrPos4].getNombre());
            } else if(aleatorio2 == 3) {
                bt_radio1.setText(allElementos.ArrElemento[ArrPos2].getNombre());
                bt_radio2.setText(allElementos.ArrElemento[ArrPos3].getNombre());
                bt_radio3.setText(allElementos.ArrElemento[ArrPos].getNombre());
                bt_radio4.setText(allElementos.ArrElemento[ArrPos4].getNombre());
            } else if(aleatorio2 == 4) {
                bt_radio1.setText(allElementos.ArrElemento[ArrPos2].getNombre());
                bt_radio2.setText(allElementos.ArrElemento[ArrPos3].getNombre());
                bt_radio3.setText(allElementos.ArrElemento[ArrPos4].getNombre());
                bt_radio4.setText(allElementos.ArrElemento[ArrPos].getNombre());
            }
        } else if( aleatorio > 5) {
            enunciadoJuego.setText("Selecciona cual es el Simbolo de este nombre: "+allElementos.ArrElemento[ArrPos].getNombre());
            if(aleatorio2 == 1) {
                bt_radio1.setText(allElementos.ArrElemento[ArrPos].getSimbolo());
                bt_radio2.setText(allElementos.ArrElemento[ArrPos2].getSimbolo());
                bt_radio3.setText(allElementos.ArrElemento[ArrPos3].getSimbolo());
                bt_radio4.setText(allElementos.ArrElemento[ArrPos4].getSimbolo());
            } else if(aleatorio2 == 2) {
                bt_radio1.setText(allElementos.ArrElemento[ArrPos2].getSimbolo());
                bt_radio2.setText(allElementos.ArrElemento[ArrPos].getSimbolo());
                bt_radio3.setText(allElementos.ArrElemento[ArrPos3].getSimbolo());
                bt_radio4.setText(allElementos.ArrElemento[ArrPos4].getSimbolo());
            } else if(aleatorio2 == 3) {
                bt_radio1.setText(allElementos.ArrElemento[ArrPos2].getSimbolo());
                bt_radio2.setText(allElementos.ArrElemento[ArrPos3].getSimbolo());
                bt_radio3.setText(allElementos.ArrElemento[ArrPos].getSimbolo());
                bt_radio4.setText(allElementos.ArrElemento[ArrPos4].getSimbolo());
            } else if(aleatorio2 == 4) {
                bt_radio1.setText(allElementos.ArrElemento[ArrPos2].getSimbolo());
                bt_radio2.setText(allElementos.ArrElemento[ArrPos3].getSimbolo());
                bt_radio3.setText(allElementos.ArrElemento[ArrPos4].getSimbolo());
                bt_radio4.setText(allElementos.ArrElemento[ArrPos].getSimbolo());
            }
        }



        int finalArrPos = ArrPos;
        bt_corregir.setOnClickListener(v -> {
            if(bt_radio1.getText().toString().equals(allElementos.ArrElemento[finalArrPos].getNombre())) {
                System.out.println("Correcto!1");
                Game();
            } else if(bt_radio2.getText().toString().equals(allElementos.ArrElemento[finalArrPos].getNombre())){
                System.out.println("Correcto!2");
                Game();
            } else if(bt_radio3.getText().toString().equals(allElementos.ArrElemento[finalArrPos].getNombre())) {
                System.out.println("Correcto!3");
                Game();
            } else if(bt_radio4.getText().toString().equals(allElementos.ArrElemento[finalArrPos].getNombre())) {
                System.out.println("Correcto!4");
                Game();
            } else if(!bt_radio1.getText().toString().equals(allElementos.ArrElemento[finalArrPos].getNombre())) {
                System.out.println("Incorrecto!1");
            } else if(!bt_radio2.getText().toString().equals(allElementos.ArrElemento[finalArrPos].getNombre())){
                System.out.println("Incorrecto!2");
            } else if(!bt_radio3.getText().toString().equals(allElementos.ArrElemento[finalArrPos].getNombre())) {
                System.out.println("Incorrecto!3");
            } else if(!bt_radio4.getText().toString().equals(allElementos.ArrElemento[finalArrPos].getNombre())) {
                System.out.println("Incorrecto!4");
                /*
            } else if(bt_radio1.getText() == allElementos.ArrElemento[finalArrPos].getSimbolo()) {
                System.out.println("Correcto!5");
                Game();
            } else if(bt_radio2.getText() == allElementos.ArrElemento[finalArrPos].getSimbolo()){
                System.out.println("Correcto!6");
                Game();
            } else if(bt_radio3.getText() == allElementos.ArrElemento[finalArrPos].getSimbolo()) {
                System.out.println("Correcto!7");
                Game();
            } else if(bt_radio4.getText() == allElementos.ArrElemento[finalArrPos].getSimbolo()) {
                System.out.println("Correcto!8");
                Game();
            }else if(bt_radio1.getText() != allElementos.ArrElemento[finalArrPos].getSimbolo()) {
                System.out.println("Incorrecto!5");
            } else if(bt_radio2.getText() != allElementos.ArrElemento[finalArrPos].getSimbolo()){
                System.out.println("Incorrecto!6");
            } else if(bt_radio3.getText() != allElementos.ArrElemento[finalArrPos].getSimbolo()) {
                System.out.println("Incorrecto!7");
            } else if(bt_radio4.getText() != allElementos.ArrElemento[finalArrPos].getSimbolo()) {
                System.out.println("Incorrecto!8");
            }

        }});

        */
}