package com.borelanjo.application;

public class Game {
    private int lancamentoAtual = 0;
    private int lancamentos[] = new int[21];

    public void derruba(int pinos) {
        lancamentos[lancamentoAtual++] = pinos;
    }


    public int pontuacao() {
        int score = 0;
        int primeiroLancamento = 0;

        for (int frame = 0; frame < 10; frame++) {

            if (isStrike(primeiroLancamento)) {
                score += calculaBonusStrike(primeiroLancamento);
            } else {
                if (isSpare(primeiroLancamento)) {
                    score += calculaBonusSpare(primeiroLancamento);
                } else {
                    score += lancamentos[primeiroLancamento] + proximoLancamento(primeiroLancamento, 1);
                }

            }
            primeiroLancamento += isStrike(primeiroLancamento) ? 1 : 2;

        }
        return score;
    }

    private int calculaBonusStrike(int lancamento) {
        return 10 + proximoDoisLancamentos(lancamento);
    }

    private int calculaBonusSpare(int lancamento) {
        return 10 + proximoLancamento(lancamento, 2);
    }

    private int proximoLancamento(int lancamento, int i) {
        return lancamentos[lancamento + i];
    }

    private int proximoDoisLancamentos(int lancamento) {
        return proximoLancamento(lancamento, 1) + proximoLancamento(lancamento, 2);
    }

    private boolean isSpare(int primeiroLancamento) {
        int segundoLancamento = primeiroLancamento + 1;
        return lancamentos[primeiroLancamento] + lancamentos[segundoLancamento] == 10;
    }

    private boolean isStrike(int primeiroLancamento) {
        return lancamentos[primeiroLancamento] == 10;
    }
}
