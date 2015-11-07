/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.grafos.modelo;

/**
 *
 * @author Ailton Jr
 */
public class CaminhoAlternativo {
    public Vertice vertice;
    public Arco arcoA;
    public Arco arcoB;
    public double distanciaExcedente;

    public CaminhoAlternativo(Vertice vertice, Arco arcoA, Arco arcoB, double distanciaExcedente) {
        this.vertice = vertice;
        this.arcoA = arcoA;
        this.arcoB = arcoB;
        this.distanciaExcedente = distanciaExcedente;
    }
    
    
}
