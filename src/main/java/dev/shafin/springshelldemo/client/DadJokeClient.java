package dev.shafin.springshelldemo.client;

import dev.shafin.springshelldemo.model.DadJokeResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface DadJokeClient {
    @GetExchange("/")
    DadJokeResponse random();
}
