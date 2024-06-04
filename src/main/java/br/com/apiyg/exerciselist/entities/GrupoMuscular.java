package br.com.apiyg.exerciselist.entities;
import jakarta.persistence.*;

//Notação para informar que essa classe representa uma tabela no banco de dados
@Entity
//Notação para informar a criação de uma tabela
@Table (name = "tb_grupomuscular")

//Classe que estabelece relação com a classe Exercício
//para informar no sistema quais exercícios são do grupo superior/inferior
public class GrupoMuscular {
    @Id // Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Dizemos que é autoincrementada
    private int id;

    private String nome;

//  Getters & Setters:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrupoMuscular() {
        return nome;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.nome = nome;
    }
}
