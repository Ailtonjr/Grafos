package br.univali.grafos.principal;

import br.univali.grafos.modelo.BFS;
import br.univali.grafos.modelo.DFS;

public class Tela extends javax.swing.JFrame {

    MeuGrafo meuGrafo = null;
    MeuGrafo backupGrafo = null;

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
        buttonDFS = new javax.swing.JButton();
        buttonBFS = new javax.swing.JButton();
        textField_rotulo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        conexo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho de Grafos");
        setResizable(false);

        buttonXML.setText("Arquivo");
        buttonXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXMLActionPerformed(evt);
            }
        });

        buttonDFS.setText("DFS");
        buttonDFS.setEnabled(false);
        buttonDFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDFSActionPerformed(evt);
            }
        });

        buttonBFS.setText("BFS");
        buttonBFS.setEnabled(false);
        buttonBFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBFSActionPerformed(evt);
            }
        });

        textField_rotulo.setEnabled(false);
        textField_rotulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_rotuloActionPerformed(evt);
            }
        });

        jLabel1.setText("Digite o rotulo a ser buscado");

        texto.setEditable(false);
        texto.setColumns(20);
        texto.setRows(5);
        texto.setText(" ");
        jScrollPane1.setViewportView(texto);

        jLabel2.setText("Caminho");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(conexo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonXML))
                            .addComponent(textField_rotulo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonDFS, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(buttonBFS, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(buttonXML)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addComponent(textField_rotulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDFS)
                    .addComponent(buttonBFS))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(conexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXMLActionPerformed
        LeitorXml leitorXml = new LeitorXml();
        meuGrafo = (MeuGrafo) leitorXml.grafoFromXML();
        if (meuGrafo != null) {
            buttonDFS.setEnabled(true);
            buttonBFS.setEnabled(true);
            textField_rotulo.setEnabled(true);
            texto.setText("");
            conexo.setText("");
        }
    }//GEN-LAST:event_buttonXMLActionPerformed


    private void buttonDFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDFSActionPerformed
        DFS dfs = new DFS();
        dfs.busca(meuGrafo, textField_rotulo.getText());
        buttonDFS.setEnabled(false);
        buttonBFS.setEnabled(false);
        textField_rotulo.setEnabled(false);
        textField_rotulo.setText("");
        texto.setText(dfs.retorno);
        conexo.setText(dfs.conexo);
    }//GEN-LAST:event_buttonDFSActionPerformed

    private void buttonBFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBFSActionPerformed
        BFS bfs = new BFS();
        bfs.busca(meuGrafo, textField_rotulo.getText());
        buttonDFS.setEnabled(false);
        buttonBFS.setEnabled(false);
        textField_rotulo.setEnabled(false);
        textField_rotulo.setText("");
        texto.setText(bfs.retorno);
        conexo.setText(bfs.conexo);
    }//GEN-LAST:event_buttonBFSActionPerformed

    private void textField_rotuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_rotuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_rotuloActionPerformed

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
    private javax.swing.JButton buttonBFS;
    private javax.swing.JButton buttonDFS;
    private javax.swing.JButton buttonXML;
    private javax.swing.JLabel conexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textField_rotulo;
    public static javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
