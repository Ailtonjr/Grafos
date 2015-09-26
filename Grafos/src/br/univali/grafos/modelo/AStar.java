package br.univali.grafos.modelo;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;

public class AStar {

    Elemento[][] matriz;
    int[] inicio = new int[2];
    int[] fim = new int[2];
    int[] proximoElemento = new int[4];
    List<Elemento> listaFechada;
    int percorrido = 0;
    String comparador = "";
    int resultF;

    public AStar() {
        LeitorXML_Aestrela leitor = new LeitorXML_Aestrela();
        this.matriz = leitor.montaMatriz();
        this.listaFechada = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].getTipo().equals("Inicial")) {
                    inicio[0] = i;
                    inicio[1] = j;
                } else if (matriz[i][j].getTipo().equals("Final")) {
                    fim[0] = i;
                    fim[1] = j;
                }
            }
        }
        proximo(inicio[0], inicio[1]);
    }

    void proximo(int i, int j) {
        comparador = "primeiro";
        if (i == fim[0] && j == fim[1]) {
            System.out.println("Terminou em " + i +" "+ j);
        } else {
            calcula(i, j + 1, 10, comparador);                                                // Direita
            calcula(i + 1, j + 1, 14, comparador);                                              // Diagonal inferior direita
            calcula(i + 1, j, 10, comparador);                                                // Baixo
            calcula(i + 1, j - 1, 14, comparador);                                              // Diagonal inferior esquerda
            calcula(i, j - 1, 10, comparador);                                                // Esquerda
            calcula(i - 1, j - 1, 14, comparador);                                              // Diagonal superior esquerda
            calcula(i - 1, j, 10, comparador);                                                // Cima
            calcula(i - 1, j + 1, 14, comparador);                                              // Diagonal superior direita
            percorrido += proximoElemento[3];
            listaFechada.add(matriz[i][j]);
            proximo(proximoElemento[0], proximoElemento[1]);
        }
    }

    void calcula(int i, int j, int custo, String aux) {
        if (analizaPassados(i,j)) {                                             // Verifica se o elemento ja foi visitado
            if (i >= 0 && j >= 0 && i < matriz.length && j < matriz[0].length && !matriz[i][j].getTipo().equals("Muro")) {
                matriz[i][j].setG(percorrido + custo);
                matriz[i][j].setH(10 * (abs(j - fim[1]) + abs(i - fim[0])));
                resultF = matriz[i][j].getG() + matriz[i][j].getH();
                matriz[i][j].setF(resultF);

                if (aux.equals("primeiro")) {
                    proximoElemento[0] = i;
                    proximoElemento[1] = j;
                    proximoElemento[2] = matriz[i][j].getF();
                    proximoElemento[3] = custo;
                    this.comparador = "";
                } else if (matriz[i][j].getF() < proximoElemento[2]) {
                    proximoElemento[0] = i;
                    proximoElemento[1] = j;
                    proximoElemento[2] = matriz[i][j].getF();
                    proximoElemento[3] = custo;
                }
            }
        }else{
            System.out.println("ja foi visitado");
        }
    }

    boolean analizaPassados(int i, int j) {
        for (Elemento elemento : listaFechada) {
            if (elemento.getI() == i && elemento.getJ() == j) {
                return false;
            }
        }
        return true;
    }
}
