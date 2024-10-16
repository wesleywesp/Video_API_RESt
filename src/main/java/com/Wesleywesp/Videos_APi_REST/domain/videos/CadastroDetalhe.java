package com.Wesleywesp.Videos_APi_REST.domain.videos;


import com.Wesleywesp.Videos_APi_REST.domain.categoria.Categoria;

public record CadastroDetalhe(String titulo,
                              String Descricao,
                              String url,
                              Categoria categoria
                            ) {
    public CadastroDetalhe(Video video) {
        this(video.getTitulo(), video.getDescricao(), video.getUrl(), video.getCategoria());
    }
}
