package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;
import java.util.Stack;

public class DFS {

    Stack<Vertice> pilha = new Stack<>();

    public void percorrer(MeuGrafo grafo, String rotulo) {
        pilha.push(grafo.vertices.get(0));
        pilha.lastElement().visitado = true;
        System.out.println("Empilhou " + pilha.lastElement().rotulo);
        while (!pilha.empty()) {
            int cont = pilha.lastElement().arcos.size();
            if (!pilha.lastElement().arcos.isEmpty()) {
                for (Arco arco : pilha.lastElement().arcos) {
                    if (!arco.verticeB.visitado && cont != 0) {
                        System.out.println("cont " + cont);
                        cont--;
                        System.out.println("Empilhou " + arco.verticeB.rotulo);
                        pilha.push(arco.verticeB);
                        arco.verticeB.visitado = true;
                        break;
                    } else {
                        System.out.println("Desempilhou " + pilha.lastElement().rotulo);
                        pilha.pop();
                    }
                }
            } else {
                System.out.println("Desempilhou2 " + pilha.lastElement().rotulo);
                pilha.pop();
            }
        }
        System.out.println("fim ciclo");
    }
}
