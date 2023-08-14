package com.br.solovet.Solovet.Model.Tutor;

import com.br.solovet.Solovet.Model.Endereco.DadosCadastroEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastro(
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{10,11}")
        String telefone,
        @Valid @NotNull
        DadosCadastroEndereco endereco,
        @NotBlank
        String sexo,
        @NotBlank @Pattern(regexp = "\\d{11}")
        String cpf,
        @NotBlank
        String rg,
        @NotBlank
        String aniversario

){
}
