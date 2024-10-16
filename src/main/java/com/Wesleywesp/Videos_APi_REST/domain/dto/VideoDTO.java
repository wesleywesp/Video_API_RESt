package com.Wesleywesp.Videos_APi_REST.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class VideoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private Boolean ativo;
    private String categoriaEnum; // Aqui você pode guardar a categoria como uma string
}
