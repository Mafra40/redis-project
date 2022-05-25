package br.com.redis.controler;

import br.com.redis.model.Produto;
import br.com.redis.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoCrontroller {


    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    public Produto save(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> findAllProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable int id){
        return produtoRepository.findProdutoById(id);
    }

    @DeleteMapping("/{id}")
    public  String delete(@PathVariable int id){
        return  produtoRepository.delete(id);
    }

}
