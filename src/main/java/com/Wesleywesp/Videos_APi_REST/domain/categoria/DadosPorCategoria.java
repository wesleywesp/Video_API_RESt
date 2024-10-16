package com.Wesleywesp.Videos_APi_REST.domain.categoria;

import com.Wesleywesp.Videos_APi_REST.domain.videos.Video;

public record DadosPorCategoria(Categoria categoria,
                                String titulo,
                                String descricao) {
    public DadosPorCategoria(Video video){
        this(video.getCategoria(), video.getTitulo(), video.getDescricao());
    }
}
