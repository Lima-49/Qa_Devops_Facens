package com.example.educacaogamificada.testesAlunos;

import com.example.educacaogamificada.modelo.Aluno;
import com.example.educacaogamificada.repository.AlunoRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest
public class AlunoRepositoryTest {
    @Autowired
    private AlunoRepository alunoRepository;

    @Test
    public void testFindByUsername() {

        Aluno aluno1 = new Aluno("user1", "password1", "plano1");
        alunoRepository.save(aluno1);

        Aluno aluno2 = new Aluno("user2", "password2", "plano2");
        alunoRepository.save(aluno2);

        List<Aluno> foundAlunos = alunoRepository.findByUsername("user1");
        assertEquals(1, foundAlunos.size());
        assertEquals("user1", foundAlunos.get(0).getUserName());
    }

    @Test
    public void testFindById() {
        Aluno aluno1 = new Aluno("user1", "password1", "plano1");
        alunoRepository.save(aluno1);

        Optional<Aluno> foundAluno = alunoRepository.findByID(aluno1.getAlunoID());
        assertTrue(foundAluno.isPresent());
        assertEquals("user1", foundAluno.get().getUserName());
    }

    @Test
    public void testFindByIdNotFound() {
        Optional<Aluno> foundAluno = alunoRepository.findByID(100); // ID inexistente
        assertTrue(foundAluno.isEmpty());
    }

    @Test
    public void testSave() {
        Aluno aluno = new Aluno("user", "password", "plano");
        alunoRepository.save(aluno);

        assertNotNull(aluno.getAlunoID()); // Certifica-se de que o ID foi gerado
    }

    @Test
    public void testDelete() {
        Aluno aluno = new Aluno("user", "password", "plano");
        alunoRepository.save(aluno);

        alunoRepository.delete(aluno);

        Optional<Aluno> foundAluno = alunoRepository.findByID(aluno.getAlunoID());
        assertTrue(foundAluno.isEmpty());
    }

}
