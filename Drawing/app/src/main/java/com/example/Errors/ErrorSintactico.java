package com.example.Errors;

import java.util.ArrayList;

public class ErrorSintactico {
    String token;
    int line;
    int column;
    String error;
    public ErrorSintactico(String token, int line, int column, String error){
        this.token  = token;
        this.line = line;
        this.column = column;
        this.error = error;
    }

    public String getError(){
        return error;
    }
    public String getToken(){
        return token;
    }
    public String getColumn(){
        return String.valueOf(column);
    }
    public String getLine(){
        return String.valueOf(line);
    }

}
