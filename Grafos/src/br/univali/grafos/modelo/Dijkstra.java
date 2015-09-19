/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;

/**
 *
 * @author Ailton Jr
 */
public class Dijkstra {

    int proximo = 0;
    double menor = 9223372036854775807L;

    MeuGrafo grafo;

    public void busca(MeuGrafo grafo, String rotulo) {
        this.grafo = grafo;
        grafo.vertices.get(0).estimativa = 0;
        grafo.vertices.get(0).precedente = grafo.vertices.get(0).rotulo;
        percorre(grafo.vertices.get(0));

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
            System.out.println("acabou!!!!!!!!!!!!!");
            return true;
        }
        return false;
    }
}
