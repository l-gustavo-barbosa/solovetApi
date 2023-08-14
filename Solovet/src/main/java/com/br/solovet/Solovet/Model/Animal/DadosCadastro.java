package com.br.solovet.Solovet.Model.Animal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastro (
        @NotBlank
         String nome,
        @NotBlank
         String raca,
        @NotBlank
         String sexo,
         boolean castrado,
         @NotNull
         String nascimento,
        @NotBlank
         String especie,
        @NotBlank
         String pelagem,
         @NotNull
         Float peso
){ }
