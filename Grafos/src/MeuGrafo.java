

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 5108250
 */   



public class MeuGrafo {
    
    List<Vertice> vertices;
    
    public MeuGrafo(){
        this.vertices = new ArrayList<>();
    }

    void adicionarVertice(String rotulo, int relId) {
        vertices.add(new Vertice(rotulo,relId));
    }

    void adicionarArco(int idVertice1, int idVertice2, double peso) {
        vertices.get(idVertice1).arcos.add(new Arco(idVertice1, idVertice2, peso));
    }
    
    void lerVertices(){
        for (Vertice vertice : vertices) {
            System.out.println("Rotulo: " + vertice.rotulo);
            System.out.println("ID: " + vertice.id);
        }
    }
    
    
}
