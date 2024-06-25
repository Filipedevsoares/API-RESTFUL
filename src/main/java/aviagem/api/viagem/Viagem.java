package aviagem.api.viagem;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "viagens")
@Entity(name = "Viagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Viagem {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String ida;
    private String volta;

    public Viagem(DadosCadastroViagem dados) {
        this.id = id;
        this.ida = ida;
        this.volta = volta;
    }

    public void atualizarInformacoes(DadosAtualizacaoViagem dados) {
        if(dados.ida() != null) {
            this.ida = dados.ida();
        }
        if(dados.volta() != null) {
            this.volta = dados.volta();
        }

    }
}
