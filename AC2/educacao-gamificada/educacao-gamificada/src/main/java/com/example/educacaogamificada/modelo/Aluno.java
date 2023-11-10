package com.example.educacaogamificada.modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "userPsw")
    private String userPsw;

    @Column(name = "tipoPlano")
    private String tipoPlano;

    @OneToOne(cascade = CascadeType.ALL)
    private Cursos cursos;

    // Construtor padrão vazio
    public Aluno() {}

    public Aluno(String username, String userPsw, String tipoPlano) {
        this.username = username;
        this.userPsw = userPsw;
        this.tipoPlano = tipoPlano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return ID == aluno.ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public int getId(){
        return ID;
    }


    // Getters e setters
    public int getAlunoID() {
        return ID;
    }

    public void setAlunoID(int userId) {
        this.ID = userId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public void setUserPsw(String userPsw) {
        this.userPsw = userPsw;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public void setTipoPlano(String tipoPlano) {
        this.tipoPlano = tipoPlano;
    }

}
