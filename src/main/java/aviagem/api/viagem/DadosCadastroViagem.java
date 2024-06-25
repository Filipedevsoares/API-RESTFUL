package aviagem.api.viagem;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroViagem(
        @NotBlank
        String ida,

        @NotBlank
        String volta) {
}
