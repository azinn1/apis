package br.com.apiyg.exerciselist.controllers;


import br.com.apiyg.exerciselist.entities.Exercicio;
import br.com.apiyg.exerciselist.repositories.ExercicioRepository;
import br.com.apiyg.exerciselist.service.ExercicioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/exercicios")
public class ExerciciosController {

    @Autowired
    private ExercicioRepository repository;

    private ExercicioService exercicioService;


    @GetMapping
//  Localizando Listas inseridas no banco e retornado em forma de saída na tela.
    public ResponseEntity<List<Exercicio>>findAll(){
        List<Exercicio> lista = (List<Exercicio>) repository.findAll();
        return ResponseEntity.status(200).body(lista);
    };

    @GetMapping(value = "/{id}")
    public ResponseEntity <Exercicio> findById(@PathVariable Long id){
        Exercicio result = repository.findById(id).get();
        return ResponseEntity.status(200).body(result);
    }

    @PostMapping
    public ResponseEntity <Exercicio> insert(@RequestBody Exercicio exercicio){
        Exercicio result = repository.save(exercicio);
        return ResponseEntity.status(201).body(exercicio);
    };

    @PutMapping
    public ResponseEntity <Exercicio> exercicioUpdate(@RequestBody Exercicio exercicio){
        Exercicio exercicioNovo = repository.save(exercicio);
        return ResponseEntity.status(201).body(exercicioNovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirExercicio(@PathVariable Long id){
        Exercicio exercicio = repository.findById(id).get();
        repository.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
