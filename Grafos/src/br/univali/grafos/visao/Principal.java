package br.univali.grafos.visao;

import br.univali.grafos.modelo.BFS;
import br.univali.grafos.modelo.DFS;
import br.univali.grafos.modelo.Dijkstra;
import br.univali.grafos.principal.LeitorXml;
import br.univali.grafos.principal.MeuGrafo;

public class Principal extends javax.swing.JFrame {

    MeuGrafo meuGrafo = null;
    MeuGrafo backupGrafo = null;

    public Principal() {
        initComponents();
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

        button_Coloracao.setText("Coloração");
        button_Coloracao.setPreferredSize(new java.awt.Dimension(60, 40));

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
                .addComponent(button_Coloracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_BFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_BFSActionPerformed
        TelaBFS telaBfs = new TelaBFS(this, false);
        telaBfs.setVisible(true); //Chama a dialog  
        telaBfs = null; //Deixa o garbage collector agir  
    }//GEN-LAST:event_button_BFSActionPerformed

    private void button_DFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DFSActionPerformed
        TelaDFS telaDfs = new TelaDFS(this, false);
        telaDfs.setVisible(true); //Chama a dialog  
        telaDfs = null; //Deixa o garbage collector agir  
    }//GEN-LAST:event_button_DFSActionPerformed

    private void button_DijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_DijkstraActionPerformed
        TelaDijkstra telaDijkstra = new TelaDijkstra(this, false);
        telaDijkstra.setVisible(true); //Chama a dialog  
        telaDijkstra = null; //Deixa o garbage collector agir
    }//GEN-LAST:event_button_DijkstraActionPerformed

    private void button_AActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AActionPerformed
        TelaAEstrela telaAEstrela  = new TelaAEstrela(this, false);
        telaAEstrela.setVisible(true); //Chama a dialog  
        telaAEstrela = null; //Deixa o garbage collector agir
    }//GEN-LAST:event_button_AActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_A;
    private javax.swing.JButton button_BFS;
    private javax.swing.JButton button_Coloracao;
    private javax.swing.JButton button_DFS;
    private javax.swing.JButton button_Dijkstra;
    private javax.swing.JButton button_Planaridade;
    // End of variables declaration//GEN-END:variables
}