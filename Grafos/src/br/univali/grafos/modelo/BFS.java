/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.MeuGrafo;
import br.univali.grafos.principal.Vertice;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Ailton Cardoso Jr
 */
public class BFS {

    Queue<Vertice> fila = new LinkedList();
    public String retorno = "Não Econtrado.";
    public String conexo = "Conexo";
    
    public void busca(MeuGrafo grafo, String rotulo){
        int cont = 0;
        for (Vertice vertice : grafo.vertices) {
            if(!vertice.visitado){
                cont++;
                System.out.println("--------------");
                fila.add(vertice);
                fila.element().visitado = true;
                System.out.println("elemento é: " + grafo.vertices.get(0).visitado);
                percorrer(rotulo);
                
            }
        }
        if(cont > 1){
            System.out.println("Não é conexo!");
            conexo = "Não Conexo";
        }
       // return retorno;
    }

    private void percorrer(String rotulo) {
        System.out.println("Enfileirou " + fila.element().rotulo);
        while (!fila.isEmpty()) {   
            if(!fila.element().arcos.isEmpty()){
                for (Arco arco : fila.element().arcos) {
                    if(!arco.verticeB.visitado){
                        if(arco.verticeB.rotulo.equalsIgnoreCase(rotulo)){
                            retorno = "O Vertice com o rótulo expecificado \nestá no Grafo.";
                        }
                        arco.verticeB.visitado = true;
                        fila.add(arco.verticeB);
                        System.out.println("Enfileirou " + arco.verticeB.rotulo);
                    }
                }
                System.out.println("remove " + fila.element().rotulo);
                fila.remove();
            }else{
                System.out.println("Remove 2: " + fila.element().rotulo);
                fila.element().visitado = true;
                fila.remove();
            }
            System.out.println(fila.size());
        }
        System.out.println("acabou");
    }
}
