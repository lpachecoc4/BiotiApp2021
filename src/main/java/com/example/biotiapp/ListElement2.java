package com.example.biotiapp;

import android.content.Context;

import java.io.Serializable;
import java.util.ArrayList;

public class ListElement2 implements Serializable {

    public String nameM, dateM, timeM, result ,resultado;
    public ArrayList<String> names;


    public ListElement2( ArrayList<String> tnames, String tnameM, String tdateM, String ttimeM, String result, String resultado) {
        this.nameM = tnameM;
        this.names = tnames;
        this.dateM = tdateM;
        this.timeM = ttimeM;
        this.result = result;
        this.resultado = resultado;
    }

    public ListElement2(String nameM, String dateM,String timeM){
        this.nameM = nameM;
        this.dateM = dateM;
        this.timeM = timeM;
        this.names = new ArrayList<>();
        this.result = "0";
        setResultado();
    }

    public ListElement2(ArrayList<String> names, String[] measureData, Context context){
        this.names = names;
        this.nameM = measureData[0];
        this.dateM = measureData[1];
        this.timeM = measureData[2];
        setResult(context);
        setResultado();
    }

    public ListElement2(ArrayList<String> names, String nameM, String dateM,String timeM, Context context){
        this.nameM = nameM;
        this.names = names;
        this.dateM = dateM;
        this.timeM = timeM;
        setResult(context);
        setResultado();
    }

    /*public ListElement2 (String nameM, Context context){
        DBHelper DB = new DBHelper(context);
        String tscale = DB.getScale(name);
        int scale = Integer.parseInt(tscale);
        String tpos = DB.getPos(name);
        this.name = name;
        this.scale = scale;
        setImagePos(tpos);
    }*/

    public void setResult(Context context){
        int count = 0;
        ArrayList<ListElement> animals = new ArrayList<>();
        for(int i = 0; i < this.names.size(); i++){
            animals.add(new ListElement(this.names.get(i),context));
            count = count + animals.get(i).getScale();
        }
        this.result = String.valueOf(count);
    }

    public void setResultado(){
        int x = Integer.parseInt(this.result);
        if(x <= 15){
            this.resultado = "Aguas extremadamente contaminadas.";
        }else if(x > 15 && x <= 35){
            this.resultado = "Aguas muy contaminadas.";
        }else if(x > 35 && x <= 60){
            this.resultado = "Aguas contaminadas.";
        }else if(x > 60 && x < 100){
            this.resultado = "Aguas con signos de estrés.";
        }else {
            this.resultado = "Aguas muy limpias.";
        }
    }


    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setNames(ArrayList<String> names) { this.names = names; }

    public void setNameM(String nameM) { this.nameM = nameM; }

    public void setDateM(String dateM) { this.dateM = dateM; }

    public void setTimeM(String nameM) { this.timeM = nameM; }

    public void setResult(String result) { this.result = result;}

    public String getNameM() {
        return nameM;
    }

    public String getDateM() {
        return dateM;
    }

    public String getTimeM() {
        return timeM;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public String getResult() {
        return result;
    }
}
