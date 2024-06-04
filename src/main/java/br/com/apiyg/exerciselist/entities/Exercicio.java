package br.com.apiyg.exerciselist.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "tb_exercicios")
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int qtdSeries;
    private int qtdReps;

    @ManyToOne
//    definindo que a instância grupo_id desta classe está
//    associada a instância da classe GrupoMuscular e esta relação é de muitos para um
//    portando, vários exercícios estão associados a um grupo muscular.

    @JoinColumn (name = "grupo_id")
//    esta notação visa especificar qual coluna no lado do proprietário da associação
//    contém a chave estrangeira que se refere à tabela do lado inverso da mesma.

    private GrupoMuscular grupoMuscular;

    public Exercicio (){

    }

//    Getters & Setters:


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdSeries() {
        return qtdSeries;
    }

    public void setQtdSeries(int qtdSeries) {
        this.qtdSeries = qtdSeries;
    }

    public int getQtdReps() {
        return qtdReps;
    }

    public void setQtdReps(int qtdReps) {
        this.qtdReps = qtdReps;
    }

    public GrupoMuscular getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }
}
