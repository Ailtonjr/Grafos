

import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ailton Jr
 */
public class Vertice {
    int id;
    String rotulo;
    boolean visitado = false;
    public List<Arco> arcos;

    public Vertice(String rotulo,int id) {
        arcos = new ArrayList<>();
        this.rotulo = rotulo;
        this.id = id;
    }
    
}
