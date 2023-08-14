package com.br.solovet.Solovet.Model.Atividade;

public record DadosListagemAtividades( String hora_Agendada, String data_Agendada, Float preco, String descricao) {
    public DadosListagemAtividades(Atividade atividade){
        this(atividade.getHora_Agendada(), atividade.getData_Agendada(), atividade.getPreco(), atividade.getDescricao());
    }
}
