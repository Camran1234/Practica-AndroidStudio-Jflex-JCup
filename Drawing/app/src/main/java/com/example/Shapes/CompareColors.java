package com.example.Shapes;

import java.util.ArrayList;

public class CompareColors {
    int azul=0;
    int rojo =0;
    int verde=0;
    int amarillo=0;
    int naranja =0;
    int morado=0;
    int cafe=0;
    int negro=0;


    public void parseColors(ArrayList<String> colors){
        for(int index=0; index<colors.size(); index++){
            switch (colors.get(index)){
                case "azul":
                    azul++;
                    break;
                case "rojo":
                    rojo++;
                    break;
                case "verde":
                    verde++;
                    break;
                case "amarillo":
                    amarillo++;
                    break;
                case "naranja":
                    naranja++;
                    break;
                case "morado":
                    morado++;
                    break;
                case "cafe":
                    cafe++;
                    break;
                case "negro":
                    negro++;
                    break;
            }
        }

    }

    public String getColor(int index){
        switch (index){
            case 1:
                return "amarrillo";

            case 2:
                return "azul";

            case 3:
                return "rojo";

            case 4:
                return "cafe";

            case 5:
                return "morado";

            case 6:
                return "negro";

            case 7:
                return "naranja";

            case 8:
                return "verde";

        }
        return null;
    }
    public int getColorMagnitud(int index){
        switch (index){
            case 1:
                return getAmarillo();

            case 2:
                return getAzul();

            case 3:
                return getRojo();

            case 4:
                return getCafe();

            case 5:
                return getMorado();

            case 6:
                return getNegro();

            case 7:
                return getNaranja();

            case 8:
                return getVerde();

        }
        return 0;
    }

    public int getAmarillo() {
        return amarillo;
    }

    public int getAzul() {
        return azul;
    }

    public int getRojo() {
        return rojo;
    }

    public int getCafe() {
        return cafe;
    }

    public int getMorado() {
        return morado;
    }

    public int getNaranja() {
        return naranja;
    }

    public int getNegro() {
        return negro;
    }

    public int getVerde() {
        return verde;
    }
}
