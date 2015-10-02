package br.univali.grafos.modelo;

import java.awt.Color;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

public class AStar {

    private int percorrido = 0;
    private int resultF;
    private String comparador = "";
    private int[] inicio = new int[2];
    private int[] fim = new int[2];
    private int[] proximoElemento = new int[4];
    private Painel[][] matriz;
    private List<Painel> listaFechada;
    

    public AStar(Painel[][] paineis) {
        this.matriz = paineis;
        this.listaFechada = new ArrayList<>();
        if (matriz != null) {
            for (int lin = 0; lin < matriz.length; lin++) {
                for (int col = 0; col < matriz[lin].length; col++) {
                    if (matriz[lin][col].getTipo().equals("Inicial")) {
                        inicio[0] = lin;
                        inicio[1] = col;
                        matriz[lin][col].setBackground(Color.GREEN);
                    } else if (matriz[lin][col].getTipo().equals("Final")) {
                        fim[0] = lin;
                        fim[1] = col;
                        matriz[lin][col].setBackground(Color.RED);
                    } else if (matriz[lin][col].getTipo().equals("Muro")) {
                        matriz[lin][col].setBackground(Color.GRAY);
                    }
                }
            }
            proximo(inicio[0], inicio[1]);
        }
    }

    void proximo(int lin, int col) {
        comparador = "primeiro";
        if (lin == fim[0] && col == fim[1]) {
            System.out.println("Terminou em " + lin + " " + col);
        } else {
            calcula(lin, col + 1, 10, comparador);                                                // Direita
            calcula(lin + 1, col + 1, 14, comparador);                                              // Diagonal inferior direita
            calcula(lin + 1, col, 10, comparador);                                                // Baixo
            calcula(lin + 1, col - 1, 14, comparador);                                              // Diagonal inferior esquerda
            calcula(lin, col - 1, 10, comparador);                                                // Esquerda
            calcula(lin - 1, col - 1, 14, comparador);                                              // Diagonal superior esquerda
            calcula(lin - 1, col, 10, comparador);                                                // Cima
            calcula(lin - 1, col + 1, 14, comparador);                                              // Diagonal superior direita
            percorrido += proximoElemento[3];
            listaFechada.add(matriz[lin][col]);
            proximo(proximoElemento[0], proximoElemento[1]);
        }
    }

    void calcula(int lin, int col, int custo, String aux) {
        if (analizaPassados(lin, col)) {                                             // Verifica se o elemento ja foi visitado
            if (lin >= 0 && col >= 0 && lin < matriz.length && col < matriz[0].length && !matriz[lin][col].getTipo().equals("Muro")) {
                matriz[lin][col].setG(percorrido + custo);
                matriz[lin][col].setH(10 * (abs(col - fim[1]) + abs(lin - fim[0])));
                resultF = matriz[lin][col].getG() + matriz[lin][col].getH();
                matriz[lin][col].setF(resultF);

                if (aux.equals("primeiro")) {
                    proximoElemento[0] = lin;
                    proximoElemento[1] = col;
                    proximoElemento[2] = matriz[lin][col].getF();
                    proximoElemento[3] = custo;
                    this.comparador = "";
                } else if (matriz[lin][col].getF() < proximoElemento[2]) {
                    proximoElemento[0] = lin;
                    proximoElemento[1] = col;
                    proximoElemento[2] = matriz[lin][col].getF();
                    proximoElemento[3] = custo;
                }
            }
        } else {
            //System.out.println("ja foi visitado");
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
