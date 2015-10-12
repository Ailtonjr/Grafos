package br.univali.grafos.principal;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

    public List<Vertice> vertices;
    public List<Arco> todosArcos;
    public boolean dirigido;

    public Grafo() {
        this.vertices = new ArrayList<>();
        this.todosArcos = new ArrayList<>();
    }

    void adicionarVertice(String rotulo, int relId) {
        vertices.add(new Vertice(rotulo, relId));
    }

    void adicionarArco(int idVertice1, int idVertice2, double peso) {
        if (this.dirigido) {
            todosArcos.add(new Arco(vertices.get(idVertice1), vertices.get(idVertice2), peso));
            vertices.get(idVertice1).arcos.add(new Arco(vertices.get(idVertice1), vertices.get(idVertice2), peso));
        } else {
            todosArcos.add(new Arco(vertices.get(idVertice1), vertices.get(idVertice2), peso));
            vertices.get(idVertice1).arcos.add(new Arco(vertices.get(idVertice1), vertices.get(idVertice2), peso));
            
            
            todosArcos.add(new Arco(vertices.get(idVertice2), vertices.get(idVertice1), peso));
            vertices.get(idVertice2).arcos.add(new Arco(vertices.get(idVertice2), vertices.get(idVertice1), peso));
        }

    }

    void lerVertices() {
        for (Vertice vertice : vertices) {
            System.out.println("Rotulo: " + vertice.rotulo);
            System.out.println("ID: " + vertice.id);
        }
    }

}
