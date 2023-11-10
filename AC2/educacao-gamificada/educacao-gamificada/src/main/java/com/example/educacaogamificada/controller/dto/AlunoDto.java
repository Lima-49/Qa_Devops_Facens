package com.example.educacaogamificada.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.educacaogamificada.modelo.Aluno;

public class AlunoDto {

    private int userId;
    private String userName;
    private String userPsw;
    private String tipoPlano;

    public AlunoDto(Aluno aluno) {
        super();
        this.userId = aluno.getAlunoID();
        this.userName = aluno.getUserName();
        this.userPsw = aluno.getUserPsw();
        this.tipoPlano = aluno.getTipoPlano();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPsw() {
        return userPsw;
    }

    public String getTipoPlano() {
        return tipoPlano;
    }

    public static List<AlunoDto> converter(List<Aluno> alunos) {
        return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
    }
}
