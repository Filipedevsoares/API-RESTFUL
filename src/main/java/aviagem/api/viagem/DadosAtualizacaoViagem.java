package aviagem.api.viagem;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoViagem(@NotNull Long id, String ida, String volta) {
}
