package br.com.redis.repository;

import br.com.redis.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {

    public static final String HASH_KEY = "produto:";

    @Autowired
    private RedisTemplate template;

    public Produto save(Produto produto){
        template.opsForHash().put(HASH_KEY, produto.getId(),produto);
        return produto;
    }

    public List<Produto> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Produto findProdutoById(int id){
      return ( Produto)  template.opsForHash().get(HASH_KEY, id);
    }

    public String delete(int id) {
         template.opsForHash().delete(HASH_KEY, id);
         return id + "removido";
    }

}
