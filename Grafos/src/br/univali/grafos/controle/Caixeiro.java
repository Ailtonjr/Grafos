package br.univali.grafos.controle;

import br.univali.grafos.modelo.Arco;
import br.univali.grafos.modelo.CaminhoAlternativo;
import br.univali.grafos.modelo.CicloCaixeiro;
import br.univali.grafos.modelo.Grafo;
import br.univali.grafos.modelo.Vertice;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Caixeiro {

    private double menor = Double.MAX_VALUE;
    private Grafo grafo;
    private List<CicloCaixeiro> ciclo = new ArrayList();
    List<CaminhoAlternativo> lista = new ArrayList<>();
    int cont = 0;

    public Caixeiro(Grafo grafo) {
        this.grafo = grafo;
        encontraMenor();
        while (cont < grafo.vertices.size()) {
            lista.clear();
            for (CicloCaixeiro c : ciclo) {
                testaSubciclo(c.arco.origem, c.arco.peso, c.arco.destino);
            }
            menor = Double.MAX_VALUE;
            CaminhoAlternativo menorAlternativo = null;

            for (CaminhoAlternativo l : lista) {
                if (l.distanciaExcedente < menor) {
                    menor = l.distanciaExcedente;
                    menorAlternativo = l;
                }
            }

            for (int i = 0; i < ciclo.size(); i++) {
                if (ciclo.get(i).vertice.rotulo.equalsIgnoreCase(menorAlternativo.arcoA.origem.rotulo)) {
                    menorAlternativo.vertice.visitado = true;
                    cont++;
                    ciclo.get(i).arco = menorAlternativo.arcoA;
                    ciclo.add(i + 1, new CicloCaixeiro(menorAlternativo.vertice, menorAlternativo.arcoB));
                    break;
                }
            }
        }
        exibeCircuito();
    }

    public void encontraMenor() {
        Vertice verticeInicial = null;
        Vertice verticeDestino = null;
        Vertice aux = null;
        double[] idaVolta = new double[2];
        double x = 0;
        double y = 0;

        for (Vertice vertice : grafo.vertices) {
            for (Arco arco : vertice.arcos) {
                x = arco.peso;
                for (Arco arcoDestino : arco.destino.arcos) {
                    if (arcoDestino.destino.rotulo.equalsIgnoreCase(vertice.rotulo)) {
                        y = arcoDestino.peso;
                        aux = arcoDestino.origem;
                        break;
                    }
                }
                if ((x + y) < menor) {
                    menor = x + y;
                    idaVolta[0] = x;
                    idaVolta[1] = y;
                    verticeInicial = vertice;
                    verticeDestino = aux;
                }
            }
        }
        verticeInicial.visitado = true;
        verticeDestino.visitado = true;
        cont = 2;
        ciclo.add(new CicloCaixeiro(verticeInicial, new Arco(verticeInicial, verticeDestino, idaVolta[0])));
        ciclo.add(new CicloCaixeiro(verticeDestino, new Arco(verticeDestino, verticeInicial, idaVolta[1])));
        System.out.println("Menor: " + menor + "\t" + verticeInicial.rotulo + verticeDestino.rotulo);
    }

    public void testaSubciclo(Vertice a, double distancia, Vertice b) {
        for (Arco arco : a.arcos) {
            for (Arco arcoDestino : arco.destino.arcos) {
                if (arcoDestino.destino.rotulo.equals(b.rotulo) && arco.destino.visitado == false) {
                    lista.add(new CaminhoAlternativo(arco.destino, arco, arcoDestino, (arco.peso + arcoDestino.peso - distancia)));
                }
            }
        }
        System.out.println("");
    }

    public void exibeCircuito() {
        double total = 0;
        String caminho = "";
        for (CicloCaixeiro c : ciclo) {
            total += c.arco.peso;
            caminho += (c.vertice.rotulo + " -> ");
            System.out.print(c.vertice.rotulo + "\t");
        }
        caminho += ciclo.get(0).vertice.rotulo + "\n\nTotal Percorrido: " + total;
        System.out.println(ciclo.get(0).vertice.rotulo + "\n\nTotal Percorrido: " + total);
        
        JOptionPane.showMessageDialog(null, caminho);
        
    }
}
