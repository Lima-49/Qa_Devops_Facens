package com.example.educacaogamificada.repository;

import com.example.educacaogamificada.modelo.Aluno;
import com.example.educacaogamificada.modelo.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursosRepository extends JpaRepository<Cursos, Integer> {
    List<Cursos> findByID(int ID);
}
