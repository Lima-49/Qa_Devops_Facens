package com.example.educacaogamificada.controller;

import com.example.educacaogamificada.modelo.Cursos;
import com.example.educacaogamificada.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import com.example.educacaogamificada.controller.dto.AlunoDto;
import com.example.educacaogamificada.controller.form.AlunoForm;
import com.example.educacaogamificada.repository.AlunoRepository;
import com.example.educacaogamificada.modelo.Aluno;

@RestController
@CrossOrigin
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Autowired
    private CursosRepository cursosRepository;


    @GetMapping
    public ResponseEntity<List<AlunoDto>> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        if (alunos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AlunoDto.converter(alunos));
    }

    @GetMapping("/login")
    public ResponseEntity<?> fazerLogin(@RequestParam String userName, @RequestParam String userPsw) {
        List<Aluno> alunos = alunoRepository.findByUsername(userName);
        if (!alunos.isEmpty()) {
            for (Aluno aluno : alunos) {
                if (aluno.getUserPsw().equals(userPsw)) {
                    return ResponseEntity.ok(new AlunoDto(aluno));
                }
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
    }

    @PostMapping
    public ResponseEntity<?> criarAluno(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder) {

        // Valida se o tipo de plano informado esta correto
        String tipoPlano = form.getTipoPlano();

        if (!tipoPlano.equals("basico") && !tipoPlano.equals("premium")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tipo de plano inválido.");
        }

        // Verificar se o aluno já existe na base de dados
        List<Aluno> alunoExistente = alunoRepository.findByUsername(form.getUserName());

        if (!alunoExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Aluno com o nome fornecido já existe na base de dados.");
        }

        // Se o aluno não existe, crie-o na base de dados
        Aluno aluno = form.converter(alunoRepository);
        alunoRepository.save(aluno);

        // Criação automática dos cursos com base no tipo de plano
        int qtdCursos = tipoPlano.equals("basico") ? 5 : 10;
        Cursos cursos = new Cursos(qtdCursos, "", 0.0f);
        cursosRepository.save(cursos);

        URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDto(aluno));
    }

}
