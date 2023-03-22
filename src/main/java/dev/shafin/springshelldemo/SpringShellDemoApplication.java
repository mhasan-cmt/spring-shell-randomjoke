package dev.shafin.springshelldemo;

import dev.shafin.springshelldemo.client.DadJokeClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class SpringShellDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShellDemoApplication.class, args);
    }

    @Bean
    DadJokeClient dadJokeClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://icanhazdadjoke.com")
                .defaultHeader("Accept", "application/json")
                .build();
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
        return factory.createClient(DadJokeClient.class);
    }
}
