package br.univali.grafos.principal;



import java.util.ArrayList;
import java.util.List;


public class Vertice {
    public int id;
    public String rotulo;
    public boolean visitado = false;
    public List<Arco> arcos;
    public String precedente = "-";
    public int estimativa;

    public Vertice(String rotulo, int id) {
        arcos = new ArrayList<>();
        this.rotulo = rotulo;
        this.id = id;
    }
    
}
