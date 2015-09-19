/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;
import javax.swing.JTextField;

/**
 *
 * @author Ailton Jr
 */
public class Dijkstra {

    int proximo = 0;
    double menor = 9223372036854775807L;

    MeuGrafo grafo;

    public void busca(MeuGrafo grafo, String rotuloInicial, String rotuloBusca) {
        this.grafo = grafo;
        for (Vertice vertice : grafo.vertices) {
            if (vertice.rotulo.equalsIgnoreCase(rotuloInicial)) {
                int inicial = vertice.id;
                grafo.vertices.get(inicial).estimativa = 0;
                grafo.vertices.get(inicial).precedente = grafo.vertices.get(0).rotulo;
                percorre(grafo.vertices.get(inicial));
            }
        }

        while (!verticeComplete()) {
            menor = 9223372036854775807L;
            if (!grafo.vertices.get(proximo).arcos.isEmpty()) {
                if (grafo.vertices.get(proximo).arcos.get(0).peso <= menor) {
                    percorre(grafo.vertices.get(proximo));
                }
            }
        }
    }

    private void percorre(Vertice verticeAtual) {
        System.out.println("\n\nVerificando " + verticeAtual.rotulo);
        for (Arco arco : verticeAtual.arcos) {
            if (arco.destino.estimativa == -1) {
                if (arco.peso < menor && !arco.destino.visitado) {
                    menor = arco.peso;
                    proximo = arco.destino.id;
                }
                arco.destino.estimativa = arco.origem.estimativa + arco.peso;
                arco.destino.precedente = arco.origem.rotulo;
                System.out.println("Inseriu " + arco.destino.estimativa + " no " + arco.destino.rotulo);

            } else if (arco.destino.estimativa > (arco.peso + arco.origem.estimativa)) {
                if (arco.peso < menor && !arco.destino.visitado) {
                    menor = arco.peso;
                    proximo = arco.destino.id;
                }
                arco.destino.estimativa = arco.origem.estimativa + arco.peso;
                arco.destino.precedente = arco.origem.rotulo;
                System.out.println("Atualizou  " + arco.destino.estimativa + " no " + arco.destino.rotulo);
            }
        }
        verticeAtual.visitado = true;
        System.out.println("Marcou vertice " + verticeAtual.rotulo + " como visitado");
        if (menor == 9223372036854775807L) {
            for (Vertice vertice : grafo.vertices) {
                if (!vertice.visitado) {
                    proximo = vertice.id;
                }
            }
        }
        System.out.println("Proximo " + grafo.vertices.get(proximo).rotulo);
    }

    boolean verticeComplete() {
        int cont = 0;
        for (Vertice vertice : grafo.vertices) {
            if (vertice.visitado) {
                cont++;
            }
        }
        if (cont == grafo.vertices.size()) {
            System.out.println("\n\n---------------------------- Resultados ----------------------------\n");
            System.out.print("Vertice:");
            for (Vertice vertice : grafo.vertices) {
                System.out.print("\t " + vertice.rotulo);
            }
            System.out.print("\n\nEstimativa:");
            for (Vertice vertice : grafo.vertices) {
                System.out.print("\t" + vertice.estimativa);
            }
            System.out.print("\n\nPrecedente:");
            for (Vertice vertice : grafo.vertices) {
                System.out.print("\t " + vertice.precedente);
            }
            System.out.println("\n");
            return true;
        }
        return false;
    }

}
