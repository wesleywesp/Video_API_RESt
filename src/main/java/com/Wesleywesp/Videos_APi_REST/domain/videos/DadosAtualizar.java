package com.Wesleywesp.Videos_APi_REST.domain.videos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizar(@NotNull
                             Long id,
                             String titulo,
                             String descricao,
                             String url) {
}
