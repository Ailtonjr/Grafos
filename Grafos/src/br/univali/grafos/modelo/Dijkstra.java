package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.Grafo;
import br.univali.grafos.principal.Vertice;
import br.univali.grafos.visao.TelaDijkstra;

public class Dijkstra {

    int proximo = 0;
    double menor = 9223372036854775807L;
    int inicial = 0;
    Grafo grafo;
 
    public void busca(Grafo grafo, String rotuloInicial) {
        this.grafo = grafo;
        for (Vertice vertice : grafo.vertices) {
            if (vertice.rotulo.equalsIgnoreCase(rotuloInicial)) {
                inicial = vertice.id;
                break;
            }
        }

        grafo.vertices.get(inicial).estimativa = 0;
        grafo.vertices.get(inicial).precedente = grafo.vertices.get(inicial).rotulo;
        percorre(grafo.vertices.get(inicial));


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
        String result = "";

        for (Vertice vertice : grafo.vertices) {
            if (vertice.visitado) {
                cont++;
            }
        }
        if (cont == grafo.vertices.size()) {
            System.out.println("\n\n---------------------------- Resultados ----------------------------\n");
            result += "Vertice:";
            System.out.print("Vertice:");
            for (Vertice vertice : grafo.vertices) {
                System.out.print("\t " + vertice.rotulo);
                result += "\t " + vertice.rotulo;
            }
            result += "\n\nEstimativa:";
            System.out.print("\n\nEstimativa:");
            for (Vertice vertice : grafo.vertices) {
                System.out.print("\t" + vertice.estimativa);
                result += "\t" + vertice.estimativa;
            }
            result += "\n\nPrecedente:";
            System.out.print("\n\nPrecedente:");
            for (Vertice vertice : grafo.vertices) {
                System.out.print("\t " + vertice.precedente);
                result += "\t " + vertice.precedente;
            }
            TelaDijkstra.texto.setText(result);
            System.out.println("\n");
            return true;
        }
        return false;
    }

}
