package com.example.educacaogamificada.controller.form;

import com.example.educacaogamificada.repository.AlunoRepository;
import com.example.educacaogamificada.modelo.Aluno;

import java.util.List;

public class AlunoForm {

    private String userName;
    private String userPsw;
    private String tipoPlano;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Aluno converter(AlunoRepository alunoRepository) {
        List<Aluno> nomeAlunos = alunoRepository.findByUsername(userName);
        if (!nomeAlunos.isEmpty()) {
            // Se a lista não estiver vazia, assume-se que o aluno existe e atualiza as informações
            Aluno alunoExistente = nomeAlunos.get(0); // Pega o primeiro aluno da lista (assumindo que não há duplicatas)
            alunoExistente.setUserPsw(userPsw);
            alunoExistente.setTipoPlano(tipoPlano);
            return alunoExistente;
        } else {
            // Se a lista estiver vazia, cria um novo aluno com as informações fornecidas
            Aluno novoAluno = new Aluno(userName, userPsw, tipoPlano);
            return alunoRepository.save(novoAluno); // Salva o novo aluno no banco de dados e retorna
        }
    }

}
