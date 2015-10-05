package br.univali.grafos.modelo;

import java.awt.Color;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
//teste

public class AStar {

    private int percorrido = 0;
    private int resultF;
    private String comparador = "";
    private int[] inicio = new int[2];
    private int[] fim = new int[2];
    private int[] proximoElemento = new int[4];
    private Painel[][] paineis;
    private List<Painel> listaFechada;

    public AStar(Painel[][] paineis) {
        this.paineis = paineis;
        this.listaFechada = new ArrayList<>();
    }

    public void desenhaMatriz() {
        if (paineis != null) {
            for (int lin = 0; lin < paineis.length; lin++) {
                for (int col = 0; col < paineis[lin].length; col++) {
                    if (paineis[lin][col].getTipo().equals("Inicial")) {
                        paineis[lin][col].setBackground(Color.GREEN);
                    } else if (paineis[lin][col].getTipo().equals("Final")) {
                        paineis[lin][col].setBackground(Color.RED);
                    } else if (paineis[lin][col].getTipo().equals("Muro")) {
                        paineis[lin][col].setBackground(Color.GRAY);
                    }
                }
            }
        }
    }

    public void inicia() {
        if (paineis != null) {
            for (int lin = 0; lin < paineis.length; lin++) {
                for (int col = 0; col < paineis[lin].length; col++) {
                    if (paineis[lin][col].getTipo().equals("Inicial")) {
                        inicio[0] = lin;
                        inicio[1] = col;
                    } else if (paineis[lin][col].getTipo().equals("Final")) {
                        fim[0] = lin;
                        fim[1] = col;
                    }
                }
            }
            proximo(inicio[0], inicio[1]);
        }
    }

    void proximo(int lin, int col) {
        comparador = "primeiro";
        boolean direita, diagInferiorDir, baixo, diagInferiorEsc, esquerda, diagSuperiorEsc, cima, diagSuperiorDir;

        if (lin == fim[0] && col == fim[1]) {
            System.out.println("Terminou em " + lin + " " + col);
        } else {
            direita = calcula(lin, col + 1, 10, comparador);                                                          // Direita
            diagInferiorDir = calcula(lin + 1, col + 1, 14, comparador);                                              // Diagonal inferior direita
            baixo = calcula(lin + 1, col, 10, comparador);                                                            // Baixo
            diagInferiorEsc = calcula(lin + 1, col - 1, 14, comparador);                                              // Diagonal inferior esquerda
            esquerda = calcula(lin, col - 1, 10, comparador);                                                         // Esquerda
            diagSuperiorEsc = calcula(lin - 1, col - 1, 14, comparador);                                              // Diagonal superior esquerda
            cima = calcula(lin - 1, col, 10, comparador);                                                             // Cima
            diagSuperiorDir = calcula(lin - 1, col + 1, 14, comparador);                                              // Diagonal superior direita

            if (!direita && !diagInferiorDir && !baixo && !diagInferiorEsc && !esquerda && !diagSuperiorEsc && !cima && !diagSuperiorDir) {
                listaFechada.removeAll(listaFechada);
                proximo(lin, col);
            }else{
                percorrido += proximoElemento[3];
                listaFechada.add(paineis[lin][col]);
                proximo(proximoElemento[0], proximoElemento[1]);
            }
        }
    }

    boolean calcula(int lin, int col, int custo, String aux) {
        if (analizaPassados(lin, col)) {                                             // Verifica se o elemento ja foi visitado
            if (lin >= 0 && col >= 0 && lin < paineis.length && col < paineis[0].length && !paineis[lin][col].getTipo().equals("Muro")) {
                paineis[lin][col].setG(percorrido + custo);
                paineis[lin][col].setH(10 * (abs(col - fim[1]) + abs(lin - fim[0])));
                resultF = paineis[lin][col].getG() + paineis[lin][col].getH();
                paineis[lin][col].setF(resultF);

                if (aux.equals("primeiro")) {
                    proximoElemento[0] = lin;
                    proximoElemento[1] = col;
                    proximoElemento[2] = paineis[lin][col].getF();
                    proximoElemento[3] = custo;
                    this.comparador = "";
                } else if (paineis[lin][col].getF() < proximoElemento[2]) {
                    proximoElemento[0] = lin;
                    proximoElemento[1] = col;
                    proximoElemento[2] = paineis[lin][col].getF();
                    proximoElemento[3] = custo;
                }
                return true;
            }else{
                return false;
            }
        } else {
            return false;
        }
    }

    boolean analizaPassados(int lin, int col) {
        for (Painel elemento : listaFechada) {
            if (elemento.getLin() == lin && elemento.getCol() == col) {
                return false;
            }
        }
        return true;
    }
}
