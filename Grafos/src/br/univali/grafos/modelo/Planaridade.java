package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.Grafo;
import br.univali.grafos.principal.Vertice;
import javax.swing.JOptionPane;

public class Planaridade {

    private int cont = 1;
    private int idCiclo;
    private boolean cicloTres = false;
    private String resultado;

    public Planaridade(Grafo grafo) {
        if (grafo != null) {
            int qtdVertices = grafo.vertices.size();
            int qtdArestas = grafo.todosArcos.size();
            int qtdFaces = qtdArestas - qtdVertices + 2;

            System.out.println("Arcos: " + qtdArestas + "\tVertices: " + qtdVertices);
            System.out.println("R = " + qtdArestas + " - " + qtdVertices + " + 2");
            System.out.println("Faces: " + qtdFaces);

            if (qtdVertices >= 3) {
                if (qtdArestas <= (3 * qtdVertices) - 6) { // E <= 3*v - 6
                    isTemCiclo(grafo);
                    if (!cicloTres) {   // Se nao houver ciclos de comprimento 3
                        if (qtdArestas <= 2 * qtdVertices - 4) {
                            resultado = "O grafo E PLANAR!";
                            System.out.println("O grafo E PLANAR!");
                        } else {
                            resultado = "O grafo NAO e planar!";
                            System.out.println("O grafo NAO e planar**!");
                        }
                    } else {
                        resultado = "O grafo E PLANAR!";
                        System.out.println("O grafo E PLANAR!");
                    }

                } else {
                    resultado = "O grafo NAO e planar!";
                    System.out.println("O grafo NAO e planar!");
                }
            } else {    // So tem dois ou menos vertices, logo e planar.
                resultado = "O grafo E PLANAR!";
                System.out.println("O grafo E PLANAR");
            }
            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    public boolean isTemCiclo(Grafo grafo) {
        for (Vertice vertice : grafo.vertices) {
            if (cicloDeTres(vertice)) {
                return true;
            }
            cont = 1;
        }
        return false;
    }

    public boolean cicloDeTres(Vertice vertice) {
        // TO DO: Verificar ciclo de comprimento tres
        if (cont == 1) {
            idCiclo = vertice.id;
        }

        for (Arco arco : vertice.arcos) {
            if (cont < 3) {
                cont++;
                cicloDeTres(arco.destino);
            } else if (arco.destino.id == idCiclo) {    // se contador == 3 e fecha um ciclo com o primeiro
                cicloTres = true;
                return true;
            }
        }
        cont--;
        return false;
    }

}
