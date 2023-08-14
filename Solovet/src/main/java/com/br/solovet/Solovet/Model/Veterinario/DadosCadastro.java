package com.br.solovet.Solovet.Model.Veterinario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastro(

        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotBlank
        String crmv,
        @NotBlank @Pattern(regexp = "\\d{10,11}")
        String telefone
        
) {
}
