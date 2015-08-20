
package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;
import java.util.Stack;


public class DFS {
    
    Stack<Vertice> pilha = new Stack<>();
    
    public void percorrer(MeuGrafo grafo, String rotulo) {
        pilha.push(grafo.vertices.get(0));
        System.out.println("Empilhou " + pilha.lastElement());
        while (!pilha.empty()) {    
            int cont = pilha.firstElement().arcos.size();
            //System.out.println("primeiro elemento "+ pilha.firstElement().rotulo);
            
            if(!pilha.lastElement().arcos.isEmpty()){
                System.out.println("ultimo"+ pilha.lastElement().rotulo);
                for (Arco arco : pilha.firstElement().arcos) {
                    if(arco.verticeB.visitado != true && cont != 0){
                        System.out.println("cont " + cont);
                        cont--;
                        System.out.println("Empilhou " + arco.verticeB.rotulo);
                        pilha.push(arco.verticeB);
                        arco.verticeB.visitado = true;
                        break;
                    }else{
                        System.out.println("Desempilhou " + pilha.lastElement().rotulo);
                        pilha.pop();
                    }
                }
            }
            
        }
        System.out.println("fim ciclo");

    }
}
