package br.com.redis.publisher;

import br.com.redis.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PublisherController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ChannelTopic topic;

    @PostMapping("/publisher")
    private String publish(@RequestBody Produto produto){
        redisTemplate.convertAndSend(topic.getTopic(), produto.toString());
        return "Evento publicado... " + produto;
    }

}
