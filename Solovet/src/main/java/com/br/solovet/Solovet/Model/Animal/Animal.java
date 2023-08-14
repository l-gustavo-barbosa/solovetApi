package com.br.solovet.Solovet.Model.Animal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "animais")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String raca;
    private String sexo;
    private boolean castrado;
    private String nascimento;
    private String especie;
    private String pelagem;
    private Float peso;
    private boolean status;
    private Long tutorId;

    public Animal(DadosCadastro dados) {
        this.nome = dados.nome();
        this.raca = dados.raca();
        this.sexo = dados.sexo();
        this.castrado = dados.castrado();
        this.nascimento = dados.nascimento();
        this.especie = dados.especie();
        this.pelagem = dados.pelagem();
        this.peso = dados.peso();
        this.status = true;
    }
}
