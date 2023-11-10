package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTeste {
    Aluno aluno;

    @Test
    public void testeMudancaPlanoPremiumAprovado(){
        aluno = new Aluno();
        aluno.setQuantidadeCursos(12);
        aluno.setCursosCompletos(12);

        assertEquals(true, aluno.mudaPlano());
    }

    @Test
    public void testeMudancaPlanoReprovado(){
        aluno = new Aluno();
        aluno.setQuantidadeCursos(12);
        aluno.setCursosCompletos(3);

        assertEquals(false, aluno.mudaPlano());

    }

    @Test
    public void testMudancaPlano_QtdCursos(){
        aluno = new Aluno();
        aluno.setQuantidadeCursos(8);
        assertEquals(false, aluno.mudaPlano());
    }

    @Test
    public void testRecebeMoedas_Voucher(){
        aluno = new Aluno();
        aluno.setQuantidadeCursos(12);
        aluno.setCursosCompletos(12);
        assertEquals(true, aluno.recebeRecompensas());
    }
}
