package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;
import java.util.Stack;

public class DFS {

    Stack<Vertice> pilha = new Stack<>();

    public void busca(MeuGrafo grafo, String rotulo){
        int cont = 0;
        for (Vertice vertice : grafo.vertices) {
            if(!vertice.visitado){
                cont++;
                System.out.println("--------------");
                pilha.push(vertice);
                pilha.lastElement().visitado = true;
                percorrer(rotulo);
            }
        }
        if(cont > 1){
            System.out.println("Não é conexo!");
        }
    }
    public void percorrer(String rotulo) {
        System.out.println("Empilhou " + pilha.lastElement().rotulo);
        while (!pilha.empty()) {
            if (!pilha.lastElement().arcos.isEmpty()) {
                for (Arco arco : pilha.lastElement().arcos) {
                    if (!arco.verticeB.visitado) {
                        System.out.println("Empilhou " + arco.verticeB.rotulo);
                        pilha.push(arco.verticeB);
                        arco.verticeB.visitado = true;
                        break;
                    } else {
                        int cont = 0;
                        if (pilha.size() > 0) {
                            cont = pilha.lastElement().arcos.size();
                            for (Arco arco1 : pilha.lastElement().arcos) {
                                if (arco1.verticeB.visitado) {
                                    cont--;
                                    if (cont == 0) {
                                        System.out.println("Desempilhou " + pilha.lastElement().rotulo);
                                        pilha.pop();
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("Desempilhou2 " + pilha.lastElement().rotulo);
                pilha.pop();
            }
        }
        System.out.println("fim do 1º ciclo");
    }
}
