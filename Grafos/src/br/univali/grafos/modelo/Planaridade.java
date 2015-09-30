
package br.univali.grafos.modelo;

import br.univali.grafos.principal.MeuGrafo;


public class Planaridade {

    public Planaridade(MeuGrafo grafo) {
        int qtdVertices = grafo.vertices.size();
        int qtdArestas = grafo.todosArcos.size();
        int qtdFaces = qtdArestas - qtdVertices + 2;
        
        System.out.println("Arcos: " + qtdArestas + "\tVertices: " + qtdVertices);
        System.out.println("R = " + qtdArestas + " - " + qtdVertices + " + 2");
        System.out.println("Faces: " + qtdFaces);
        
        if (qtdVertices >= 3) {
            if (qtdArestas <= (3*qtdVertices) - 6) { // E <= 3*v - 6
                if (!cicloDeTres()) {   // Se nao houver ciclos de comprimento 3
                    if (qtdArestas <= 2*qtdVertices - 4) {
                        System.out.println("O grafo E PLANAR!");
                    } else {
                        System.out.println("O grafo NAO e planar!");
                    }
                } else {
                    System.out.println("O grafo NAO e planar!");
                }
                
            } else {
                System.out.println("O grafo NAO e planar!");
            }
        } else {    // So tem dois ou menos vertices, logo e planar.
            System.out.println("O grafo E PLANAR");
        }
    }
    
    
    public boolean cicloDeTres() {
        // TO DO: Verificar ciclo de comprimento tres
        return true;
    }
    
    
}
