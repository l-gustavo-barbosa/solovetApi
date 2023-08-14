package com.br.solovet.Solovet.Model.Animal;

public record DadosListagemAnimais(     String nome, String raca, String sexo, boolean castrado, String nascimento,String especie, String pelagem, Float peso) {
    public DadosListagemAnimais(Animal animal){
        this(animal.getNome(), animal.getRaca(), animal.getSexo(), animal.isCastrado(), animal.getNascimento(), animal.getEspecie(), animal.getPelagem(), animal.getPeso());
    }
}
