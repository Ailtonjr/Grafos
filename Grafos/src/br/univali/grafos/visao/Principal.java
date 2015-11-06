/*
 UNIVALI - Departamento de Ciência da Computação
 Escrito pelos acadêmicos    Ailton Cardoso Júnior
 João Felipe Gonçalves

 Esta classe descreve a tela inicial do sistema.
 */
package br.univali.grafos.visao;

import br.univali.grafos.controle.Caixeiro;
import br.univali.grafos.controle.Coloracao;
import br.univali.grafos.controle.Planaridade;
import br.univali.grafos.modelo.Grafo;
import br.univali.grafos.controle.LeitorXml;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal extends javax.swing.JFrame {

    Grafo grafo = null;
    Grafo backupGrafo = null;

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button_BFS = new javax.swing.JButton();
        button_DFS = new javax.swing.JButton();
        button_Dijkstra = new javax.swing.JButton();
        button_A = new javax.swing.JButton();
        button_Planaridade = new javax.swing.JButton();
        button_Coloracao = new javax.swing.JButton();
        button_Coloracao1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho de Grafos");
        setResizable(false);

        button_BFS.setText("BFS");
        button_BFS.setMaximumSize(new java.awt.Dimension(60, 40));
        button_BFS.setMinimumSize(new java.awt.Dimension(60, 40));
        button_BFS.setPreferredSize(new java.awt.Dimension(60, 40));
        button_BFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_BFSActionPerformed(evt);
            }
        });

        button_DFS.setText("DFS");
        button_DFS.setPreferredSize(new java.awt.Dimension(60, 40));
        button_DFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DFSActionPerformed(evt);
            }
        });

        button_Dijkstra.setText("Dijkstra");
        button_Dijkstra.setPreferredSize(new java.awt.Dimension(60, 40));
        button_Dijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_DijkstraActionPerformed(evt);
            }
        });

        button_A.setText("A*");
        button_A.setPreferredSize(new java.awt.Dimension(60, 40));
        button_A.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_AActionPerformed(evt);
            }
        });

        button_Planaridade.setText("Planaridade");
        button_Planaridade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_PlanaridadeActionPerformed(evt);
            }
        });

        button_Coloracao.setText("Coloração");
        button_Coloracao.setPreferredSize(new java.awt.Dimension(60, 40));
        button_Coloracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ColoracaoActionPerformed(evt);
            }
        });

        button_Coloracao1.setText("Caixeiro");
        button_Coloracao1.setPreferredSize(new java.awt.Dimension(60, 40));
        button_Coloracao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_Coloracao1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button_BFS, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(button_DFS, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(button_Dijkstra, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(button_A, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(button_Planaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(button_Coloracao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(button_Coloracao1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(button_BFS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_DFS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_Dijkstra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_Planaridade, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_Coloracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(button_Coloracao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_BFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_BFSActionPerformed
        TelaBFS telaBfs = new TelaBFS(this, false);
        telaBfs.setVisible(true);                                               //Chama a dialog  
        telaBfs = null;                                                         //Deixa o garbage collector agir  
    }//GEN-LAST:event_button_BFSActionPerformed

    private void button_DFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DFSActionPerformed
        TelaDFS telaDfs = new TelaDFS(this, false);
        telaDfs.setVisible(true);                                               //Chama a dialog  
        telaDfs = null;                                                         //Deixa o garbage collector agir  
    }//GEN-LAST:event_button_DFSActionPerformed

    private void button_DijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DijkstraActionPerformed
        TelaDijkstra telaDijkstra = new TelaDijkstra(this, false);
        telaDijkstra.setVisible(true);                                          //Chama a dialog  
        telaDijkstra = null;                                                    //Deixa o garbage collector agir
    }//GEN-LAST:event_button_DijkstraActionPerformed

    private void button_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AActionPerformed
        TelaAEstrela telaAEstrela = new TelaAEstrela(this, false);
        telaAEstrela.setVisible(true);                                          //Chama a dialog  
        telaAEstrela = null;                                                    //Deixa o garbage collector agir
    }//GEN-LAST:event_button_AActionPerformed

    private void button_PlanaridadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_PlanaridadeActionPerformed
        LeitorXml leitorXml = new LeitorXml();
        grafo = (Grafo) leitorXml.grafoFromXML();
        Planaridade planaridade = new Planaridade(grafo);
    }//GEN-LAST:event_button_PlanaridadeActionPerformed

    private void button_ColoracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ColoracaoActionPerformed
        LeitorXml leitorXml = new LeitorXml();
        grafo = (Grafo) leitorXml.grafoFromXML();
        Coloracao coloracao = new Coloracao(grafo);
    }//GEN-LAST:event_button_ColoracaoActionPerformed

    private void button_Coloracao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_Coloracao1ActionPerformed
        LeitorXml leitorXml = new LeitorXml();
        grafo = (Grafo) leitorXml.grafoFromXML();
        Caixeiro caixeiro = new Caixeiro(grafo);
    }//GEN-LAST:event_button_Coloracao1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_A;
    private javax.swing.JButton button_BFS;
    private javax.swing.JButton button_Coloracao;
    private javax.swing.JButton button_Coloracao1;
    private javax.swing.JButton button_DFS;
    private javax.swing.JButton button_Dijkstra;
    private javax.swing.JButton button_Planaridade;
    // End of variables declaration//GEN-END:variables
}
