package br.com.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("produto:")
public class Produto implements Serializable {

    @Id
    private int id;
    private String nome;
    private int qtd;
    private float preco;

}
