
package br.univali.grafos.visao;

import br.univali.grafos.modelo.BFS;
import br.univali.grafos.principal.LeitorXml;
import br.univali.grafos.principal.MeuGrafo;


public class TelaBFS extends javax.swing.JDialog {

    MeuGrafo meuGrafo = null;
    MeuGrafo backupGrafo = null;
    
    public TelaBFS(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("BFS - Breadth-first search");
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
        buttonBFS = new javax.swing.JButton();
        textField_rotuloBusca = new javax.swing.JTextField();
        label_rotuloBusca = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        label_caminho = new javax.swing.JLabel();
        label_conexo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonXML.setText("Arquivo");
        buttonXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXMLActionPerformed(evt);
            }
        });

        buttonBFS.setText("BFS");
        buttonBFS.setEnabled(false);
        buttonBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBFSActionPerformed(evt);
            }
        });

        textField_rotuloBusca.setEnabled(false);
        textField_rotuloBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_rotuloBuscaActionPerformed(evt);
            }
        });

        label_rotuloBusca.setText("Digite o rotulo a ser buscado");

        texto.setEditable(false);
        texto.setColumns(20);
        texto.setRows(5);
        texto.setText(" ");
        jScrollPane1.setViewportView(texto);

        label_caminho.setText("Caminho");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_rotuloBusca)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_caminho)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(label_conexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(84, 84, 84))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(textField_rotuloBusca)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(buttonXML)
                                    .addComponent(buttonBFS, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(buttonXML)
                .addGap(18, 18, 18)
                .addComponent(label_rotuloBusca)
                .addGap(9, 9, 9)
                .addComponent(textField_rotuloBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonBFS)
                .addGap(18, 18, 18)
                .addComponent(label_caminho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_conexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXMLActionPerformed
        LeitorXml leitorXml = new LeitorXml();
        meuGrafo = (MeuGrafo) leitorXml.grafoFromXML();
        if (meuGrafo != null) {
            buttonBFS.setEnabled(true);
            textField_rotuloBusca.setEnabled(true);
            texto.setText("");
            label_conexo.setText("");
        }
        buttonXML.transferFocus();
    }//GEN-LAST:event_buttonXMLActionPerformed

    private void buttonBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBFSActionPerformed
        BFS bfs = new BFS();
        bfs.busca(meuGrafo, textField_rotuloBusca.getText());
        buttonBFS.setEnabled(false);
        textField_rotuloBusca.setEnabled(false);
        textField_rotuloBusca.setText("");
        texto.setText(bfs.retorno);
        label_conexo.setText(bfs.conexoTexto);
    }//GEN-LAST:event_buttonBFSActionPerformed

    private void textField_rotuloBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_rotuloBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_rotuloBuscaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaBFS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBFS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBFS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBFS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaBFS dialog = new TelaBFS(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBFS;
    private javax.swing.JButton buttonXML;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_caminho;
    private javax.swing.JLabel label_conexo;
    private javax.swing.JLabel label_rotuloBusca;
    private javax.swing.JTextField textField_rotuloBusca;
    public static javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
