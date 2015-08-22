package br.univali.grafos.principal;

import java.util.ArrayList;
import java.util.List;


public class MeuGrafo {
    
    public List<Vertice> vertices;
    public List<Arco> todosArcos;
    
    public MeuGrafo(){
        this.vertices = new ArrayList<>();
        this.todosArcos = new ArrayList<>();
    }

    void adicionarVertice(String rotulo, int relId) {
        vertices.add(new Vertice(rotulo,relId));
    }

    void adicionarArco(int idVertice1, int idVertice2, double peso) {
        todosArcos.add(new Arco(vertices.get(idVertice1), vertices.get(idVertice2), peso));
        vertices.get(idVertice1).arcos.add(new Arco(vertices.get(idVertice1), vertices.get(idVertice2), peso));
    }
    
    void lerVertices(){
        for (Vertice vertice : vertices) {
            System.out.println("Rotulo: " + vertice.rotulo);
            System.out.println("ID: " + vertice.id);
        }
    }
    
    
}
