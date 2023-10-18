package com.guilherme.aprimore.enums;

public enum Grupo {
    ALUNO("aluno"),
    PROFESSOR("professor");

    private String grupo;

    Grupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGrupo() {
        return this.grupo;
    }
}
