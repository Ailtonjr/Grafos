
package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;
import java.util.ArrayList;
import java.util.List;


public class Dijkstra {

    int proximo = 0;
    double menor = 9223372036854775807L;
    List<String> caminho = new ArrayList();

    MeuGrafo grafo;

    public void busca(MeuGrafo grafo, String rotuloInicial, String rotuloBusca) {
        this.grafo = grafo;
        for (Vertice vertice : grafo.vertices) {
            if (vertice.rotulo.equalsIgnoreCase(rotuloInicial)) {
                int inicial = vertice.id;
                grafo.vertices.get(inicial).estimativa = 0;
                grafo.vertices.get(inicial).precedente = grafo.vertices.get(inicial).rotulo;
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
        
        
        // Caminho
        Vertice verticeAux = null;
        double custo = 0;
        for (Vertice vertice : grafo.vertices) {    // Procura a instancia do vertice de busca
            if (vertice.rotulo.equalsIgnoreCase(rotuloBusca)) {
                verticeAux = vertice;
                custo = verticeAux.estimativa;
                break;
            }
        }
        
        while(!verticeAux.rotulo.equalsIgnoreCase(rotuloInicial)) {
            caminho.add(verticeAux.rotulo);
            
            for (int i = 0; i < grafo.vertices.size(); i++) {
                if (grafo.vertices.get(i).rotulo.equalsIgnoreCase(verticeAux.precedente)) {
                    verticeAux = grafo.vertices.get(i);
                    break;
                }
            }
        }
        caminho.add(rotuloInicial);
        
        System.out.print("--------------------------------------------------------------------\nCaminho:\t");
        
        for (int i = caminho.size() - 1; i >= 0; i--) {
            System.out.print(caminho.get(i) + "\t");
        }
        // Custo
        System.out.println("\nCusto:\t" + custo);
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
