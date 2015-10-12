package br.univali.grafos.principal;



import java.util.ArrayList;
import java.util.List;


public class Vertice {
    public int id;
    public int cor;
    public String rotulo;
    public boolean visitado = false;
    public List<Arco> arcos;
    public String precedente = "-";
    public double estimativa = (-1);

    public Vertice(String rotulo, int id) {
        arcos = new ArrayList<>();
        this.rotulo = rotulo;
        this.id = id;
    }
    
    
    public int getGrau() {
        return arcos.size();
    }
    
}
