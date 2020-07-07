package br.com.alvoradatec.campominado.visao;

import br.com.alvoradatec.campominado.modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;


@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel { // JPanel é um container

    public PainelTabuleiro(Tabuleiro tabuleiro) {

        setLayout(new GridLayout(
                tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
        tabuleiro.registrarObservador(e -> {

            SwingUtilities.invokeLater(() -> {
                if(e.isGanhou()) {
                    JOptionPane.showMessageDialog(this, "Ganhou :)");
                } else {
                    JOptionPane.showMessageDialog(this, "Perdeu :(");
                }

                tabuleiro.reiniciar();
            });
        });
    }
}
