package aviagem.api.controller;


import aviagem.api.viagem.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("viagens")
public class ViagemController {

    @Autowired
    private ViagemRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroViagem dados) {

        repository.save(new Viagem(dados));
    }

    @GetMapping
    public Page<DadosListagemViagem> Listar (@PageableDefault(size = 5, sort = "ida") Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemViagem::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoViagem dados) {

        var viagem = repository.getReferenceById(String.valueOf(dados.id()));
        viagem.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(String.valueOf(id));
    }
}
