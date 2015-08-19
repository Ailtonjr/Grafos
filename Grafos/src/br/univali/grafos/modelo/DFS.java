
package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;
import java.util.Stack;


public class DFS {
    
    Stack<Vertice> pilha = new Stack<>();
    
    public void percorrer(MeuGrafo grafo, String rotulo) {
        pilha.push(grafo.vertices.get(0));
        System.out.println("Empilhou" + grafo.vertices.get(0).rotulo );
        while (!pilha.empty()) {    
            int cont = pilha.firstElement().arcos.size();

            if(!pilha.firstElement().arcos.isEmpty()){
                for (Arco arco : pilha.firstElement().arcos) {
                    if(arco.verticeB.visitado != true && cont != 0){
                        System.out.println("cont " + cont);
                        cont--;
                        System.out.println("Empilhou " + arco.verticeB.rotulo);
                        arco.verticeB.visitado = true;
                        pilha.push(arco.verticeB);
                        break;
                    }else{
                        System.out.println("Desempilhou " + pilha.firstElement().rotulo);
                        pilha.pop();
                    }
                }
            }else{
                System.out.println("fim ciclo");
                break;
            }
        }
    }
}
