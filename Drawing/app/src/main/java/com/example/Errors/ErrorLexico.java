package com.example.Errors;

import java.util.ArrayList;

public class ErrorLexico {
    String mistake;
    int line;
    int column;

    public ErrorLexico(String mistakes, int line, int column){
        this.mistake = mistakes;
        this.line = line;
        this.column = column;
    }

    public String getError(){
        return mistake;
    }
    public String getLine(){
        return String.valueOf(line);
    }
    public String getColumn(){
        return String.valueOf(column);
    }
}
