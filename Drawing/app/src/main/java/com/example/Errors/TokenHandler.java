package com.example.Errors;

import java.util.ArrayList;

public class TokenHandler {

    ArrayList<Token> tokens = new ArrayList<>();


    public void AddToken(String token, String lexema, int line, int column){
        tokens.add(new Token(token, lexema, line, column));
    }

    /**
     * Generamos una nueva lista para imprimir con datos que solicita tabla de parecidos
     * @param ocurrencia
     * @return
     */
    public ArrayList<Ocurrencia> generateListOnMultipleTokenBase(ArrayList<String> ocurrencia){
        ArrayList<Ocurrencia> listaOcurrencia = new ArrayList<>();
        String ocurrence;
        String parecido;
        for(int index=0; index<tokens.size(); index++){
            //Detecta si uno de los tokens coincide con los solicitados
            ocurrence = null;
            ocurrence = tokens.get(index).isEqual(ocurrencia);
            //Creamos la ocurrencia
            if(ocurrence!=null){
                if(index==0){
                    parecido = tokens.get(index).lexema + " "+tokens.get(index+1).lexema+" "+tokens.get(index+2).lexema;
                }else if(index==(tokens.size()-1)){
                    parecido = tokens.get(index-2).lexema + " "+tokens.get(index-1).lexema+" "+tokens.get(index).lexema;
                }else{
                    parecido = tokens.get(index-1).lexema + " "+tokens.get(index).lexema+" "+tokens.get(index+1).lexema;
                }
                listaOcurrencia.add(new Ocurrencia(tokens.get(index).lexema, parecido, tokens.get(index).line, tokens.get(index).column));
            }
        }
        return listaOcurrencia;
    }
}
