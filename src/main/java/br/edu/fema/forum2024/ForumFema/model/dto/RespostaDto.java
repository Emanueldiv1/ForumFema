package br.edu.fema.forum2024.ForumFema.model.dto;

import br.edu.fema.forum2024.ForumFema.model.Resposta;

import java.time.LocalDateTime;

public class RespostaDto {
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.dataCriacao = resposta.getDataCriacao();
        this.nomeAutor = resposta.getAutor().getNome();
    }
}
