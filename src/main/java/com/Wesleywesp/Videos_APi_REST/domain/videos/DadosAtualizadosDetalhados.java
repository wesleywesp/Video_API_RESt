package com.Wesleywesp.Videos_APi_REST.domain.videos;

public record DadosAtualizadosDetalhados(String titulo,
                                         String descricao,
                                         String url) {
    public DadosAtualizadosDetalhados(Video video) {
        this(video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
