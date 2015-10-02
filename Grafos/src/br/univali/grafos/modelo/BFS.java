
package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.Grafo;
import br.univali.grafos.principal.Vertice;
import java.util.LinkedList;
import java.util.Queue;


public class BFS {

    Queue<Vertice> fila = new LinkedList();
    public String retorno = "Não Econtrado.";
    public String conexoTexto = "Conexo";
    boolean conexao = true;

    public void busca(Grafo grafo, String rotulo) {
        int cont = 0;
        for (Vertice vertice : grafo.vertices) {
            if (!vertice.visitado) {
                cont++;
                System.out.println("--------------");
                fila.add(vertice);
                fila.element().visitado = true;
                System.out.println("elemento é: " + grafo.vertices.get(0).visitado);
                percorrer(rotulo);

            }
        }
        if (cont > 1 || verificaConexao(grafo)) {
            System.out.println("Não é conexo!");
            conexoTexto = "Não Conexo";
        }
    }

    private boolean verificaConexao(Grafo grafo) {
        int contOrigem = 0, contDestino=0;
        for (Vertice vertice : grafo.vertices) {
            for (Arco arco : grafo.todosArcos) {
                if (vertice.id == arco.origem.id) {
                    contOrigem++;
                }
                if (vertice.id == arco.destino.id) {
                    contDestino++;
                }
                
            }
            if (contOrigem == 0 || contDestino == 0) {
                System.err.println("nao é");
                return true;
            }
        }
        return false;
    }

    private void percorrer(String rotulo) {
        System.out.println("Enfileirou " + fila.element().rotulo);
        while (!fila.isEmpty()) {
            if (!fila.element().arcos.isEmpty()) {
                for (Arco arco : fila.element().arcos) {
                    if (!arco.destino.visitado) {
                        if (arco.destino.rotulo.equalsIgnoreCase(rotulo)) {
                            retorno = "O Vertice com o rótulo expecificado \nestá no Grafo.";
                        }
                        arco.destino.visitado = true;
                        fila.add(arco.destino);
                        System.out.println("Enfileirou " + arco.destino.rotulo);
                    }
                }
                System.out.println("remove " + fila.element().rotulo);
                fila.remove();
            } else {
                System.out.println("Remove 2: " + fila.element().rotulo);
                fila.element().visitado = true;
                fila.remove();
            }
            System.out.println(fila.size());
        }
        System.out.println("acabou");
    }
}
