package com.Wesleywesp.Videos_APi_REST.domain.videos;

public record DadosListarVideos(Long id,
                                String titulo,
                                String Descricao,
                                String url) {
    public DadosListarVideos(Video video){
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
