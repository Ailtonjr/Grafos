package br.univali.grafos.principal;



import java.util.ArrayList;
import java.util.List;


public class Vertice {
    int id;
    String rotulo;
    boolean visitado = false;
    public List<Arco> arcos;

    public Vertice(String rotulo, int id) {
        arcos = new ArrayList<>();
        this.rotulo = rotulo;
        this.id = id;
    }
    
}
