package com.example.educacaogamificada.testesAlunos;

import com.example.educacaogamificada.modelo.Aluno;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AlunoTest {
    @Test
    public void testEquals() {
        Aluno aluno1 = new Aluno("user1", "password1", "plano1");
        aluno1.setAlunoID(1);

        Aluno aluno2 = new Aluno("user2", "password2", "plano2");
        aluno2.setAlunoID(1); // Mesmo ID que aluno1

        assertEquals(aluno1, aluno2);
    }

    @Test
    public void testNotEquals() {
        Aluno aluno1 = new Aluno("user1", "password1", "plano1");
        aluno1.setAlunoID(1);

        Aluno aluno2 = new Aluno("user2", "password2", "plano2");
        aluno2.setAlunoID(2); // IDs diferentes

        assertNotEquals(aluno1, aluno2);
    }

    @Test
    public void testHashCode() {
        Aluno aluno1 = new Aluno("user1", "password1", "plano1");
        aluno1.setAlunoID(1);

        Aluno aluno2 = new Aluno("user2", "password2", "plano2");
        aluno2.setAlunoID(1); // Mesmo ID que aluno1

        assertEquals(aluno1.hashCode(), aluno2.hashCode());
    }

    @Test
    public void testGettersAndSetters() {
        Aluno aluno = new Aluno();
        aluno.setUserName("user");
        aluno.setUserPsw("password");
        aluno.setTipoPlano("plano");

        assertEquals("user", aluno.getUserName());
        assertEquals("password", aluno.getUserPsw());
        assertEquals("plano", aluno.getTipoPlano());
    }
}
