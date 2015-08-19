package br.univali.grafos.principal;


public class Arco {
    int verticeA;
    public int verticeB;
    double peso;
    boolean visitado = false;

    public Arco(int verticeA, int verticeB, double peso) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = peso;
    }
    
}
