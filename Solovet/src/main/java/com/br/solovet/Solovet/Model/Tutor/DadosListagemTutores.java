package com.br.solovet.Solovet.Model.Tutor;

import com.br.solovet.Solovet.Model.Endereco.Endereco;
import jakarta.persistence.Embedded;

public record DadosListagemTutores( Long id , String nome , String email , String telefone ,
                                    Endereco endereco , String sexo , String cpf , String rg ,
                                    String aniversario , boolean status , Long veterinarioId) {
    public DadosListagemTutores(Tutor tutor){
        this(tutor.getId(), tutor.getNome(), tutor.getEmail(), tutor.getTelefone(),
                tutor.getEndereco(), tutor.getSexo(), tutor.getCpf(), tutor.getRg(),
                tutor.getAniversario(), tutor.getStatus(), tutor.getVeterinarioId());
    }
}

