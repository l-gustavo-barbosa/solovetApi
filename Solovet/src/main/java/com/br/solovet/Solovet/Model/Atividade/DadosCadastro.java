package com.br.solovet.Solovet.Model.Atividade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastro(
        @NotBlank
        String hora_Agendada,
        @NotBlank
        String data_Agendada,
        @NotNull
        Float preco,

        String descricao
) {
}
