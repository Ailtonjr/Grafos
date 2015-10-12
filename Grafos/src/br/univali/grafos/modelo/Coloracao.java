package br.univali.grafos.modelo;

import br.univali.grafos.principal.Arco;
import br.univali.grafos.principal.Grafo;
import br.univali.grafos.principal.Vertice;
import javax.swing.JOptionPane;

public class Coloracao {

    Vertice prox = new Vertice(null, -1);

    public Coloracao(Grafo grafo) {
        if (grafo != null) {
            for (Vertice vertice : grafo.vertices) {
                if (vertice.arcos.size() > prox.arcos.size()) {
                    prox = vertice;
                }
            }
            System.out.println("Inicial: " + prox.rotulo);
            prox.cor = 1;
//            proxCor(prox.arcos.get(0).destino);
//            proxCor(grafo.vertices.get(2));
//            proxCor(grafo.vertices.get(3));
//            proxCor(grafo.vertices.get(4));
//            proxCor(grafo.vertices.get(5));

            for (int i = 0; i < grafo.vertices.size(); i++) {
                int contMaior = 0;
                int id = 0;
                for (Vertice vertice : grafo.vertices) {
                    int cont = 0;
                    for (Arco arco : vertice.arcos) {
                        if (arco.destino.cor > 0) {
                            cont++;
                        }
                        if (cont > contMaior && !vertice.visitado) {
                            contMaior = cont;
                            id = vertice.id;
                        }
                    }
                }
                proxCor(grafo.vertices.get(id));
            }
            int qtdCor = 0;
            for (Vertice vertice : grafo.vertices) {
                if(vertice.cor > qtdCor){
                    qtdCor = vertice.cor;
                }
                System.out.println("Vertice: " + vertice.rotulo + " Cor: " + vertice.cor);
            }
            JOptionPane.showMessageDialog(null, "      O número cromático dos vértices  é: " + qtdCor + "      \n");
        }
    }

    public void proxCor(Vertice vertice) {
        int cor = 0;
        boolean termina = true;
        while (termina) {
            int cont = 0;
            cor++;
            for (Arco arco : vertice.arcos) {
                if (arco.destino.cor == cor) {
                    cont++;
                }
            }
            if (cont == 0) {
                termina = false;
            }
        }
        vertice.cor = cor;
        vertice.visitado = true;
    }
}
