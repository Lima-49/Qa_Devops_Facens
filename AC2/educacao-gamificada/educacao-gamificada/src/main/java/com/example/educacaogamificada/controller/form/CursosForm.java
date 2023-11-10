package com.example.educacaogamificada.controller.form;

import com.example.educacaogamificada.modelo.Cursos;
import com.example.educacaogamificada.repository.CursosRepository;

import java.util.List;

public class CursosForm {

    private int cursoID;
    private int qtdCursos;
    private String cursoAndamento;
    private float mediaFinal;

    public int getCursoID() {
        return cursoID;
    }

    public void setUserId(int userId) {
        this.cursoID = userId;
    }

    public int getQtdCursos() {
        return qtdCursos;
    }

    public void setQtdCursos(int qtdCursos) {
        this.qtdCursos = qtdCursos;
    }

    public String getCursoAndamento() {
        return cursoAndamento;
    }

    public void setCursoAndamento(String cursoAndamento) {
        this.cursoAndamento = cursoAndamento;
    }

    public float getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
}
