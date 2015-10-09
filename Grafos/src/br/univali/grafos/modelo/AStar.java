package br.univali.grafos.modelo;

import br.univali.grafos.visao.TelaAEstrela;
import java.awt.Color;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private List<Buraco> listaFechadaBuracos = new ArrayList();
    private List<Buraco> pilhaBuracos = new ArrayList();
    

    public AStar(Painel[][] paineis) {
        this.paineis = paineis;
        this.listaFechada = new ArrayList<>();
    }

    public void desenhaMatriz() {
        if (paineis != null) {
            for (Painel[] painei1 : paineis) {
                for (Painel painei : painei1) {
                    switch (painei.getTipo()) {
                        case "Inicial":
                            painei.setBackground(Color.GREEN);
                            break;
                        case "Final":
                            painei.setBackground(Color.RED);
                            break;
                        case "Muro":
                            painei.setBackground(Color.GRAY);
                            break;
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
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    proximo(inicio[0], inicio[1]);
                }
            });
            thread.start();

        }
    }

    void proximo(int lin, int col) {
        comparador = "primeiro";
        boolean direita, diagInferiorDir, baixo, diagInferiorEsc, esquerda, diagSuperiorEsc, cima, diagSuperiorDir;

        if (lin == fim[0] && col == fim[1]) {
            System.out.println("Terminou em " + lin + " " + col);
        } else {
            direita = calcula(lin, col + 1, 10, comparador);                                                            // Direita
            diagInferiorDir = calcula(lin + 1, col + 1, 14, comparador);                                                // Diagonal inferior direita
            baixo = calcula(lin + 1, col, 10, comparador);                                                              // Baixo
            diagInferiorEsc = calcula(lin + 1, col - 1, 14, comparador);                                                // Diagonal inferior esquerda
            esquerda = calcula(lin, col - 1, 10, comparador);                                                           // Esquerda
            diagSuperiorEsc = calcula(lin - 1, col - 1, 14, comparador);                                                // Diagonal superior esquerda
            cima = calcula(lin - 1, col, 10, comparador);                                                               // Cima
            diagSuperiorDir = calcula(lin - 1, col + 1, 14, comparador);                                                // Diagonal superior direita

            if (!direita && !diagInferiorDir && !baixo && !diagInferiorEsc && !esquerda && !diagSuperiorEsc && !cima && !diagSuperiorDir) {
                for (Painel fechada : listaFechada) {
                    fechada.setBackground(Painel.corAntiga);                                                            // Quando zerar a lista dos visitados retorna a cor padrao
                }
                listaFechada.removeAll(listaFechada);
                proximo(lin, col);
            } else {
                percorrido += proximoElemento[3];
                listaFechada.add(paineis[lin][col]);
                paineis[lin][col].setBackground(Color.ORANGE);                                                          // Pinta os que já foram visitados
                paineis[proximoElemento[0]][proximoElemento[1]].setBackground(Color.GREEN);

                try {
                    // Animacao
                    Thread.sleep(TelaAEstrela.slider.getValue());
                    teste(lin, col + 1);
                    teste(lin + 1, col + 1);
                    teste(lin + 1, col);
                    teste(lin + 1, col - 1);
                    teste(lin, col - 1);
                    teste(lin - 1, col - 1);
                    teste(lin - 1, col);
                    teste(lin - 1, col + 1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AStar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                analizaBuracos(lin, col);
                proximo(proximoElemento[0], proximoElemento[1]);
            }
        }
    }

    void teste(int lin, int col) {
        if (lin >= 0 && col >= 0 && lin < paineis.length && col < paineis[0].length && !paineis[lin][col].getTipo().equals("Muro")) {
            paineis[lin][col].label_F.setText("");
        }
    }

    boolean calcula(int lin, int col, int custo, String aux) {
        if (analizaPassados(lin, col)) {                                                                                // Verifica se o elemento ja foi visitado
            try {
                Thread.sleep(TelaAEstrela.slider.getValue());
            } catch (InterruptedException ex) {
                Logger.getLogger(AStar.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (lin >= 0 && col >= 0 && lin < paineis.length && col < paineis[0].length && !paineis[lin][col].getTipo().equals("Muro")) {
                paineis[lin][col].setG(percorrido + custo);
                paineis[lin][col].setH(10 * (abs(col - fim[1]) + abs(lin - fim[0])));
                resultF = paineis[lin][col].getG() + paineis[lin][col].getH();
                paineis[lin][col].setF(resultF);
                paineis[lin][col].label_F.setText("" + resultF);

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
            } else {
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
    
    void analizaBuracos (int x, int y){
        // Faltando impedir que va para uma posição da listaFechadaBuracos
       
        for (Buraco pilhaBuraco : pilhaBuracos) {
            if (pilhaBuraco.getX() == x && pilhaBuraco.getY() == y) {
                listaFechadaBuracos.add(pilhaBuraco);
                pilhaBuracos.remove(pilhaBuraco);
            }
        }
        
        // Nao testar isso se achar um cara no foreach
        if (x-1 >= 0 && y-1 >= 0) {
            if (paineis[x][y-1].getTipo().equals("Muro") && paineis[x][y+1].getTipo().equals("Muro")) {     // Cima-baixo
                pilhaBuracos.add(new Buraco(x, y));
            } else if (paineis[x-1][y].getTipo().equals("Muro") && paineis[x+1][y-1].getTipo().equals("Muro")) {    // Lado-lado
                pilhaBuracos.add(new Buraco(x, y));
            } else if ((paineis[x+1][y-1].getTipo().equals("Muro") || paineis[x-1][y-1].getTipo().equals("Muro")) && paineis[x-1][y].getTipo().equals("Muro")) {    // Diagonal ancorado em baixo
                pilhaBuracos.add(new Buraco(x, y));
            } else if (paineis[x][y-1].getTipo().equals("Muro") && (paineis[x+1][y+1].getTipo().equals("Muro") || paineis[x-1][y+1].getTipo().equals("Muro"))) {    // Diagonal ancorado em cima
                pilhaBuracos.add(new Buraco(x, y));
            }
        }  
        
    }
}
