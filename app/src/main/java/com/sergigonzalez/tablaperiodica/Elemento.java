package com.sergigonzalez.tablaperiodica;

import java.util.ArrayList;

public class Elemento {

    private String nombre = null;
    private String simbolo = null;
    private String estado = null;
    private String numeroAtomico = null;
    private String Peso = null;
    private String url = null;

    private String serieQuimica = null;
    private String Estado = null;

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

    public Elemento(String serieQuimica, String estado, String Simbolo, String numero, String nombre, String peso,String url)
    {
        serieQuimica = serieQuimica;
        estado = estado;
        Simbolo = Simbolo;
        numero = numero;
        nombre = nombre;
        Peso = peso;
        url = url;
    }
/*
//Primeros 25 TheHypnoo
                new Elemento(actinidis,solid,"Ac","89","Actinio","10.070","https"),
                new Element(metallsBlocP,solid,"Al","13","Aluminio","26,9815","https"),
                new Element(actinidis,solid,"Am","95","Americio","243","https"),
                new Element(Metaloides,solid,"Sb","51","Antimonio","121,76","https"),
                new Element(Gasos_nobles,gasos,"Ar","18","Argón","39,948","https"),
                new Element(metaloides,solid,"As","33","Arsénico","74,922","https"),
                new Element(halogens,solid,"At","85","Astato","210","https"),
                new Element(noMetalls,solid,"S","16","Azufre","32,064","https"),
                new Element(alcalinoterris,solid,"Ba","56","Bario","137,34","https"),
                new Element(alcalinoterris,solid,"Be","4","Berilio","9,0122","https"),
                new Element(actinidis,solid,"Bk","97","Berkelio","247","https"),
                new Element(Metalls_bloc_p,solid,"Bi","83","Bismuto","208,980","https"),
                new Element(metallTrans,solid,"Bh","107","Bohrio","262","https"),
                new Element(metaloides,solid,"B","5","Boro","10,811","https"),
                new Element(noMetallsm,liquid,"Br","35","Bromo","79.909","https"),
                new Element(metallTrans,solid,"Cd","48","Cadmio","112,40","https"),
                new Element(alcalinoterris,solid,"Ca","20","Calcio","40,08","https"),
                new Element(actinidis,solid,"Cf","98","Californio","251","https"),
                new Element(noMetalls,solid,"C","6","Carbono","12,01115","https"),
                new Element(lantanids,solid,"Ce","58","Cerio","140,12","https"),
                new Element(alcalinoterris,solid,"Cs","55","Cesio","132,905","https"),
                new Element(halogens,gasos,"Cl","17","Cloro","35,453","https"),
                new Element(metallTrans,solid,"Co","27","Cobalto","58,93","https"),
                new Element(metallTrans,solid,"Cu","29","Cobre","63,54","https"),
                new Element(metallTrans,solid,"Cn","112","Copernicio","285","https"),
                //Segundos 25 David
                new Element(metallTrans, solid, "Cr", "24", "Cromo", "51,9962", "https"),
                new Element(actinidis, sintetics, "Cm", "96", "Curio", "247", "https"),
                new Element(metallTrans, sintetics, "Ds", "110", "Darmstadio", "271", "https"),
                new Element(lantanids, solid, "Dy", "66", "Disprosio", "162,500", "https"),
                new Element(metallTrans, sintetics, "Db", "105", "Dubnio", "264", "https"),
                new Element(actinidis, sintetics, "Es", "99", "Einstenio", "252", "https"),
                new Element(lantanids, solid, "Er", "68", "Erbio", "167,259", "https"),
                new Element(metallTrans, solid, "Sc", "21", "Escandio", "44,95591", "https"),
                new Element(metallsBlocP, solid, "Sn", "50", "Estaño", "118,710", "https"),
                new Element(alcalinoterris, solid, "Sr", "38", "Estroncio", "87,62", "https"),
                new Element(lantanids, solid, "Eu", "63", "Europio", "151,964", "https"),
                new Element(actinidis, sintetics, "Fm", "100", "Fermio", "257", "https"),
                new Element(metallsBlocP, sintetics, "FI", "114", "Flerovium", "289", "https"),
                new Element(actinidis, sintetics, "F", "9", "Fluor", "18,998403", "https"),
                new Element(halogens, gasos, "P", "15", "Fosforo", "39,97696", "https"),
                new Element(metallAlc, solid, "Fr", "87", "Francio", "223", "https"),
                new Element(lantanids, solid, "Gd", "64", "Gadolinio", "157,25", "https"),
                new Element(metallsBlocP, solid, "Ga", "31", "Galio", "69,723", "https"),
                new Element(metaloides, solid, "Ge", "32", "Germanio", "77,64", "https"),
                new Element(metallTrans, solid, "Hf", "72", "Hafnio", "69,723", "https"),
                new Element(metallTrans, sintetics, "Hs", "108", "Hassio", "277", "https"),
                new Element(gasosNobl, gasos, "He", "2", "Helio", "4,002602", "https"),
                new Element(noMetalls, gasos, "H", "1", "Hidrogeno", "1,00794", "https"),
                new Element(metallTrans, solid, "Fe", "26", "Hierro", "55,845", "https"),
                new Element(lantanids, solid, "Ho", "67", "Holmio", "164,9303", "https")
                    new elements(metallsBlocP, solid, "In", "49", "Indio", "114,82", "https"),
                    new elements(halogens, solid, "I", "53", "Iodo", "126,904", "https"),
                    new elements(MetallTrans, solid, "Ir", "77", "Iridio", "192,2", "https"),
                    new elements(lantanids, solid, "Yb", "70", "Iterbio", "173,04", "https"),
                    new elements(MetallTrans, solid, "Y", "39", "Itrio", "88,906", "https"),
                    new elements(gasNoble, liquid, "Kr", "36", "krypton", "83,80", "https"),
                    new elements(actinidis, solid, "La", "57", "Latano", "", "https"),
                    new elements(actinidis, Sintetics, "Lr", "103", "Lawrencio", "262", "https"),
                    new elements(metallAlc, solid, "Li", "3", "Litio", "6,941", "https"),
                    new elements(metallsBlocP, Sintetics, "Lv", "116", "Livermorium", "", "https"),
                    new elements(lantanids, solid, "Lu", "71", "Lutecio", "174,97", "https"),
                    new elements(halogens, solid, "Mg", "12", "Magnesio", "25,305", "https"),
                    new elements(MetallTrans, solid, "Mn", "25", "Magnaseo", "54,938", "https"),
                    new elements(MetallTrans, Sintetics, "Mn", "109", "Meitnerio", "266", "https"),
                    new elements(actinidis, Sintetics, "Md", "101", "Mendelevio", "258", "https"),
                    new elements(MetallTrans, liquid, "Hg", "80", "Mercurio", "200,59", "https"),
                    new elements(MetallTrans, solid, "Mo", "42", "Molibdeno", "95,94", "https"),
                    new elements(metallsBlocP, Sintetics, "Mc", "115", "Moscovium", "", "https"),
                    new elements(lantanids, solid, "Nd", "60", "Neodimio", "144,24", "https"),
                    new elements(gasNoble, Gasos, "Ne", "10", "Neon", "20,179", "https"),
                    new elements(actinidis, Sintetics, "Np", "93", "Neptunio", "30,9738", "https"),
                    new elements(metallsBlocP, Sintetics, "Nh", "113", "Nihonium", "", "https"),
                    new elements(MetallTrans, solid, "Nb", "41", "Niobio", "92,906", "https"),
                    new elements(MetallTrans, solid, "Ni", "28", "Niquel", "58,71", "https"),
                    new elements(noMetalls, Gasos, "N", "7", "Nitrogen", "14,0067", "https"),
                    new elements(actinidis, Sintetics, "No", "102", "Nobelio", "259", "https"),
                    //Quartos 25 Malé + 16 Restantes Malé
                    new Elementos(GasosNoble, Gasos, "Og", "118", "Oganesón", "286", "https"),
                    new Elementos(Metall_Trans, Solid, "Au", "79", "Oro", "196,967", "https"),
                    new Elementos(NoMetalls, Gasos, "O", "8", "Oxígeno", "15,99994", "https"),
                    new Elementos(Metall_Trans, Solid, "Pd", "46", "Paladio", "106,4", "https"),
                    new Elementos(Metall_Trans, Solid, "Ag", "47", "Plata", "107,87", "https"),
                    new Elementos(Metall_Trans, Solid, "Pt", "78", "Platino", "195,09", "https"),
                    new Elementos(MetallsBlocP, Solid, "Pb", "82", "Plomo", "207,19", "https"),
                    new Elementos(Actinidis, Solid, "Pu", "94", "Plutonio", "242", "https"),
                    new Elementos(Metaloides, Solid, "Po", "84", "Polonio", "210", "https"),
                    new Elementos(MetallAlc, Solid, "K", "19", "Potasio", "39,098", "https"),
                    new Elementos(Lantanids, Solid, "Pr", "59", "Praseodimio", "140,907", "https"),
                    new Elementos(Lantanids, Solid, "Pm", "61", "Promecio", "147", "https"),
                    new Elementos(Actinidis, Solid, "Pa", "91", "Protactinio", "231", "https"),
                    new Elementos(Alcalinoterris, Solid, "Ra", "88", "Radio", "226", "https"),
                    new Elementos(GasosNoble, Gasos, "Rn", "86", "Radón", "222", "https"),
                    new Elementos(Metall_Trans, Solid, "Re", "75", "Renio", "186,2", "https"),
                    new Elementos(Metall_Trans, Solid, "Rh", "45", "Rodio", "102,905", "https"),
                    new Elementos(Metall_Trans, Sintetics, "Rg", "111", "Roentgenium", "271,8", "https"),
                    new Elementos(MetallAlc, Solid, "Rb", "37", "Rubidio", "85,47", "https"),
                    new Elementos(Metall_Trans, Solid, "Ru", "44", "Rutenio", "101,07", "https"),
                    new Elementos(Metall_Trans, Sintetics, "Rf", "104", "Rutherfordio", "261", "https"),
                    new Elementos(Lantanids, Solid, "Sm", "62", "Samario", "263", "https"),
                    new Elementos(Metall_Trans, Sintetics, "Sg", "106", "Seaborgio", "1,00794", "https"),
                    new Elementos(NoMetalls, Solid, "Se", "34", "Selenio", "78,96", "https"),
                    new Elementos(Metaloides, Solid, "Si", "14", "Silicio", "28,086", "https"),
                    new Elementos(MetallAlc, Solid, "Na", "11", "Sodio", "22,9898", "https"),
                    new Elementos(MetallsBlocP, Solid, "Tl", "81", "Talio", "204,37", "https"),
                    new Elementos(Metall_Trans, Solid, "Ta", "73", "Tantalio", "180,948", "https"),
                    new Elementos(Metall_Trans, Sintetics, "Tc", "43", "Tecnecio", "97", "https"),
                    new Elementos(Metaloides, Solid, "Te", "52", "Teluro", "127,60", "https"),
                    new Elementos(Halogens, Sintetics, "Ts", "117", "Tennessine", "294", "https"),
                    new Elementos(Lantanids, Solid, "Tb", "65", "Terbio", "158,924", "https"),
                    new Elementos(Metall_Trans, Solid, "Ti", "22", "Titanio", "47,90", "https"),
                    new Elementos(Actinidis, Solid, "Th", "90", "Torio", "232,083", "https"),
                    new Elementos(Lantanids, Solid, "Tm", "69", "Tulio", "168,934", "https"),
                    new Elementos(Actinidis, Solid, "U", "92", "Uranio", "238,03", "https"),
                    new Elementos(Metall_Trans, Solid, "V", "23", "Vanadio", "50,942", "https"),
                    new Elementos(Metall_Trans, Solid, "W", "74", "Wolframio", "183,85", "https"),
                    new Elementos(GasosNoble, Gasos, "Xe", "54", "Xenón", "131,30", "https"),
                    new Elementos(Metall_Trans, Solid, "Zn", "30", "Zinc", "65,37", "https"),
                    new Elementos(Metall_Trans, Solid, "Zr", "40", "Zirconio", "91,22", "https")
 */


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setNumeroAtomico(String numeroAtomico) {
        this.numeroAtomico = numeroAtomico;
    }

    public String getNumeroAtomico() {
        return numeroAtomico;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }

}
