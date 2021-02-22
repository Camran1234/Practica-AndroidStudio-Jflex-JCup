package com.example.Errors;

public class Ocurrencia {
    String type;
    String occurrence;
    int line;
    int column;

    public Ocurrencia(String type, String ocurrencia, int line, int column){
        this.type = type;
        this.occurrence = ocurrencia;
        this.line = line;
        this.column=column;
    }

    public String getType(){
        return  type;
    }
    public String getOccurrence(){
        return occurrence;
    }

    public String getColumn() {
        return String.valueOf(column);
    }

    public String getLine() {
        return String.valueOf(line);
    }
}
