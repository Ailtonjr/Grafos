package br.univali.grafos.principal;


public class Arco {
    public Vertice origem;
    public Vertice destino;
    public double peso;
    public boolean visitado = false;

    public Arco(Vertice origem, Vertice destino, double peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }
    
}
