package com.example.educacaogamificada.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cursos")
public class Cursos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "qtdCursos")
    private int qtdCursos;

    @Column(name = "cursoAndamento")
    private String cursoAndamento;

    @Column(name = "mediaFinal")
    private float mediaFinal;

    @ManyToOne
    private Aluno aluno;

    public Cursos() {}

    public Cursos(int qtdCursos, String cursoAndamento, float mediaFinal) {
        this.qtdCursos = qtdCursos;
        this.cursoAndamento = cursoAndamento;
        this.mediaFinal = mediaFinal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public int getId(){
        return ID;
    }

    public int getCursoID() {
        return ID;
    }

    public void setCursoID(int cursoID) {
        this.ID = cursoID;
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
