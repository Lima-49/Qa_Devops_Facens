package com.example.educacaogamificada.controller;

import com.example.educacaogamificada.controller.dto.AlunoDto;
import com.example.educacaogamificada.controller.dto.CursosDto;
import com.example.educacaogamificada.controller.form.CursosForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.example.educacaogamificada.modelo.Aluno;
import com.example.educacaogamificada.repository.AlunoRepository;
import com.example.educacaogamificada.modelo.Cursos;
import com.example.educacaogamificada.repository.CursosRepository;

@RestController
@CrossOrigin
@RequestMapping("/cursos")
public class CursosController {

    @Autowired
    private CursosRepository cursosRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<CursosDto>> listarCursos() {
        List<Cursos> cursos = cursosRepository.findAll();
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(CursosDto.converter(cursos));
    }

    @PostMapping("/atualizar-curso")
    public ResponseEntity<?> atualizarCurso(@RequestParam int cursoID, @RequestParam String cursoAndamento) {
        Optional<Aluno> alunoOptional = alunoRepository.findByID(cursoID);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            List<Cursos> cursos = cursosRepository.findByID(aluno.getId());

            if (cursos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
            } else {
                // Se já houver um curso, atualize o curso existente.
                Cursos cursoExistente = cursos.get(0);
                cursoExistente.setCursoAndamento(cursoAndamento);
                cursosRepository.save(cursoExistente);
            }

            return ResponseEntity.ok("Curso em andamento atualizado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
    }

    @PostMapping("/finaliza-curso")
    public ResponseEntity<?> finalizarCurso(@RequestParam int cursoID, @RequestParam float mediaFinal){
        Optional<Aluno> alunoOptional = alunoRepository.findByID(cursoID);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            List<Cursos> cursos = cursosRepository.findByID(aluno.getId());

            if (cursos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
            } else {
                Cursos cursoExistente = cursos.get(0);

                int qtdCursos = cursoExistente.getQtdCursos();

                if (mediaFinal >= 7){
                    cursoExistente.setQtdCursos(qtdCursos+1);
                }
                cursoExistente.setCursoAndamento("");
                cursoExistente.setMediaFinal(0.0f);

                cursosRepository.save(cursoExistente);
            }

            return ResponseEntity.ok("Curso finalizado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }

    }

}


