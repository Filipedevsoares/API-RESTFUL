package aviagem.api.viagem;

public record DadosListagemViagem(Long id, String ida, String volta) {

    public DadosListagemViagem(Viagem viagem) {
        this(Long.valueOf(viagem.getId()),viagem.getIda(), viagem.getVolta());
    }
}
