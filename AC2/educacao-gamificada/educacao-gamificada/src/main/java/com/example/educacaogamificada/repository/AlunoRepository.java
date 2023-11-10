package com.example.educacaogamificada.repository;

import com.example.educacaogamificada.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByUsername(String username);
    Optional<Aluno> findByID(int ID);
}
