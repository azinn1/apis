package br.com.apiyg.exerciselist.repositories;

import br.com.apiyg.exerciselist.entities.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {

}
