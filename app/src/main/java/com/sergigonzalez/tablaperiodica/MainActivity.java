package com.sergigonzalez.tablaperiodica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String solid = "solid";
    final String liquid = "liquid";
    final String gasos = "gasos";
    final String sintetics = "sintetics";

    final String metallTrans = "Metall_Transicio";
    final String metallAlc = "Metall_Alcalins";
    final String alcalinoterris = "Alcalinoterris";
    final String lantanids = "Lantanids";
    final String actinidis = "Actinidis";
    final String metallsBlocP = "Metalls_bloc_p";
    final String metaloides = "Metaloides";
    final String noMetalls = "No_metalls";
    final String halogens = "Halogens";
    final String gasosNobl = "Gasos_nobles";

    private final Elemento[] ArrElemento = new Elemento[]{
            //Primeros 25 TheHypnoo
            new Elemento(actinidis, solid, "Ac", "89", "Actinio", "10.070", "https"),
            new Elemento(metallsBlocP, solid, "Al", "13", "Aluminio", "26,9815", "https"),
            new Elemento(actinidis, solid, "Am", "95", "Americio", "243", "https"),
            new Elemento(metaloides, solid, "Sb", "51", "Antimonio", "121,76", "https"),
            new Elemento(gasosNobl, gasos, "Ar", "18", "Argón", "39,948", "https"),
            new Elemento(metaloides, solid, "As", "33", "Arsénico", "74,922", "https"),
            new Elemento(halogens, solid, "At", "85", "Astato", "210", "https"),
            new Elemento(noMetalls, solid, "S", "16", "Azufre", "32,064", "https"),
            new Elemento(alcalinoterris, solid, "Ba", "56", "Bario", "137,34", "https"),
            new Elemento(alcalinoterris, solid, "Be", "4", "Berilio", "9,0122", "https"),
            new Elemento(actinidis, solid, "Bk", "97", "Berkelio", "247", "https"),
            new Elemento(metallsBlocP, solid, "Bi", "83", "Bismuto", "208,980", "https"),
            new Elemento(metallTrans, solid, "Bh", "107", "Bohrio", "262", "https"),
            new Elemento(metaloides, solid, "B", "5", "Boro", "10,811", "https"),
            new Elemento(noMetalls, liquid, "Br", "35", "Bromo", "79.909", "https"),
            new Elemento(metallTrans, solid, "Cd", "48", "Cadmio", "112,40", "https"),
            new Elemento(alcalinoterris, solid, "Ca", "20", "Calcio", "40,08", "https"),
            new Elemento(actinidis, solid, "Cf", "98", "Californio", "251", "https"),
            new Elemento(noMetalls, solid, "C", "6", "Carbono", "12,01115", "https"),
            new Elemento(lantanids, solid, "Ce", "58", "Cerio", "140,12", "https"),
            new Elemento(alcalinoterris, solid, "Cs", "55", "Cesio", "132,905", "https"),
            new Elemento(halogens, gasos, "Cl", "17", "Cloro", "35,453", "https"),
            new Elemento(metallTrans, solid, "Co", "27", "Cobalto", "58,93", "https"),
            new Elemento(metallTrans, solid, "Cu", "29", "Cobre", "63,54", "https"),
            new Elemento(metallTrans, solid, "Cn", "112", "Copernicio", "285", "https"),
            //Segundos 25 David
            new Elemento(metallTrans, solid, "Cr", "24", "Cromo", "51,9962", "https"),
            new Elemento(actinidis, sintetics, "Cm", "96", "Curio", "247", "https"),
            new Elemento(metallTrans, sintetics, "Ds", "110", "Darmstadio", "271", "https"),
            new Elemento(lantanids, solid, "Dy", "66", "Disprosio", "162,500", "https"),
            new Elemento(metallTrans, sintetics, "Db", "105", "Dubnio", "264", "https"),
            new Elemento(actinidis, sintetics, "Es", "99", "Einstenio", "252", "https"),
            new Elemento(lantanids, solid, "Er", "68", "Erbio", "167,259", "https"),
            new Elemento(metallTrans, solid, "Sc", "21", "Escandio", "44,95591", "https"),
            new Elemento(metallsBlocP, solid, "Sn", "50", "Estaño", "118,710", "https"),
            new Elemento(alcalinoterris, solid, "Sr", "38", "Estroncio", "87,62", "https"),
            new Elemento(lantanids, solid, "Eu", "63", "Europio", "151,964", "https"),
            new Elemento(actinidis, sintetics, "Fm", "100", "Fermio", "257", "https"),
            new Elemento(metallsBlocP, sintetics, "FI", "114", "Flerovium", "289", "https"),
            new Elemento(actinidis, sintetics, "F", "9", "Fluor", "18,998403", "https"),
            new Elemento(halogens, gasos, "P", "15", "Fosforo", "39,97696", "https"),
            new Elemento(metallAlc, solid, "Fr", "87", "Francio", "223", "https"),
            new Elemento(lantanids, solid, "Gd", "64", "Gadolinio", "157,25", "https"),
            new Elemento(metallsBlocP, solid, "Ga", "31", "Galio", "69,723", "https"),
            new Elemento(metaloides, solid, "Ge", "32", "Germanio", "77,64", "https"),
            new Elemento(metallTrans, solid, "Hf", "72", "Hafnio", "69,723", "https"),
            new Elemento(metallTrans, sintetics, "Hs", "108", "Hassio", "277", "https"),
            new Elemento(gasosNobl, gasos, "He", "2", "Helio", "4,002602", "https"),
            new Elemento(noMetalls, gasos, "H", "1", "Hidrogeno", "1,00794", "https"),
            new Elemento(metallTrans, solid, "Fe", "26", "Hierro", "55,845", "https"),
            new Elemento(lantanids, solid, "Ho", "67", "Holmio", "164,9303", "https"),
            new Elemento(metallsBlocP, solid, "In", "49", "Indio", "114,82", "https"),
            new Elemento(halogens, solid, "I", "53", "Iodo", "126,904", "https"),
            new Elemento(metallTrans, solid, "Ir", "77", "Iridio", "192,2", "https"),
            new Elemento(lantanids, solid, "Yb", "70", "Iterbio", "173,04", "https"),
            new Elemento(metallTrans, solid, "Y", "39", "Itrio", "88,906", "https"),
            new Elemento(gasosNobl, gasos, "Kr", "36", "krypton", "83,80", "https"),
            new Elemento(actinidis, solid, "La", "57", "Latano", "", "https"),
            new Elemento(actinidis, sintetics, "Lr", "103", "Lawrencio", "262", "https"),
            new Elemento(metallAlc, solid, "Li", "3", "Litio", "6,941", "https"),
            new Elemento(metallsBlocP, sintetics, "Lv", "116", "Livermorium", "", "https"),
            new Elemento(lantanids, solid, "Lu", "71", "Lutecio", "174,97", "https"),
            new Elemento(halogens, solid, "Mg", "12", "Magnesio", "25,305", "https"),
            new Elemento(metallTrans, solid, "Mn", "25", "Magnaseo", "54,938", "https"),
            new Elemento(metallTrans, sintetics, "Mn", "109", "Meitnerio", "266", "https"),
            new Elemento(actinidis, sintetics, "Md", "101", "Mendelevio", "258", "https"),
            new Elemento(metallTrans, liquid, "Hg", "80", "Mercurio", "200,59", "https"),
            new Elemento(metallTrans, solid, "Mo", "42", "Molibdeno", "95,94", "https"),
            new Elemento(metallsBlocP, sintetics, "Mc", "115", "Moscovium", "", "https"),
            new Elemento(lantanids, solid, "Nd", "60", "Neodimio", "144,24", "https"),
            new Elemento(gasosNobl, gasos, "Ne", "10", "Neon", "20,179", "https"),
            new Elemento(actinidis, sintetics, "Np", "93", "Neptunio", "30,9738", "https"),
            new Elemento(metallsBlocP, sintetics, "Nh", "113", "Nihonium", "", "https"),
            new Elemento(metallTrans, solid, "Nb", "41", "Niobio", "92,906", "https"),
            new Elemento(metallTrans, solid, "Ni", "28", "Niquel", "58,71", "https"),
            new Elemento(noMetalls, gasos, "N", "7", "Nitrogen", "14,0067", "https"),
            new Elemento(actinidis, sintetics, "No", "102", "Nobelio", "259", "https"),
            //Quartos 25 Malé + 16 Restantes Malé
            new Elemento(gasosNobl, gasos, "Og", "118", "Oganesón", "286", "https"),
            new Elemento(metallTrans, solid, "Au", "79", "Oro", "196,967", "https"),
            new Elemento(noMetalls, gasos, "O", "8", "Oxígeno", "15,99994", "https"),
            new Elemento(metallTrans, solid, "Pd", "46", "Paladio", "106,4", "https"),
            new Elemento(metallTrans, solid, "Ag", "47", "Plata", "107,87", "https"),
            new Elemento(metallTrans, solid, "Pt", "78", "Platino", "195,09", "https"),
            new Elemento(metallsBlocP, solid, "Pb", "82", "Plomo", "207,19", "https"),
            new Elemento(actinidis, solid, "Pu", "94", "Plutonio", "242", "https"),
            new Elemento(metaloides, solid, "Po", "84", "Polonio", "210", "https"),
            new Elemento(metallAlc, solid, "K", "19", "Potasio", "39,098", "https"),
            new Elemento(lantanids, solid, "Pr", "59", "Praseodimio", "140,907", "https"),
            new Elemento(lantanids, solid, "Pm", "61", "Promecio", "147", "https"),
            new Elemento(actinidis, solid, "Pa", "91", "Protactinio", "231", "https"),
            new Elemento(alcalinoterris, solid, "Ra", "88", "Radio", "226", "https"),
            new Elemento(gasosNobl, gasos, "Rn", "86", "Radón", "222", "https"),
            new Elemento(metallTrans, solid, "Re", "75", "Renio", "186,2", "https"),
            new Elemento(metallTrans, solid, "Rh", "45", "Rodio", "102,905", "https"),
            new Elemento(metallTrans, sintetics, "Rg", "111", "Roentgenium", "271,8", "https"),
            new Elemento(metallAlc, solid, "Rb", "37", "Rubidio", "85,47", "https"),
            new Elemento(metallTrans, solid, "Ru", "44", "Rutenio", "101,07", "https"),
            new Elemento(metallTrans, sintetics, "Rf", "104", "Rutherfordio", "261", "https"),
            new Elemento(lantanids, solid, "Sm", "62", "Samario", "263", "https"),
            new Elemento(metallTrans, sintetics, "Sg", "106", "Seaborgio", "1,00794", "https"),
            new Elemento(noMetalls, solid, "Se", "34", "Selenio", "78,96", "https"),
            new Elemento(metaloides, solid, "Si", "14", "Silicio", "28,086", "https"),
            new Elemento(metallAlc, solid, "Na", "11", "Sodio", "22,9898", "https"),
            new Elemento(metallsBlocP, solid, "Tl", "81", "Talio", "204,37", "https"),
            new Elemento(metallTrans, solid, "Ta", "73", "Tantalio", "180,948", "https"),
            new Elemento(metallTrans, sintetics, "Tc", "43", "Tecnecio", "97", "https"),
            new Elemento(metaloides, solid, "Te", "52", "Teluro", "127,60", "https"),
            new Elemento(halogens, sintetics, "Ts", "117", "Tennessine", "294", "https"),
            new Elemento(lantanids, solid, "Tb", "65", "Terbio", "158,924", "https"),
            new Elemento(metallTrans, solid, "Ti", "22", "Titanio", "47,90", "https"),
            new Elemento(actinidis, solid, "Th", "90", "Torio", "232,083", "https"),
            new Elemento(lantanids, solid, "Tm", "69", "Tulio", "168,934", "https"),
            new Elemento(actinidis, solid, "U", "92", "Uranio", "238,03", "https"),
            new Elemento(metallTrans, solid, "V", "23", "Vanadio", "50,942", "https"),
            new Elemento(metallTrans, solid, "W", "74", "Wolframio", "183,85", "https"),
            new Elemento(gasosNobl, gasos, "Xe", "54", "Xenón", "131,30", "https"),
            new Elemento(metallTrans, solid, "Zn", "30", "Zinc", "65,37", "https"),
            new Elemento(metallTrans, solid, "Zr", "40", "Zirconio", "91,22", "https")
    };
    private final Elemento[] ArrElementoAux = new Elemento[118];

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    // Capturar pulsacions en el menú de la barra superior.

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.opcioElementLiquid:
                ArrayAux("liquid");
                AdaptadorElements2 adaptadorElements2 = new AdaptadorElements2(this, ArrElementoAux);
                ListView lstOpciones = findViewById(R.id.LstOpciones);
                lstOpciones.setAdapter(adaptadorElements2);
                Toast.makeText(this,"MENU EJEMPLO 1", Toast.LENGTH_LONG).show();
                return true;
            case R.id.opcioElementGasos:
                Toast.makeText(this,"MENU EJEMPLO 2", Toast.LENGTH_LONG).show();
                return true;
            case R.id.opcioElementSolid:
                Toast.makeText(this,"MENU EJEMPLO 3", Toast.LENGTH_LONG).show();
                return true;
            case R.id.opcioElementSintetic:
                Toast.makeText(this,"MENU EJEMPLO 4", Toast.LENGTH_LONG).show();
                return true;
            case R.id.joc:
                Toast.makeText(this,"MENU EJEMPLO 5", Toast.LENGTH_LONG).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Accedim a la action bar
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        actionBar.setTitle("Tipus d'elements"); // set the top title
        // Mostrem el botó enrera que cal capturar en l'envent onOptionsItemSelected
        actionBar.setDisplayHomeAsUpEnabled(true);


        AdaptadorElements adaptadorElements = new AdaptadorElements(this, ArrElemento);
        ListView lstOpciones = findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptadorElements);

    }

    public void ArrayAux(String nombreEstado) {
        for(int x = 0; x < ArrElemento.length; x++) {
            if(ArrElemento[x].getEstado().equalsIgnoreCase(nombreEstado)) {
                ArrElementoAux[x] = ArrElemento[x];
            }
        }
    }

    class AdaptadorElements extends ArrayAdapter<Elemento> {

        public AdaptadorElements(Context context, Elemento[] arrElemento) {
            super(context, R.layout.estructura, arrElemento);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint({"ViewHolder", "InflateParams"}) View item = inflater.inflate(R.layout.estructura, null);

            TextView lblNom = item.findViewById(R.id.edtNom);
            lblNom.setText(ArrElemento[position].getNombre());

            TextView lblSimbol = item.findViewById(R.id.edtSimbol);
            lblSimbol.setText(ArrElemento[position].getSimbolo());

            TextView lblNum = item.findViewById(R.id.edtNum);
            lblNum.setText(ArrElemento[position].getNumeroAtomico());

            TextView lblPes = item.findViewById(R.id.edtPes);
            lblPes.setText(ArrElemento[position].getPeso());

            //Negro solid
            //Azul liquid
            //Verde gasos
            //Rojo sintetics

            if (ArrElemento[position].getEstado().equals("solid")) {
                lblNum.setTextColor(Color.parseColor("#000000"));
            } else if(ArrElemento[position].getEstado().equals("liquid")) {
                lblNum.setTextColor(Color.parseColor("#00398a"));
            } else if(ArrElemento[position].getEstado().equals("gasos")) {
                lblNum.setTextColor(Color.parseColor("#058f00"));
            } else if(ArrElemento[position].getEstado().equals("sintetics")) {
                lblNum.setTextColor(Color.parseColor("#750000"));
            }


            if (ArrElemento[position].getSerieQuimica().equals("Metall_Transicio")) {
                item.setBackgroundColor(Color.parseColor("#AC8181"));
            }
            else if(ArrElemento[position].getSerieQuimica().equals("Metall_Alcalins")) {
                item.setBackgroundColor(Color.parseColor("#FF6666"));
            }
            else if(ArrElemento[position].getSerieQuimica().equals("Alcalinoterris")) {
                item.setBackgroundColor(Color.parseColor("#FFDEAD"));
            }
            else if (ArrElemento[position].getSerieQuimica().equals("Lantanids")) {
                item.setBackgroundColor(Color.parseColor("#FFC1FF"));
            }
            else if (ArrElemento[position].getSerieQuimica().equals("Actinidis")) {
                item.setBackgroundColor(Color.parseColor("#FFC1FF"));
            }
            else if (ArrElemento[position].getSerieQuimica().equals("Metalls_bloc_p")) {
                item.setBackgroundColor(Color.parseColor("#CCCCCC"));
            }
            else if (ArrElemento[position].getSerieQuimica().equals("Metaloides")) {
                item.setBackgroundColor(Color.parseColor("#CCCC99"));
            }
            else if (ArrElemento[position].getSerieQuimica().equals("No_metalls")) {
                item.setBackgroundColor(Color.parseColor("#66FF66"));
            }
            else if (ArrElemento[position].getSerieQuimica().equals("Halogens")) {
                item.setBackgroundColor(Color.parseColor("#FFFF99"));
            }
            else if (ArrElemento[position].getSerieQuimica().equals("Gasos_nobles")) {
                item.setBackgroundColor(Color.parseColor("#C1FFFF"));
            }
            return item;
        }
    }

    class AdaptadorElements2 extends ArrayAdapter<Elemento> {

        public AdaptadorElements2(Context context, Elemento[] arrElemento) {
            super(context, R.layout.estructura, arrElemento);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint({"ViewHolder", "InflateParams"}) View item = inflater.inflate(R.layout.estructura, null);
            if (ArrElementoAux[position].getNombre() == null) {
                System.out.println("No funciona");
            } else {
                TextView lblNom = item.findViewById(R.id.edtNom);
                lblNom.setText(ArrElementoAux[position].getNombre());

                TextView lblSimbol = item.findViewById(R.id.edtSimbol);
                lblSimbol.setText(ArrElementoAux[position].getSimbolo());

                TextView lblNum = item.findViewById(R.id.edtNum);
                lblNum.setText(ArrElementoAux[position].getNumeroAtomico());

                TextView lblPes = item.findViewById(R.id.edtPes);
                lblPes.setText(ArrElementoAux[position].getPeso());

                //Negro solid
                //Azul liquid
                //Verde gasos
                //Rojo sintetics

                if (ArrElementoAux[position].getEstado().equals("solid")) {
                    lblNum.setTextColor(Color.parseColor("#000000"));
                } else if (ArrElementoAux[position].getEstado().equals("liquid")) {
                    lblNum.setTextColor(Color.parseColor("#00398a"));
                } else if (ArrElementoAux[position].getEstado().equals("gasos")) {
                    lblNum.setTextColor(Color.parseColor("#058f00"));
                } else if (ArrElementoAux[position].getEstado().equals("sintetics")) {
                    lblNum.setTextColor(Color.parseColor("#750000"));
                }


                if (ArrElementoAux[position].getSerieQuimica().equals("Metall_Transicio")) {
                    item.setBackgroundColor(Color.parseColor("#AC8181"));
                } else if (ArrElementoAux[position].getSerieQuimica().equals("Metall_Alcalins")) {
                    item.setBackgroundColor(Color.parseColor("#FF6666"));
                } else if (ArrElementoAux[position].getSerieQuimica().equals("Alcalinoterris")) {
                    item.setBackgroundColor(Color.parseColor("#FFDEAD"));
                } else if (ArrElementoAux[position].getSerieQuimica().equals("Lantanids")) {
                    item.setBackgroundColor(Color.parseColor("#FFC1FF"));
                } else if (ArrElementoAux[position].getSerieQuimica().equals("Actinidis")) {
                    item.setBackgroundColor(Color.parseColor("#FFC1FF"));
                } else if (ArrElementoAux[position].getSerieQuimica().equals("Metalls_bloc_p")) {
                    item.setBackgroundColor(Color.parseColor("#CCCCCC"));
                } else if (ArrElementoAux[position].getSerieQuimica().equals("Metaloides")) {
                    item.setBackgroundColor(Color.parseColor("#CCCC99"));
                } else if (ArrElementoAux[position].getSerieQuimica().equals("No_metalls")) {
                    item.setBackgroundColor(Color.parseColor("#66FF66"));
                } else if (ArrElementoAux[position].getSerieQuimica().equals("Halogens")) {
                    item.setBackgroundColor(Color.parseColor("#FFFF99"));
                } else if (ArrElementoAux[position].getSerieQuimica().equals("Gasos_nobles")) {
                    item.setBackgroundColor(Color.parseColor("#C1FFFF"));
                }

            }
            return item;
        }
    }
}

