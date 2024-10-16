package com.Wesleywesp.Videos_APi_REST.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record CategoriaInput(
        @NotBlank String valor // Este campo pode ser um título ou uma cor
) {
}
