package com.Wesleywesp.Videos_APi_REST.domain.videos;

import com.Wesleywesp.Videos_APi_REST.domain.categoria.CategoriaInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastrarVideo(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", message = "URL inválida")
        String url,
        @NotNull
        CategoriaInput categoria
) {
}
