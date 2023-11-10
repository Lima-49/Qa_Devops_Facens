package com.example.educacaogamificada.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.educacaogamificada.modelo.Cursos;

public class CursosDto {

    private int alunoID;
    private int qtdCursos;
    private String cursoAndamento;
    private float mediaFinal;

    public CursosDto(Cursos cursos) {
        super();
        this.alunoID = cursos.getCursoID();
        this.qtdCursos = cursos.getQtdCursos();
        this.cursoAndamento = cursos.getCursoAndamento();
        this.mediaFinal = cursos.getMediaFinal();
    }

    public int getAlunoID() {
        return alunoID;
    }

    public int getQtdCursos() {
        return qtdCursos;
    }

    public String getCursoAndamento() {
        return cursoAndamento;
    }

    public float getMediaFinal() {
        return mediaFinal;
    }

    public static List<CursosDto> converter(List<Cursos> cursos) {
        return cursos.stream().map(CursosDto::new).collect(Collectors.toList());
    }

}
