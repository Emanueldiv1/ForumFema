package br.edu.fema.forum2024.ForumFema.model.dto;

import antlr.Token;

public class TokenDto {

    private String token;
    private String tipo;

    public TokenDto(String token, String tipo){
        this.token = token;
        this.tipo = tipo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}