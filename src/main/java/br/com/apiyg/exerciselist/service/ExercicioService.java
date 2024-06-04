package br.com.apiyg.exerciselist.service;

import br.com.apiyg.exerciselist.entities.Exercicio;
import br.com.apiyg.exerciselist.repositories.ExercicioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercicioService {

    private ExercicioRepository repository;

    public ExercicioService (ExercicioRepository repository){
        this.repository = repository;
    }

    public List<Exercicio> listarExercicio(){
        List<Exercicio> exercicios = repository.findAll();
        return exercicios;
    }

    public Exercicio criarExercicio(Exercicio exercicio){
        Exercicio exercicioNovo = repository.save(exercicio);
        return exercicioNovo;
    }

}
