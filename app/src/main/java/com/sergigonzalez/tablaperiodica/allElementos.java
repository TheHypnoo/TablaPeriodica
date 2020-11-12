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

public class allElementos extends AppCompatActivity {

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
            //Todos los solidos
            new Elemento(metallTrans, solid, "Au", "79", "Oro", "196,967", "https://es.wikipedia.org/wiki/Oro"),
            new Elemento(actinidis, solid, "Ac", "89", "Actinio", "10.070", "https://es.wikipedia.org/wiki/Actinio"),
            new Elemento(metallsBlocP, solid, "Al", "13", "Aluminio", "26,9815", "https://es.wikipedia.org/wiki/Aluminio"),
            new Elemento(actinidis, solid, "Am", "95", "Americio", "243", "https://es.wikipedia.org/wiki/Americio"),
            new Elemento(metaloides, solid, "Sb", "51", "Antimonio", "121,76", "https://es.wikipedia.org/wiki/Antimonio"),
            new Elemento(metallTrans, solid, "Pd", "46", "Paladio", "106,4", "https://es.wikipedia.org/wiki/Paladio"),
            new Elemento(metallTrans, solid, "Ag", "47", "Plata", "107,87", "https://es.wikipedia.org/wiki/Plata"),
            new Elemento(metallTrans, solid, "Pt", "78", "Platino", "195,09", "https://es.wikipedia.org/wiki/Platino"),
            new Elemento(metallsBlocP, solid, "Pb", "82", "Plomo", "207,19", "https://es.wikipedia.org/wiki/Plomo"),
            new Elemento(actinidis, solid, "Pu", "94", "Plutonio", "242", "https://es.wikipedia.org/wiki/Plutonio"),
            new Elemento(metaloides, solid, "Po", "84", "Polonio", "210", "https://es.wikipedia.org/wiki/Polonio"),
            new Elemento(metallAlc, solid, "K", "19", "Potasio", "39,098", "https://es.wikipedia.org/wiki/Potasio"),
            new Elemento(lantanids, solid, "Pr", "59", "Praseodimio", "140,907", "https://es.wikipedia.org/wiki/Praseodimio"),
            new Elemento(lantanids, solid, "Pm", "61", "Promecio", "147", "https://es.wikipedia.org/wiki/Promecio"),
            new Elemento(actinidis, solid, "Pa", "91", "Protactinio", "231", "https://es.wikipedia.org/wiki/Protactinio"),
            new Elemento(alcalinoterris, solid, "Ra", "88", "Radio", "226", "https://es.wikipedia.org/wiki/Radio"),
            new Elemento(metallTrans, solid, "Zn", "30", "Zinc", "65,37", "https://es.wikipedia.org/wiki/Zinc"),
            new Elemento(metallTrans, solid, "Zr", "40", "Zirconio", "91,22", "https://es.wikipedia.org/wiki/Zirconio"),
            new Elemento(lantanids, solid, "Tb", "65", "Terbio", "158,924", "https://es.wikipedia.org/wiki/Terbio"),
            new Elemento(metallTrans, solid, "Ti", "22", "Titanio", "47,90", "https://es.wikipedia.org/wiki/Titanio"),
            new Elemento(actinidis, solid, "Th", "90", "Torio", "232,083", "https://es.wikipedia.org/wiki/Torio"),
            new Elemento(lantanids, solid, "Tm", "69", "Tulio", "168,934", "https://es.wikipedia.org/wiki/Tulio"),
            new Elemento(actinidis, solid, "U", "92", "Uranio", "238,03", "https://es.wikipedia.org/wiki/Uranio"),
            new Elemento(metallTrans, solid, "V", "23", "Vanadio", "50,942", "https://es.wikipedia.org/wiki/Vanadio"),
            new Elemento(metallTrans, solid, "W", "74", "Wolframio", "183,85", "https://es.wikipedia.org/wiki/Wolframio"),
            new Elemento(metaloides, solid, "As", "33", "Arsénico", "74,922", "https://es.wikipedia.org/wiki/Arsénico"),
            new Elemento(halogens, solid, "At", "85", "Astato", "210", "https://es.wikipedia.org/wiki/Astato"),
            new Elemento(noMetalls, solid, "S", "16", "Azufre", "32,064", "https://es.wikipedia.org/wiki/Azufre"),
            new Elemento(alcalinoterris, solid, "Ba", "56", "Bario", "137,34", "https://es.wikipedia.org/wiki/Bario"),
            new Elemento(alcalinoterris, solid, "Be", "4", "Berilio", "9,0122", "https://es.wikipedia.org/wiki/Berilio"),
            new Elemento(actinidis, solid, "Bk", "97", "Berkelio", "247", "https://es.wikipedia.org/wiki/Berkelio"),
            new Elemento(metallsBlocP, solid, "Bi", "83", "Bismuto", "208,980", "https://es.wikipedia.org/wiki/Bismuto"),
            new Elemento(metallTrans, solid, "Bh", "107", "Bohrio", "262", "https://es.wikipedia.org/wiki/Bohrio"),
            new Elemento(metaloides, solid, "B", "5", "Boro", "10,811", "https://es.wikipedia.org/wiki/Boro"),
            new Elemento(metallTrans, solid, "Cd", "48", "Cadmio", "112,40", "https://es.wikipedia.org/wiki/Cadmio"),
            new Elemento(alcalinoterris, solid, "Ca", "20", "Calcio", "40,08", "https://es.wikipedia.org/wiki/Calcio"),
            new Elemento(actinidis, solid, "Cf", "98", "Californio", "251", "https://es.wikipedia.org/wiki/Californio"),
            new Elemento(noMetalls, solid, "C", "6", "Carbono", "12,01115", "https://es.wikipedia.org/wiki/Carbono"),
            new Elemento(lantanids, solid, "Ce", "58", "Cerio", "140,12", "https://es.wikipedia.org/wiki/Cerio"),
            new Elemento(alcalinoterris, solid, "Cs", "55", "Cesio", "132,905", "https://es.wikipedia.org/wiki/Cesio"),
            new Elemento(metallTrans, solid, "Co", "27", "Cobalto", "58,93", "https://es.wikipedia.org/wiki/Cobalto"),
            new Elemento(metallTrans, solid, "Cu", "29", "Cobre", "63,54", "https://es.wikipedia.org/wiki/Cobre"),
            new Elemento(metallTrans, solid, "Cn", "112", "Copernicio", "285", "https://es.wikipedia.org/wiki/Copernicio"),
            new Elemento(metallTrans, solid, "Fe", "26", "Hierro", "55,845", "https://es.wikipedia.org/wiki/Hierro"),
            new Elemento(lantanids, solid, "Ho", "67", "Holmio", "164,9303", "https://es.wikipedia.org/wiki/Holmio"),
            new Elemento(metallsBlocP, solid, "In", "49", "Indio", "114,82", "https://es.wikipedia.org/wiki/Indio"),
            new Elemento(halogens, solid, "I", "53", "Iodo", "126,904", "https://es.wikipedia.org/wiki/Iodo"),
            new Elemento(metallTrans, solid, "Ir", "77", "Iridio", "192,2", "https://es.wikipedia.org/wiki/Iridio"),
            new Elemento(lantanids, solid, "Yb", "70", "Iterbio", "173,04", "https://es.wikipedia.org/wiki/Iterbio"),
            new Elemento(metallTrans, solid, "Y", "39", "Itrio", "88,906", "https://es.wikipedia.org/wiki/Itrio"),
            new Elemento(metallTrans, solid, "Re", "75", "Renio", "186,2", "https://es.wikipedia.org/wiki/Renio"),
            new Elemento(metallTrans, solid, "Rh", "45", "Rodio", "102,905", "https://es.wikipedia.org/wiki/Rodio"),
            new Elemento(noMetalls, solid, "Se", "34", "Selenio", "78,96", "https://es.wikipedia.org/wiki/Selenio"),
            new Elemento(metaloides, solid, "Si", "14", "Silicio", "28,086", "https://es.wikipedia.org/wiki/Silicio"),
            new Elemento(metallAlc, solid, "Na", "11", "Sodio", "22,9898", "https://es.wikipedia.org/wiki/Sodio"),
            new Elemento(metallsBlocP, solid, "Tl", "81", "Talio", "204,37", "https://es.wikipedia.org/wiki/Talio"),
            new Elemento(metallTrans, solid, "Ta", "73", "Tantalio", "180,948", "https://es.wikipedia.org/wiki/Tantalio"),
            new Elemento(metallAlc, solid, "Rb", "37", "Rubidio", "85,47", "https://es.wikipedia.org/wiki/Rubidio"),
            new Elemento(metallTrans, solid, "Ru", "44", "Rutenio", "101,07", "https://es.wikipedia.org/wiki/Rutenio"),
            new Elemento(lantanids, solid, "Sm", "62", "Samario", "263", "https://es.wikipedia.org/wiki/Samario"),
            new Elemento(metaloides, solid, "Te", "52", "Teluro", "127,60", "https://es.wikipedia.org/wiki/Teluro"),
            new Elemento(metallTrans, solid, "Nb", "41", "Niobio", "92,906", "https://es.wikipedia.org/wiki/Niobio"),
            new Elemento(metallTrans, solid, "Ni", "28", "Niquel", "58,71", "https://es.wikipedia.org/wiki/Niquel"),
            new Elemento(lantanids, solid, "Lu", "71", "Lutecio", "174,97", "https://es.wikipedia.org/wiki/Lutecio"),
            new Elemento(halogens, solid, "Mg", "12", "Magnesio", "25,305", "https://es.wikipedia.org/wiki/Magnesio"),
            new Elemento(metallTrans, solid, "Mn", "25", "Magnaseo", "54,938", "https://es.wikipedia.org/wiki/Magnaseo"),
            new Elemento(lantanids, solid, "Nd", "60", "Neodimio", "144,24", "https://es.wikipedia.org/wiki/Neodimio"),
            new Elemento(lantanids, solid, "Er", "68", "Erbio", "167,259", "https://es.wikipedia.org/wiki/Erbio"),
            new Elemento(metallTrans, solid, "Sc", "21", "Escandio", "44,95591", "https://es.wikipedia.org/wiki/Escandio"),
            new Elemento(metallsBlocP, solid, "Sn", "50", "Estaño", "118,710", "https://es.wikipedia.org/wiki/Estaño"),
            new Elemento(alcalinoterris, solid, "Sr", "38", "Estroncio", "87,62", "https://es.wikipedia.org/wiki/Estroncio"),
            new Elemento(lantanids, solid, "Eu", "63", "Europio", "151,964", "https://es.wikipedia.org/wiki/Europio"),
            new Elemento(metallTrans, solid, "Mo", "42", "Molibdeno", "95,94", "https://es.wikipedia.org/wiki/Molibdeno"),
            new Elemento(actinidis, solid, "La", "57", "Lantano", "138.91", "https://es.wikipedia.org/wiki/Lantano"),
            new Elemento(metallAlc, solid, "Li", "3", "Litio", "6,941", "https://es.wikipedia.org/wiki/Litio"),
            new Elemento(metallAlc, solid, "Fr", "87", "Francio", "223", "https://es.wikipedia.org/wiki/Francio"),
            new Elemento(lantanids, solid, "Gd", "64", "Gadolinio", "157,25", "https://es.wikipedia.org/wiki/Gadolinio"),
            new Elemento(metallsBlocP, solid, "Ga", "31", "Galio", "69,723", "https://es.wikipedia.org/wiki/Galio"),
            new Elemento(metaloides, solid, "Ge", "32", "Germanio", "77,64", "https://es.wikipedia.org/wiki/Germanio"),
            new Elemento(metallTrans, solid, "Hf", "72", "Hafnio", "69,723", "https://es.wikipedia.org/wiki/Hafnio"),
            new Elemento(lantanids, solid, "Dy", "66", "Disprosio", "162,500", "https://es.wikipedia.org/wiki/Disprosio"),
            new Elemento(metallTrans, solid, "Cr", "24", "Cromo", "51,9962", "https://es.wikipedia.org/wiki/Cromo"),
            //Todos los liquidos
            new Elemento(metallTrans, liquid, "Hg", "80", "Mercurio", "200,59", "https://es.wikipedia.org/wiki/Mercurio"),
            new Elemento(noMetalls, liquid, "Br", "35", "Bromo", "79.909", "https://es.wikipedia.org/wiki/Bromo"),
            //Todos los gasos
            new Elemento(gasosNobl, gasos, "Ar", "18", "Argón", "39,948", "https://es.wikipedia.org/wiki/Argón"),
            new Elemento(halogens, gasos, "Cl", "17", "Cloro", "35,453", "https://es.wikipedia.org/wiki/Cloro"),
            new Elemento(halogens, gasos, "P", "15", "Fosforo", "39,97696", "https://es.wikipedia.org/wiki/Fosforo"),
            new Elemento(gasosNobl, gasos, "Og", "118", "Oganesón", "286", "https://es.wikipedia.org/wiki/Oganesón"),
            new Elemento(gasosNobl, gasos, "Ne", "10", "Neon", "20,179", "https://es.wikipedia.org/wiki/Neon"),
            new Elemento(noMetalls, gasos, "O", "8", "Oxígeno", "15,99994", "https://es.wikipedia.org/wiki/Oxígeno"),
            new Elemento(gasosNobl, gasos, "Rn", "86", "Radón", "222", "https://es.wikipedia.org/wiki/Radón"),
            new Elemento(gasosNobl, gasos, "He", "2", "Helio", "4,002602", "https://es.wikipedia.org/wiki/Helio"),
            new Elemento(noMetalls, gasos, "H", "1", "Hidrogeno", "1,00794", "https://es.wikipedia.org/wiki/Hidrogeno"),
            new Elemento(gasosNobl, gasos, "Kr", "36", "krypton", "83,80", "https://es.wikipedia.org/wiki/krypton"),
            new Elemento(noMetalls, gasos, "N", "7", "Nitrogen", "14,0067", "https://es.wikipedia.org/wiki/Nitrogen"),
            new Elemento(gasosNobl, gasos, "Xe", "54", "Xenón", "131,30", "https://es.wikipedia.org/wiki/Xenón"),
            //Todos los sinteticos
            new Elemento(actinidis, sintetics, "Cm", "96", "Curio", "247", "https://es.wikipedia.org/wiki/Curio"),
            new Elemento(metallTrans, sintetics, "Ds", "110", "Darmstadio", "271", "https://es.wikipedia.org/wiki/Darmstadio"),
            new Elemento(metallTrans, sintetics, "Db", "105", "Dubnio", "264", "https://es.wikipedia.org/wiki/Dubnio"),
            new Elemento(actinidis, sintetics, "Es", "99", "Einstenio", "252", "https://es.wikipedia.org/wiki/Einstenio"),
            new Elemento(actinidis, sintetics, "Fm", "100", "Fermio", "257", "https://es.wikipedia.org/wiki/Fermio"),
            new Elemento(metallsBlocP, sintetics, "FI", "114", "Flerovium", "289", "https://es.wikipedia.org/wiki/Flerovium"),
            new Elemento(actinidis, sintetics, "F", "9", "Fluor", "18,998403", "https://es.wikipedia.org/wiki/Fluor"),
            new Elemento(metallTrans, sintetics, "Hs", "108", "Hassio", "277", "https://es.wikipedia.org/wiki/Hassio"),
            new Elemento(actinidis, sintetics, "Lr", "103", "Lawrencio", "262", "https://es.wikipedia.org/wiki/Lawrencio"),
            new Elemento(metallsBlocP, sintetics, "Lv", "116", "Livermorio", "291", "https://es.wikipedia.org/wiki/Livermorio"),
            new Elemento(metallTrans, sintetics, "Mn", "109", "Meitnerio", "266", "https://es.wikipedia.org/wiki/Meitnerio"),
            new Elemento(actinidis, sintetics, "Md", "101", "Mendelevio", "258", "https://es.wikipedia.org/wiki/Mendelevio"),
            new Elemento(metallsBlocP, sintetics, "Mc", "115", "Moscovium", "288", "https://es.wikipedia.org/wiki/Moscovium"),
            new Elemento(actinidis, sintetics, "Np", "93", "Neptunio", "30,9738", "https://es.wikipedia.org/wiki/Neptunio"),
            new Elemento(metallsBlocP, sintetics, "Nh", "113", "Nihonium", "286", "https://es.wikipedia.org/wiki/Nihonium"),
            new Elemento(actinidis, sintetics, "No", "102", "Nobelio", "259", "https://es.wikipedia.org/wiki/Nobelio"),
            new Elemento(metallTrans, sintetics, "Rg", "111", "Roentgenium", "271,8", "https://es.wikipedia.org/wiki/Roentgenium"),
            new Elemento(metallTrans, sintetics, "Rf", "104", "Rutherfordio", "261", "https://es.wikipedia.org/wiki/Rutherfordio"),
            new Elemento(metallTrans, sintetics, "Sg", "106", "Seaborgio", "1,00794", "https://es.wikipedia.org/wiki/Seaborgio"),
            new Elemento(metallTrans, sintetics, "Tc", "43", "Tecnecio", "97", "https://es.wikipedia.org/wiki/Tecnecio"),
            new Elemento(halogens, sintetics, "Ts", "117", "Tennessine", "294", "https://es.wikipedia.org/wiki/Tennessine")
    };

    private final Elemento[] ArrLiquids = new Elemento[]{
            new Elemento(metallTrans, liquid, "Hg", "80", "Mercurio", "200,59", "https://es.wikipedia.org/wiki/Mercurio"),
            new Elemento(noMetalls, liquid, "Br", "35", "Bromo", "79.909", "https://es.wikipedia.org/wiki/Bromo")
    };

    private final Elemento[] ArrSolids = new Elemento[]{
            new Elemento(metallTrans, solid, "Au", "79", "Oro", "196,967", "https://es.wikipedia.org/wiki/Oro"),
            new Elemento(actinidis, solid, "Ac", "89", "Actinio", "10.070", "https://es.wikipedia.org/wiki/Actinio"),
            new Elemento(metallsBlocP, solid, "Al", "13", "Aluminio", "26,9815", "https://es.wikipedia.org/wiki/Aluminio"),
            new Elemento(actinidis, solid, "Am", "95", "Americio", "243", "https://es.wikipedia.org/wiki/Americio"),
            new Elemento(metaloides, solid, "Sb", "51", "Antimonio", "121,76", "https://es.wikipedia.org/wiki/Antimonio"),
            new Elemento(metallTrans, solid, "Pd", "46", "Paladio", "106,4", "https://es.wikipedia.org/wiki/Paladio"),
            new Elemento(metallTrans, solid, "Ag", "47", "Plata", "107,87", "https://es.wikipedia.org/wiki/Plata"),
            new Elemento(metallTrans, solid, "Pt", "78", "Platino", "195,09", "https://es.wikipedia.org/wiki/Platino"),
            new Elemento(metallsBlocP, solid, "Pb", "82", "Plomo", "207,19", "https://es.wikipedia.org/wiki/Plomo"),
            new Elemento(actinidis, solid, "Pu", "94", "Plutonio", "242", "https://es.wikipedia.org/wiki/Plutonio"),
            new Elemento(metaloides, solid, "Po", "84", "Polonio", "210", "https://es.wikipedia.org/wiki/Polonio"),
            new Elemento(metallAlc, solid, "K", "19", "Potasio", "39,098", "https://es.wikipedia.org/wiki/Potasio"),
            new Elemento(lantanids, solid, "Pr", "59", "Praseodimio", "140,907", "https://es.wikipedia.org/wiki/Praseodimio"),
            new Elemento(lantanids, solid, "Pm", "61", "Promecio", "147", "https://es.wikipedia.org/wiki/Promecio"),
            new Elemento(actinidis, solid, "Pa", "91", "Protactinio", "231", "https://es.wikipedia.org/wiki/Protactinio"),
            new Elemento(alcalinoterris, solid, "Ra", "88", "Radio", "226", "https://es.wikipedia.org/wiki/Radio"),
            new Elemento(metallTrans, solid, "Zn", "30", "Zinc", "65,37", "https://es.wikipedia.org/wiki/Zinc"),
            new Elemento(metallTrans, solid, "Zr", "40", "Zirconio", "91,22", "https://es.wikipedia.org/wiki/Zirconio"),
            new Elemento(lantanids, solid, "Tb", "65", "Terbio", "158,924", "https://es.wikipedia.org/wiki/Terbio"),
            new Elemento(metallTrans, solid, "Ti", "22", "Titanio", "47,90", "https://es.wikipedia.org/wiki/Titanio"),
            new Elemento(actinidis, solid, "Th", "90", "Torio", "232,083", "https://es.wikipedia.org/wiki/Torio"),
            new Elemento(lantanids, solid, "Tm", "69", "Tulio", "168,934", "https://es.wikipedia.org/wiki/Tulio"),
            new Elemento(actinidis, solid, "U", "92", "Uranio", "238,03", "https://es.wikipedia.org/wiki/Uranio"),
            new Elemento(metallTrans, solid, "V", "23", "Vanadio", "50,942", "https://es.wikipedia.org/wiki/Vanadio"),
            new Elemento(metallTrans, solid, "W", "74", "Wolframio", "183,85", "https://es.wikipedia.org/wiki/Wolframio"),
            new Elemento(metaloides, solid, "As", "33", "Arsénico", "74,922", "https://es.wikipedia.org/wiki/Arsénico"),
            new Elemento(halogens, solid, "At", "85", "Astato", "210", "https://es.wikipedia.org/wiki/Astato"),
            new Elemento(noMetalls, solid, "S", "16", "Azufre", "32,064", "https://es.wikipedia.org/wiki/Azufre"),
            new Elemento(alcalinoterris, solid, "Ba", "56", "Bario", "137,34", "https://es.wikipedia.org/wiki/Bario"),
            new Elemento(alcalinoterris, solid, "Be", "4", "Berilio", "9,0122", "https://es.wikipedia.org/wiki/Berilio"),
            new Elemento(actinidis, solid, "Bk", "97", "Berkelio", "247", "https://es.wikipedia.org/wiki/Berkelio"),
            new Elemento(metallsBlocP, solid, "Bi", "83", "Bismuto", "208,980", "https://es.wikipedia.org/wiki/Bismuto"),
            new Elemento(metallTrans, solid, "Bh", "107", "Bohrio", "262", "https://es.wikipedia.org/wiki/Bohrio"),
            new Elemento(metaloides, solid, "B", "5", "Boro", "10,811", "https://es.wikipedia.org/wiki/Boro"),
            new Elemento(metallTrans, solid, "Cd", "48", "Cadmio", "112,40", "https://es.wikipedia.org/wiki/Cadmio"),
            new Elemento(alcalinoterris, solid, "Ca", "20", "Calcio", "40,08", "https://es.wikipedia.org/wiki/Calcio"),
            new Elemento(actinidis, solid, "Cf", "98", "Californio", "251", "https://es.wikipedia.org/wiki/Californio"),
            new Elemento(noMetalls, solid, "C", "6", "Carbono", "12,01115", "https://es.wikipedia.org/wiki/Carbono"),
            new Elemento(lantanids, solid, "Ce", "58", "Cerio", "140,12", "https://es.wikipedia.org/wiki/Cerio"),
            new Elemento(alcalinoterris, solid, "Cs", "55", "Cesio", "132,905", "https://es.wikipedia.org/wiki/Cesio"),
            new Elemento(metallTrans, solid, "Co", "27", "Cobalto", "58,93", "https://es.wikipedia.org/wiki/Cobalto"),
            new Elemento(metallTrans, solid, "Cu", "29", "Cobre", "63,54", "https://es.wikipedia.org/wiki/Cobre"),
            new Elemento(metallTrans, solid, "Cn", "112", "Copernicio", "285", "https://es.wikipedia.org/wiki/Copernicio"),
            new Elemento(metallTrans, solid, "Fe", "26", "Hierro", "55,845", "https://es.wikipedia.org/wiki/Hierro"),
            new Elemento(lantanids, solid, "Ho", "67", "Holmio", "164,9303", "https://es.wikipedia.org/wiki/Holmio"),
            new Elemento(metallsBlocP, solid, "In", "49", "Indio", "114,82", "https://es.wikipedia.org/wiki/Indio"),
            new Elemento(halogens, solid, "I", "53", "Iodo", "126,904", "https://es.wikipedia.org/wiki/Iodo"),
            new Elemento(metallTrans, solid, "Ir", "77", "Iridio", "192,2", "https://es.wikipedia.org/wiki/Iridio"),
            new Elemento(lantanids, solid, "Yb", "70", "Iterbio", "173,04", "https://es.wikipedia.org/wiki/Iterbio"),
            new Elemento(metallTrans, solid, "Y", "39", "Itrio", "88,906", "https://es.wikipedia.org/wiki/Itrio"),
            new Elemento(metallTrans, solid, "Re", "75", "Renio", "186,2", "https://es.wikipedia.org/wiki/Renio"),
            new Elemento(metallTrans, solid, "Rh", "45", "Rodio", "102,905", "https://es.wikipedia.org/wiki/Rodio"),
            new Elemento(noMetalls, solid, "Se", "34", "Selenio", "78,96", "https://es.wikipedia.org/wiki/Selenio"),
            new Elemento(metaloides, solid, "Si", "14", "Silicio", "28,086", "https://es.wikipedia.org/wiki/Silicio"),
            new Elemento(metallAlc, solid, "Na", "11", "Sodio", "22,9898", "https://es.wikipedia.org/wiki/Sodio"),
            new Elemento(metallsBlocP, solid, "Tl", "81", "Talio", "204,37", "https://es.wikipedia.org/wiki/Talio"),
            new Elemento(metallTrans, solid, "Ta", "73", "Tantalio", "180,948", "https://es.wikipedia.org/wiki/Tantalio"),
            new Elemento(metallAlc, solid, "Rb", "37", "Rubidio", "85,47", "https://es.wikipedia.org/wiki/Rubidio"),
            new Elemento(metallTrans, solid, "Ru", "44", "Rutenio", "101,07", "https://es.wikipedia.org/wiki/Rutenio"),
            new Elemento(lantanids, solid, "Sm", "62", "Samario", "263", "https://es.wikipedia.org/wiki/Samario"),
            new Elemento(metaloides, solid, "Te", "52", "Teluro", "127,60", "https://es.wikipedia.org/wiki/Teluro"),
            new Elemento(metallTrans, solid, "Nb", "41", "Niobio", "92,906", "https://es.wikipedia.org/wiki/Niobio"),
            new Elemento(metallTrans, solid, "Ni", "28", "Niquel", "58,71", "https://es.wikipedia.org/wiki/Niquel"),
            new Elemento(lantanids, solid, "Lu", "71", "Lutecio", "174,97", "https://es.wikipedia.org/wiki/Lutecio"),
            new Elemento(halogens, solid, "Mg", "12", "Magnesio", "25,305", "https://es.wikipedia.org/wiki/Magnesio"),
            new Elemento(metallTrans, solid, "Mn", "25", "Magnaseo", "54,938", "https://es.wikipedia.org/wiki/Magnaseo"),
            new Elemento(lantanids, solid, "Nd", "60", "Neodimio", "144,24", "https://es.wikipedia.org/wiki/Neodimio"),
            new Elemento(lantanids, solid, "Er", "68", "Erbio", "167,259", "https://es.wikipedia.org/wiki/Erbio"),
            new Elemento(metallTrans, solid, "Sc", "21", "Escandio", "44,95591", "https://es.wikipedia.org/wiki/Escandio"),
            new Elemento(metallsBlocP, solid, "Sn", "50", "Estaño", "118,710", "https://es.wikipedia.org/wiki/Estaño"),
            new Elemento(alcalinoterris, solid, "Sr", "38", "Estroncio", "87,62", "https://es.wikipedia.org/wiki/Estroncio"),
            new Elemento(lantanids, solid, "Eu", "63", "Europio", "151,964", "https://es.wikipedia.org/wiki/Europio"),
            new Elemento(metallTrans, solid, "Mo", "42", "Molibdeno", "95,94", "https://es.wikipedia.org/wiki/Molibdeno"),
            new Elemento(actinidis, solid, "La", "57", "Lantano", "138.91", "https://es.wikipedia.org/wiki/Lantano"),
            new Elemento(metallAlc, solid, "Li", "3", "Litio", "6,941", "https://es.wikipedia.org/wiki/Litio"),
            new Elemento(metallAlc, solid, "Fr", "87", "Francio", "223", "https://es.wikipedia.org/wiki/Francio"),
            new Elemento(lantanids, solid, "Gd", "64", "Gadolinio", "157,25", "https://es.wikipedia.org/wiki/Gadolinio"),
            new Elemento(metallsBlocP, solid, "Ga", "31", "Galio", "69,723", "https://es.wikipedia.org/wiki/Galio"),
            new Elemento(metaloides, solid, "Ge", "32", "Germanio", "77,64", "https://es.wikipedia.org/wiki/Germanio"),
            new Elemento(metallTrans, solid, "Hf", "72", "Hafnio", "69,723", "https://es.wikipedia.org/wiki/Hafnio"),
            new Elemento(lantanids, solid, "Dy", "66", "Disprosio", "162,500", "https://es.wikipedia.org/wiki/Disprosio"),
            new Elemento(metallTrans, solid, "Cr", "24", "Cromo", "51,9962", "https://es.wikipedia.org/wiki/Cromo")
    };

    private final Elemento[] ArrGasos = new Elemento[]{
            new Elemento(gasosNobl, gasos, "Ar", "18", "Argón", "39,948", "https://es.wikipedia.org/wiki/Argón"),
            new Elemento(halogens, gasos, "Cl", "17", "Cloro", "35,453", "https://es.wikipedia.org/wiki/Cloro"),
            new Elemento(halogens, gasos, "P", "15", "Fosforo", "39,97696", "https://es.wikipedia.org/wiki/Fosforo"),
            new Elemento(gasosNobl, gasos, "Og", "118", "Oganesón", "286", "https://es.wikipedia.org/wiki/Oganesón"),
            new Elemento(gasosNobl, gasos, "Ne", "10", "Neon", "20,179", "https://es.wikipedia.org/wiki/Neon"),
            new Elemento(noMetalls, gasos, "O", "8", "Oxígeno", "15,99994", "https://es.wikipedia.org/wiki/Oxígeno"),
            new Elemento(gasosNobl, gasos, "Rn", "86", "Radón", "222", "https://es.wikipedia.org/wiki/Radón"),
            new Elemento(gasosNobl, gasos, "He", "2", "Helio", "4,002602", "https://es.wikipedia.org/wiki/Helio"),
            new Elemento(noMetalls, gasos, "H", "1", "Hidrogeno", "1,00794", "https://es.wikipedia.org/wiki/Hidrogeno"),
            new Elemento(gasosNobl, gasos, "Kr", "36", "krypton", "83,80", "https://es.wikipedia.org/wiki/krypton"),
            new Elemento(noMetalls, gasos, "N", "7", "Nitrogen", "14,0067", "https://es.wikipedia.org/wiki/Nitrogen"),
            new Elemento(gasosNobl, gasos, "Xe", "54", "Xenón", "131,30", "https://es.wikipedia.org/wiki/Xenón")
    };

    private final Elemento[] ArrSintetics = new Elemento[]{
            new Elemento(actinidis, sintetics, "Cm", "96", "Curio", "247", "https://es.wikipedia.org/wiki/Curio"),
            new Elemento(metallTrans, sintetics, "Ds", "110", "Darmstadio", "271", "https://es.wikipedia.org/wiki/Darmstadio"),
            new Elemento(metallTrans, sintetics, "Db", "105", "Dubnio", "264", "https://es.wikipedia.org/wiki/Dubnio"),
            new Elemento(actinidis, sintetics, "Es", "99", "Einstenio", "252", "https://es.wikipedia.org/wiki/Einstenio"),
            new Elemento(actinidis, sintetics, "Fm", "100", "Fermio", "257", "https://es.wikipedia.org/wiki/Fermio"),
            new Elemento(metallsBlocP, sintetics, "FI", "114", "Flerovium", "289", "https://es.wikipedia.org/wiki/Flerovium"),
            new Elemento(actinidis, sintetics, "F", "9", "Fluor", "18,998403", "https://es.wikipedia.org/wiki/Fluor"),
            new Elemento(metallTrans, sintetics, "Hs", "108", "Hassio", "277", "https://es.wikipedia.org/wiki/Hassio"),
            new Elemento(actinidis, sintetics, "Lr", "103", "Lawrencio", "262", "https://es.wikipedia.org/wiki/Lawrencio"),
            new Elemento(metallsBlocP, sintetics, "Lv", "116", "Livermorio", "291", "https://es.wikipedia.org/wiki/Livermorio"),
            new Elemento(metallTrans, sintetics, "Mn", "109", "Meitnerio", "266", "https://es.wikipedia.org/wiki/Meitnerio"),
            new Elemento(actinidis, sintetics, "Md", "101", "Mendelevio", "258", "https://es.wikipedia.org/wiki/Mendelevio"),
            new Elemento(metallsBlocP, sintetics, "Mc", "115", "Moscovium", "288", "https://es.wikipedia.org/wiki/Moscovium"),
            new Elemento(actinidis, sintetics, "Np", "93", "Neptunio", "30,9738", "https://es.wikipedia.org/wiki/Neptunio"),
            new Elemento(metallsBlocP, sintetics, "Nh", "113", "Nihonium", "286", "https://es.wikipedia.org/wiki/Nihonium"),
            new Elemento(actinidis, sintetics, "No", "102", "Nobelio", "259", "https://es.wikipedia.org/wiki/Nobelio"),
            new Elemento(metallTrans, sintetics, "Rg", "111", "Roentgenium", "271,8", "https://es.wikipedia.org/wiki/Roentgenium"),
            new Elemento(metallTrans, sintetics, "Rf", "104", "Rutherfordio", "261", "https://es.wikipedia.org/wiki/Rutherfordio"),
            new Elemento(metallTrans, sintetics, "Sg", "106", "Seaborgio", "1,00794", "https://es.wikipedia.org/wiki/Seaborgio"),
            new Elemento(metallTrans, sintetics, "Tc", "43", "Tecnecio", "97", "https://es.wikipedia.org/wiki/Tecnecio"),
            new Elemento(halogens, sintetics, "Ts", "117", "Tennessine", "294", "https://es.wikipedia.org/wiki/Tennessine")
    };


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
            case R.id.opcioTots:
                setTitle("Todos los elementos");
                AdaptadorElements adaptadorElements = new AdaptadorElements(this, ArrElemento);
                ListView lstOpciones = findViewById(R.id.LstOpciones);
                lstOpciones.setAdapter(adaptadorElements);
                return true;
            case R.id.opcioElementLiquid:
                setTitle("Elementos Liquidos");
                AdaptadorElements3 adaptadorElements3 = new AdaptadorElements3(this, ArrLiquids);
                lstOpciones = findViewById(R.id.LstOpciones);
                lstOpciones.setAdapter(adaptadorElements3);
                return true;
            case R.id.opcioElementGasos:
                setTitle("Elementos Gaseosos");
                AdaptadorElements4 adaptadorElements4 = new AdaptadorElements4(this, ArrGasos);
                lstOpciones = findViewById(R.id.LstOpciones);
                lstOpciones.setAdapter(adaptadorElements4);
                return true;
            case R.id.opcioElementSolid:
                setTitle("Elementos Solidos");
                AdaptadorElements2 adaptadorElements2 = new AdaptadorElements2(this, ArrSolids);
                lstOpciones = findViewById(R.id.LstOpciones);
                lstOpciones.setAdapter(adaptadorElements2);
                return true;
            case R.id.opcioElementSintetic:
                setTitle("Elements Sintetics");
                AdaptadorElements5 adaptadorElements5 = new AdaptadorElements5(this, ArrSintetics);
                lstOpciones = findViewById(R.id.LstOpciones);
                lstOpciones.setAdapter(adaptadorElements5);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    final String[] InfoElemento = new String[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allelementos);
        // Accedim a la action bar
        ActionBar actionBar = getSupportActionBar(); // or getActionBar();
        //actionBar.setTitle("Todos los elementos"); // set the top title
        // Mostrem el botó enrera que cal capturar en l'envent onOptionsItemSelected
        actionBar.setDisplayHomeAsUpEnabled(true);


        AdaptadorElements adaptadorElements = new AdaptadorElements(this, ArrElemento);
        ListView lstOpciones = findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptadorElements);

        lstOpciones.setOnItemClickListener((parent, view, position, id) -> {

            InfoElemento[0] = ArrElemento[position].getNombre();
            InfoElemento[1] = ArrElemento[position].getSimbolo();
            InfoElemento[2] = ArrElemento[position].getEstado();
            InfoElemento[3] = ArrElemento[position].getNumeroAtomico();
            InfoElemento[4] = ArrElemento[position].getSerieQuimica();
            InfoElemento[5] = ArrElemento[position].getPeso();
            InfoElemento[6] = ArrElemento[position].getURL();

            Intent Elemento = new Intent(allElementos.this, clickElemento.class);
            Bundle b = new Bundle();
            b.putStringArray ("Elemento",InfoElemento);
            Elemento.putExtras(b);
            startActivity(Elemento);
        });
    }

    class AdaptadorElements extends ArrayAdapter<Elemento> {

        public AdaptadorElements(Context context, Elemento[] arrElemento) {
            super(context, R.layout.estructura, arrElemento);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint({"ViewHolder", "InflateParams"}) View item = inflater.inflate(R.layout.estructura, null);
            setTitle("Todos los elementos");
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
            if (ArrSolids[position].getNombre() == null) {
                System.out.println("No funciona");
            } else {
                TextView lblNom = item.findViewById(R.id.edtNom);
                lblNom.setText(ArrSolids[position].getNombre());

                TextView lblSimbol = item.findViewById(R.id.edtSimbol);
                lblSimbol.setText(ArrSolids[position].getSimbolo());

                TextView lblNum = item.findViewById(R.id.edtNum);
                lblNum.setText(ArrSolids[position].getNumeroAtomico());

                TextView lblPes = item.findViewById(R.id.edtPes);
                lblPes.setText(ArrSolids[position].getPeso());

                //Negro solid
                //Azul liquid
                //Verde gasos
                //Rojo sintetics

                if (ArrSolids[position].getEstado().equals("solid")) {
                    lblNum.setTextColor(Color.parseColor("#000000"));
                } else if (ArrSolids[position].getEstado().equals("liquid")) {
                    lblNum.setTextColor(Color.parseColor("#00398a"));
                } else if (ArrSolids[position].getEstado().equals("gasos")) {
                    lblNum.setTextColor(Color.parseColor("#058f00"));
                } else if (ArrSolids[position].getEstado().equals("sintetics")) {
                    lblNum.setTextColor(Color.parseColor("#750000"));
                }


                if (ArrSolids[position].getSerieQuimica().equals("Metall_Transicio")) {
                    item.setBackgroundColor(Color.parseColor("#AC8181"));
                } else if (ArrSolids[position].getSerieQuimica().equals("Metall_Alcalins")) {
                    item.setBackgroundColor(Color.parseColor("#FF6666"));
                } else if (ArrSolids[position].getSerieQuimica().equals("Alcalinoterris")) {
                    item.setBackgroundColor(Color.parseColor("#FFDEAD"));
                } else if (ArrSolids[position].getSerieQuimica().equals("Lantanids")) {
                    item.setBackgroundColor(Color.parseColor("#FFC1FF"));
                } else if (ArrSolids[position].getSerieQuimica().equals("Actinidis")) {
                    item.setBackgroundColor(Color.parseColor("#FFC1FF"));
                } else if (ArrSolids[position].getSerieQuimica().equals("Metalls_bloc_p")) {
                    item.setBackgroundColor(Color.parseColor("#CCCCCC"));
                } else if (ArrSolids[position].getSerieQuimica().equals("Metaloides")) {
                    item.setBackgroundColor(Color.parseColor("#CCCC99"));
                } else if (ArrSolids[position].getSerieQuimica().equals("No_metalls")) {
                    item.setBackgroundColor(Color.parseColor("#66FF66"));
                } else if (ArrSolids[position].getSerieQuimica().equals("Halogens")) {
                    item.setBackgroundColor(Color.parseColor("#FFFF99"));
                } else if (ArrSolids[position].getSerieQuimica().equals("Gasos_nobles")) {
                    item.setBackgroundColor(Color.parseColor("#C1FFFF"));
                }

            }
            return item;
        }
    }

    class AdaptadorElements3 extends ArrayAdapter<Elemento> {

        public AdaptadorElements3(Context context, Elemento[] arrElemento) {
            super(context, R.layout.estructura, arrElemento);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint({"ViewHolder", "InflateParams"}) View item = inflater.inflate(R.layout.estructura, null);
            if (ArrLiquids[position].getNombre() == null) {
                System.out.println("No funciona");
            } else {
                TextView lblNom = item.findViewById(R.id.edtNom);
                lblNom.setText(ArrLiquids[position].getNombre());

                TextView lblSimbol = item.findViewById(R.id.edtSimbol);
                lblSimbol.setText(ArrLiquids[position].getSimbolo());

                TextView lblNum = item.findViewById(R.id.edtNum);
                lblNum.setText(ArrLiquids[position].getNumeroAtomico());

                TextView lblPes = item.findViewById(R.id.edtPes);
                lblPes.setText(ArrLiquids[position].getPeso());

                //Negro solid
                //Azul liquid
                //Verde gasos
                //Rojo sintetics

                if (ArrLiquids[position].getEstado().equals("solid")) {
                    lblNum.setTextColor(Color.parseColor("#000000"));
                } else if (ArrLiquids[position].getEstado().equals("liquid")) {
                    lblNum.setTextColor(Color.parseColor("#00398a"));
                } else if (ArrLiquids[position].getEstado().equals("gasos")) {
                    lblNum.setTextColor(Color.parseColor("#058f00"));
                } else if (ArrLiquids[position].getEstado().equals("sintetics")) {
                    lblNum.setTextColor(Color.parseColor("#750000"));
                }


                if (ArrLiquids[position].getSerieQuimica().equals("Metall_Transicio")) {
                    item.setBackgroundColor(Color.parseColor("#AC8181"));
                } else if (ArrLiquids[position].getSerieQuimica().equals("Metall_Alcalins")) {
                    item.setBackgroundColor(Color.parseColor("#FF6666"));
                } else if (ArrLiquids[position].getSerieQuimica().equals("Alcalinoterris")) {
                    item.setBackgroundColor(Color.parseColor("#FFDEAD"));
                } else if (ArrLiquids[position].getSerieQuimica().equals("Lantanids")) {
                    item.setBackgroundColor(Color.parseColor("#FFC1FF"));
                } else if (ArrLiquids[position].getSerieQuimica().equals("Actinidis")) {
                    item.setBackgroundColor(Color.parseColor("#FFC1FF"));
                } else if (ArrLiquids[position].getSerieQuimica().equals("Metalls_bloc_p")) {
                    item.setBackgroundColor(Color.parseColor("#CCCCCC"));
                } else if (ArrLiquids[position].getSerieQuimica().equals("Metaloides")) {
                    item.setBackgroundColor(Color.parseColor("#CCCC99"));
                } else if (ArrLiquids[position].getSerieQuimica().equals("No_metalls")) {
                    item.setBackgroundColor(Color.parseColor("#66FF66"));
                } else if (ArrLiquids[position].getSerieQuimica().equals("Halogens")) {
                    item.setBackgroundColor(Color.parseColor("#FFFF99"));
                } else if (ArrLiquids[position].getSerieQuimica().equals("Gasos_nobles")) {
                    item.setBackgroundColor(Color.parseColor("#C1FFFF"));
                }

            }
            return item;
        }
    }

    class AdaptadorElements4 extends ArrayAdapter<Elemento> {

        public AdaptadorElements4(Context context, Elemento[] arrElemento) {
            super(context, R.layout.estructura, arrElemento);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint({"ViewHolder", "InflateParams"}) View item = inflater.inflate(R.layout.estructura, null);
                TextView lblNom = item.findViewById(R.id.edtNom);
                lblNom.setText(ArrGasos[position].getNombre());

                TextView lblSimbol = item.findViewById(R.id.edtSimbol);
                lblSimbol.setText(ArrGasos[position].getSimbolo());

                TextView lblNum = item.findViewById(R.id.edtNum);
                lblNum.setText(ArrGasos[position].getNumeroAtomico());

                TextView lblPes = item.findViewById(R.id.edtPes);
                lblPes.setText(ArrGasos[position].getPeso());

                //Negro solid
                //Azul liquid
                //Verde gasos
                //Rojo sintetics

                if (ArrGasos[position].getEstado().equals("solid")) {
                    lblNum.setTextColor(Color.parseColor("#000000"));
                } else if (ArrGasos[position].getEstado().equals("liquid")) {
                    lblNum.setTextColor(Color.parseColor("#00398a"));
                } else if (ArrGasos[position].getEstado().equals("gasos")) {
                    lblNum.setTextColor(Color.parseColor("#058f00"));
                } else if (ArrGasos[position].getEstado().equals("sintetics")) {
                    lblNum.setTextColor(Color.parseColor("#750000"));
                }


                if (ArrGasos[position].getSerieQuimica().equals("Metall_Transicio")) {
                    item.setBackgroundColor(Color.parseColor("#AC8181"));
                } else if (ArrGasos[position].getSerieQuimica().equals("Metall_Alcalins")) {
                    item.setBackgroundColor(Color.parseColor("#FF6666"));
                } else if (ArrGasos[position].getSerieQuimica().equals("Alcalinoterris")) {
                    item.setBackgroundColor(Color.parseColor("#FFDEAD"));
                } else if (ArrGasos[position].getSerieQuimica().equals("Lantanids")) {
                    item.setBackgroundColor(Color.parseColor("#FFC1FF"));
                } else if (ArrGasos[position].getSerieQuimica().equals("Actinidis")) {
                    item.setBackgroundColor(Color.parseColor("#FFC1FF"));
                } else if (ArrGasos[position].getSerieQuimica().equals("Metalls_bloc_p")) {
                    item.setBackgroundColor(Color.parseColor("#CCCCCC"));
                } else if (ArrGasos[position].getSerieQuimica().equals("Metaloides")) {
                    item.setBackgroundColor(Color.parseColor("#CCCC99"));
                } else if (ArrGasos[position].getSerieQuimica().equals("No_metalls")) {
                    item.setBackgroundColor(Color.parseColor("#66FF66"));
                } else if (ArrGasos[position].getSerieQuimica().equals("Halogens")) {
                    item.setBackgroundColor(Color.parseColor("#FFFF99"));
                } else if (ArrGasos[position].getSerieQuimica().equals("Gasos_nobles")) {
                    item.setBackgroundColor(Color.parseColor("#C1FFFF"));
                }
            return item;
        }
    }

    class AdaptadorElements5 extends ArrayAdapter<Elemento> {

        public AdaptadorElements5(Context context, Elemento[] arrElemento) {
            super(context, R.layout.estructura, arrElemento);
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            @SuppressLint({"ViewHolder", "InflateParams"}) View item = inflater.inflate(R.layout.estructura, null);
            TextView lblNom = item.findViewById(R.id.edtNom);
            lblNom.setText(ArrSintetics[position].getNombre());

            TextView lblSimbol = item.findViewById(R.id.edtSimbol);
            lblSimbol.setText(ArrSintetics[position].getSimbolo());

            TextView lblNum = item.findViewById(R.id.edtNum);
            lblNum.setText(ArrSintetics[position].getNumeroAtomico());

            TextView lblPes = item.findViewById(R.id.edtPes);
            lblPes.setText(ArrSintetics[position].getPeso());

            //Negro solid
            //Azul liquid
            //Verde gasos
            //Rojo sintetics

            if (ArrSintetics[position].getEstado().equals("solid")) {
                lblNum.setTextColor(Color.parseColor("#000000"));
            } else if (ArrSintetics[position].getEstado().equals("liquid")) {
                lblNum.setTextColor(Color.parseColor("#00398a"));
            } else if (ArrSintetics[position].getEstado().equals("gasos")) {
                lblNum.setTextColor(Color.parseColor("#058f00"));
            } else if (ArrSintetics[position].getEstado().equals("sintetics")) {
                lblNum.setTextColor(Color.parseColor("#750000"));
            }


            if (ArrSintetics[position].getSerieQuimica().equals("Metall_Transicio")) {
                item.setBackgroundColor(Color.parseColor("#AC8181"));
            } else if (ArrSintetics[position].getSerieQuimica().equals("Metall_Alcalins")) {
                item.setBackgroundColor(Color.parseColor("#FF6666"));
            } else if (ArrSintetics[position].getSerieQuimica().equals("Alcalinoterris")) {
                item.setBackgroundColor(Color.parseColor("#FFDEAD"));
            } else if (ArrSintetics[position].getSerieQuimica().equals("Lantanids")) {
                item.setBackgroundColor(Color.parseColor("#FFC1FF"));
            } else if (ArrSintetics[position].getSerieQuimica().equals("Actinidis")) {
                item.setBackgroundColor(Color.parseColor("#FFC1FF"));
            } else if (ArrSintetics[position].getSerieQuimica().equals("Metalls_bloc_p")) {
                item.setBackgroundColor(Color.parseColor("#CCCCCC"));
            } else if (ArrSintetics[position].getSerieQuimica().equals("Metaloides")) {
                item.setBackgroundColor(Color.parseColor("#CCCC99"));
            } else if (ArrSintetics[position].getSerieQuimica().equals("No_metalls")) {
                item.setBackgroundColor(Color.parseColor("#66FF66"));
            } else if (ArrSintetics[position].getSerieQuimica().equals("Halogens")) {
                item.setBackgroundColor(Color.parseColor("#FFFF99"));
            } else if (ArrSintetics[position].getSerieQuimica().equals("Gasos_nobles")) {
                item.setBackgroundColor(Color.parseColor("#C1FFFF"));
            }
            return item;
        }
    }
}

