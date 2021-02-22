package com.example.Errors;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Token {

    String token;
    String lexema;
    int line;
    int column;

    public Token(String token, String lexema, int line, int column){
        try{
            this.token = token;
            this.lexema = lexema;
            this.line = line;
            this.column = column;
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public String isEqual(ArrayList<String> token){
        for(int index=0; index<token.size();index++){
            if(this.token.equalsIgnoreCase(token.get(index))){
                return this.token;
            }
        }
        return null;
    }

    public String isEqual(String token, int line, int column){
        if(this.token.equalsIgnoreCase(token) && this.line==line && this.column==column){
            return this.token;
        }
        return null;
    }

}
