package com.borelanjo.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    @DisplayName("Deve criar uma instância de jogo")
    void criarUmaInstanciadeJogo() {
        Game game = new Game();
        Assertions.assertTrue(game instanceof Game);
    }

    @Test
    @DisplayName("Quando o jogador errar não deve derrubar nenhum pino")
    void errarPinos() {
        Game game = new Game();
        game.derrubar(0);
    }
}
