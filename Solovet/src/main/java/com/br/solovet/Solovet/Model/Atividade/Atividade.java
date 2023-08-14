package com.br.solovet.Solovet.Model.Atividade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "atividades")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String hora_Agendada;
    private String data_Agendada;
    private Float preco;
    private String descricao;
    private boolean status;
    private Long tutorId;
    private Long animalId;
    private Long veterinarioId;

    public Atividade(DadosCadastro dados) {
        this.hora_Agendada = dados.hora_Agendada();
        this.data_Agendada = dados.data_Agendada();
        this.preco = dados.preco();
        this.descricao = dados.descricao();
        this.status = true;
    }
}
