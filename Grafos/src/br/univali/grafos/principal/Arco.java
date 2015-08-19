package br.univali.grafos.principal;


public class Arco {
    public Vertice verticeA;
    public Vertice verticeB;
    public double peso;
    public boolean visitado = false;

    public Arco(Vertice verticeA, Vertice verticeB, double peso) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = peso;
    }
    
}
