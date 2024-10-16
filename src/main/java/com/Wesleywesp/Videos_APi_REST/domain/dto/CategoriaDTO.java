package com.Wesleywesp.Videos_APi_REST.domain.dto;

import com.Wesleywesp.Videos_APi_REST.domain.categoria.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class CategoriaDTO {
    private Long id;
    private String categoriaEnum;
    private List<VideoDTO> videos;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.categoriaEnum = categoria.getCategoriaEnum().name();
        this.videos = categoria.getVideos().stream()
                .map(video -> new VideoDTO(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl(), video.getAtivo(), this.categoriaEnum))
                .collect(Collectors.toList());
    }
}
