package com.borelanjo.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    @DisplayName("Jogador na sua vez errou todos os pinos")
    void deveFazerUmaJogadaENaoDerrubarPinos() {
        game.derruba(0);
        assertEquals(0, game.pontuacao());
    }

    @Test
    @DisplayName("Jogador na sua vez acertou um único pino")
    void deveDerrubarUmPino() {
        game.derruba(1);
        assertEquals(1, game.pontuacao());
    }

    @Test
    @DisplayName("Jogador terminou o jogo errando todos os pinos")
    void deveFazerTodasJogadasENaoDerrubarPinos() {
        game.derruba(1);
        derrubaPinos(19, 0);
        assertEquals(1, game.pontuacao());
    }

    @Test
    @DisplayName("Jogador terminou o jogo acertando um único pino")
    void deveFazerTodasJogadasEDerrubarUmUnicoPino() {
        game.derruba(1);
        derrubaPinos(19, 0);
        assertEquals(1, game.pontuacao());
    }

    @Test
    @DisplayName("Jogador terminou o jogo fazendo um Spare e acertando três pinos")
    void deveFazerTodasJogadasEFazerUmSpareEDerrubarTresPinos() {
        fezSpare();
        game.derruba(3);
        derrubaPinos(17, 0);
        assertEquals(16, game.pontuacao());
    }

    @Test
    @DisplayName("Jogador terminou o jogo fazendo um Strike, acertando três pinos em outra e depois mais quatro em outra")
    void deveFazerTodasJogadasEFazerUmStrikeEDerrubarTresPinos() {
        fezStrike();
        game.derruba(3);
        game.derruba(4);
        derrubaPinos(16, 0);
        assertEquals(24, game.pontuacao());
    }

    @Test
    @DisplayName("Jogador fez um jogo perfeito")
    void deveFazerUmJogoPerfeito() {
        derrubaPinos(12, 10);
        assertEquals(300, game.pontuacao());
    }

    @Test
    @DisplayName("Jogador jogou uma partida e fez 133 pontos")
    void deveFazer133pontos() {
        game.derruba(1);
        game.derruba(4);

        game.derruba(4);
        game.derruba(5);

        game.derruba(6);
        game.derruba(4);

        fezSpare();

        fezStrike();

        game.derruba(0);
        game.derruba(1);

        game.derruba(7);
        game.derruba(3);

        game.derruba(6);
        game.derruba(4);

        fezStrike();

        game.derruba(2);
        game.derruba(8);
        game.derruba(6);
        assertEquals(133, game.pontuacao());
    }

    private void fezStrike() {
        game.derruba(10);
    }

    private void fezSpare() {
        game.derruba(5);
        game.derruba(5);
    }

    private void derrubaPinos(int jogadas, int pinos) {
        for (int i = 0; i < jogadas; i++) {
            game.derruba(pinos);
        }
    }
}
