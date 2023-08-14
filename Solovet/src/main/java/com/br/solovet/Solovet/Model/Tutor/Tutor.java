package com.br.solovet.Solovet.Model.Tutor;

import com.br.solovet.Solovet.Model.Animal.Animal;
import com.br.solovet.Solovet.Model.Endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "tutores")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private String sexo;
    private String cpf;
    private String rg;
    private String aniversario;
    private boolean status;
    private Long veterinarioId;
    @Transient @ManyToOne
    private List<Animal> animais = new ArrayList<Animal>();

    public Tutor(DadosCadastro dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        this.sexo = dados.sexo();
        this.cpf = dados.cpf();
        this.rg = dados.rg();
        this.aniversario = dados.aniversario();
        this.status = true;
    }

    public boolean getStatus() {
        return this.status;
    }

}
