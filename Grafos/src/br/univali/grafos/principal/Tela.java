package br.univali.grafos.principal;

import br.univali.grafos.modelo.DFS;


public class Tela extends javax.swing.JFrame {

    MeuGrafo meuGrafo = null;

    public Tela() {
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

        buttonXML = new javax.swing.JButton();
        buttonGrafo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonXML.setText("Ler Arquivo");
        buttonXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXMLActionPerformed(evt);
            }
        });

        buttonGrafo.setText("Ler Grafo");
        buttonGrafo.setEnabled(false);
        buttonGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGrafoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(303, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonXML, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonGrafo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(buttonXML)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGrafo)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXMLActionPerformed
        LeitorXml leitorXml = new LeitorXml();
        meuGrafo = (MeuGrafo) leitorXml.grafoFromXML();
        if (meuGrafo != null) {
            buttonGrafo.setEnabled(true);
        }
    }//GEN-LAST:event_buttonXMLActionPerformed

    private void buttonGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGrafoActionPerformed
        
        //meuGrafo.lerVertices();
      /* for (Vertice vertice : meuGrafo.vertices) {
            System.out.println("");
            System.out.println("------Vertice------");
            System.out.println("Rotulo: " + vertice.rotulo);
            System.out.println("ID: " + vertice.id);
            System.out.println("Visitado: " + vertice.visitado);
            System.out.println("tamanho da lista" + vertice.arcos.size());

            for (Arco arco : vertice.arcos) {
                System.out.println("");
                System.out.println("------Arco------");
                System.out.println("Vertice A: " + arco.verticeA.rotulo);
                System.out.println("Vertice B: " + arco.verticeB.rotulo);
                System.out.println("Peso: " + arco.peso);
            }
        }*/
        DFS dfs = new DFS();
        dfs.busca(meuGrafo, "");


    }//GEN-LAST:event_buttonGrafoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGrafo;
    private javax.swing.JButton buttonXML;
    // End of variables declaration//GEN-END:variables
}
