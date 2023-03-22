package dev.shafin.springshelldemo.commands;

import dev.shafin.springshelldemo.client.DadJokeClient;
import dev.shafin.springshelldemo.model.DadJokeResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class DadJokeCommand {
    private final DadJokeClient dadJokeClient;

    public DadJokeCommand(DadJokeClient dadJokeClient) {
        this.dadJokeClient = dadJokeClient;
    }
    @ShellMethod(key = "joke", value = "i will tell a random joke!")
    public String getRandomJoke(){
        DadJokeResponse response = dadJokeClient.random();
        return response.joke();
    }
}
