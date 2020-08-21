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
            int segundoLancamento = primeiroLancamento + 1;

            if (isStrike(primeiroLancamento)) {
                aplicaBonusStrike(primeiroLancamento);
            }

            if (isSpare(primeiroLancamento)) {
                aplicaBonusSpare(primeiroLancamento);
            }

            score += lancamentos[primeiroLancamento];
            primeiroLancamento++;
        }
        return score;
    }

    private void aplicaBonusStrike(int lancamento) {
        lancamentos[lancamento] += lancamentos[lancamento+1]+ lancamentos[lancamento+2];
    }

    private void aplicaBonusSpare(int lancamento) {
        lancamentos[lancamento+1] += lancamentos[lancamento+2];
    }

    private boolean isSpare(int primeiroLancamento) {
        int segundoLancamento = primeiroLancamento + 1;
        return lancamentos[primeiroLancamento] + lancamentos[segundoLancamento] == 10;
    }

    private boolean isStrike(int primeiroLancamento) {
        return lancamentos[primeiroLancamento] == 10;
    }
}
