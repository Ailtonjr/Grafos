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
    double aux;
    MeuGrafo grafo;

    public void busca(MeuGrafo grafo, String rotulo) {
        this.grafo = grafo;
        grafo.vertices.get(0).estimativa = 0;
        grafo.vertices.get(0).precedente = grafo.vertices.get(0).rotulo;

        aux = grafo.vertices.get(0).arcos.get(0).peso;
        percorre(grafo.vertices.get(0));
        //while (!verticeComplete()) {
        if (!grafo.vertices.get(1).arcos.isEmpty()) {
            aux = grafo.vertices.get(1).arcos.get(0).peso;
            if (grafo.vertices.get(1).arcos.get(0).peso <= aux) {
                if (!grafo.vertices.get(1).arcos.get(0).destino.visitado) {
                    proximo = grafo.vertices.get(1).arcos.get(0).destino.id;
                }
                percorre(grafo.vertices.get(1));
            }
        }

        if (!grafo.vertices.get(4).arcos.isEmpty()) {
            aux = grafo.vertices.get(4).arcos.get(0).peso;
            if (grafo.vertices.get(4).arcos.get(0).peso <= aux) {
                if (!grafo.vertices.get(4).arcos.get(0).destino.visitado) {
                    proximo = grafo.vertices.get(4).arcos.get(0).destino.id;
                }

                percorre(grafo.vertices.get(4));
            }
        }

        if (!grafo.vertices.get(3).arcos.isEmpty()) {
            aux = grafo.vertices.get(3).arcos.get(0).peso;
            if (grafo.vertices.get(3).arcos.get(0).peso <= aux) {
                if (!grafo.vertices.get(3).arcos.get(0).destino.visitado) {
                    proximo = grafo.vertices.get(3).arcos.get(0).destino.id;
                }

                percorre(grafo.vertices.get(3));
            }
        }
        
        if (!grafo.vertices.get(2).arcos.isEmpty()) {
            aux = grafo.vertices.get(2).arcos.get(0).peso;
            if (grafo.vertices.get(2).arcos.get(0).peso <= aux) {
                if (!grafo.vertices.get(2).arcos.get(0).destino.visitado) {
                    proximo = grafo.vertices.get(2).arcos.get(0).destino.id;
                }

                percorre(grafo.vertices.get(2));
            }
        }

        verticeComplete();
        //}
    }

    private void percorre(Vertice verticeAtual) {
        System.out.println("entrou com " + verticeAtual.rotulo);
        for (Arco arco : verticeAtual.arcos) {
            if (arco.destino.estimativa == -1) {
                if (arco.peso < aux && !arco.destino.visitado) {
                    aux = arco.peso;
                    proximo = arco.destino.id;
                    System.out.println("aux1 " + aux + "\t proximo " + proximo);
                }
                arco.destino.estimativa = arco.origem.estimativa + arco.peso;
                arco.destino.precedente = arco.origem.rotulo;
                System.out.println("colocou " + arco.destino.estimativa + " no " + arco.destino.rotulo);

            } else if (arco.destino.estimativa > (arco.peso + arco.origem.estimativa)) {
                if (arco.peso < aux && !arco.destino.visitado) {
                    aux = arco.peso;
                    proximo = arco.destino.id;
                    System.out.println("aux2 " + aux + "\t proximo " + proximo);
                }
                arco.destino.estimativa = arco.origem.estimativa + arco.peso;
                arco.destino.precedente = arco.origem.rotulo;
                System.out.println("Atualizou  " + arco.destino.estimativa + " no " + arco.destino.rotulo);
            }
        }
        verticeAtual.visitado = true;
        System.out.println("vertice " + verticeAtual.rotulo + " visitado");
        System.out.println("Menor " + aux);
        System.out.println("Proximo " + grafo.vertices.get(proximo).rotulo + "\n");
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
