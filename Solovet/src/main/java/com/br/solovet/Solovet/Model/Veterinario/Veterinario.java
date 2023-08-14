package com.br.solovet.Solovet.Model.Veterinario;

import com.br.solovet.Solovet.Model.Tutor.Tutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Table(name = "veterinarios")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Veterinario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crmv;
    private String telefone;
    private boolean status;




    public Veterinario(DadosCadastro dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.crmv = dados.crmv();
        this.telefone = dados.telefone();
        this.status = true;

    }
}
