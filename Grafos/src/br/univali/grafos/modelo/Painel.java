package br.univali.grafos.modelo;

import br.univali.grafos.visao.TelaAEstrela;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Painel extends JPanel {

    private int lin;
    private int col;
    private Color corAntiga;
    JLabel label_F = new JLabel();
    JLabel label_G = new JLabel();
    JLabel label_H = new JLabel();

    private String tipo = "-";
    private int f = 0;
    private int g = 0;
    private int h = 0;

    public Painel(int row, int col) {
        this.lin = row;
        this.col = col;
        this.corAntiga = getBackground();
        this.label_F = new JLabel();
        this.label_G = new JLabel();
        this.label_H = new JLabel();
        add(label_F);
        add(label_G);
        add(label_H);
        setBorder(BorderFactory.createEtchedBorder());
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if ("Inicial".equals(TelaAEstrela.opcaoSelecionada)) {
                    setBackground(Color.GREEN);
                    setTipo("Inicial");
                } else if ("Muro".equals(TelaAEstrela.opcaoSelecionada)) {
                    setBackground(Color.GRAY);
                    setTipo("Muro");
                } else if ("Final".equals(TelaAEstrela.opcaoSelecionada)) {
                    setBackground(Color.RED);
                    setTipo("Final");
                } else if ("-".equals(TelaAEstrela.opcaoSelecionada)) {
                    setBackground(corAntiga);
                    setTipo("-");
                }
            }
        });
    }

    public int getLin() {
        return lin;
    }

    public int getCol() {
        return col;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
