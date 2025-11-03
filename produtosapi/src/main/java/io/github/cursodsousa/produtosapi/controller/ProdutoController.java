package io.github.cursodsousa.produtosapi.controller;

import io.github.cursodsousa.produtosapi.model.Produto;
import io.github.cursodsousa.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController //marca a classe para ser um controlador rest, ou seja, vai receber as requisições
@RequestMapping ("produtos") //determina qual é a url base para esse controller
public class ProdutoController {

    private ProdutoRepository produtoRepository;
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @PostMapping  //cria um recurso no servidor, como salvar algum dado
    public Produto salvar (@RequestBody Produto produto){
        UUID.randomUUID().toString();

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);

    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){ //@RequestParam => passar parâmetro da url
        return produtoRepository.findByNome(nome);
    }



}
