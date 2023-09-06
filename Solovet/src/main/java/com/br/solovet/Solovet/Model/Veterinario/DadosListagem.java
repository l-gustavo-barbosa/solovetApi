package com.br.solovet.Solovet.Model.Veterinario;

public record DadosListagem( Long id, String email, String nome, String crmv, String telefone) {
    public DadosListagem(Veterinario veterinario){
        this(veterinario.getId(), veterinario.getNome(), veterinario.getCrmv(), veterinario.getEmail(), veterinario.getTelefone());
    }
}
