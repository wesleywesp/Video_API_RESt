package com.Wesleywesp.Videos_APi_REST.domain.videos;

public record VideoDetalhe(String titulo,
                           String Descricao,
                           String url) {
    public VideoDetalhe(Video video){
        this(video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
