
package br.univali.grafos.visao;

import br.univali.grafos.controle.Dijkstra;
import br.univali.grafos.controle.LeitorXml;
import br.univali.grafos.modelo.Grafo;


public class TelaDijkstra extends javax.swing.JDialog {

    Grafo meuGrafo = null;
    Grafo backupGrafo = null;
    
    public TelaDijkstra(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Dijkstra");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonXML = new javax.swing.JButton();
        buttonDijkstra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        label_caminho = new javax.swing.JLabel();
        textField_rotuloInicial = new javax.swing.JTextField();
        label_rotuloInicial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonXML.setText("Arquivo");
        buttonXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonXMLActionPerformed(evt);
            }
        });

        buttonDijkstra.setText("Dijkstra");
        buttonDijkstra.setEnabled(false);
        buttonDijkstra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDijkstraActionPerformed(evt);
            }
        });

        texto.setEditable(false);
        texto.setColumns(20);
        texto.setRows(5);
        texto.setText(" ");
        jScrollPane1.setViewportView(texto);

        label_caminho.setText("Resultado");

        textField_rotuloInicial.setEnabled(false);

        label_rotuloInicial.setText("Rotulo Inicial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 349, Short.MAX_VALUE)
                                .addComponent(buttonXML))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(textField_rotuloInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonDijkstra, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_rotuloInicial)
                            .addComponent(label_caminho))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(buttonXML)
                .addGap(18, 18, 18)
                .addComponent(label_rotuloInicial)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField_rotuloInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDijkstra))
                .addGap(30, 30, 30)
                .addComponent(label_caminho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonXMLActionPerformed
        LeitorXml leitorXml = new LeitorXml();
        meuGrafo = (Grafo) leitorXml.grafoFromXML();
        if (meuGrafo != null) {
            buttonDijkstra.setEnabled(true);
            textField_rotuloInicial.setEnabled(true);
            texto.setText("");
        }
        buttonXML.transferFocus();
    }//GEN-LAST:event_buttonXMLActionPerformed

    private void buttonDijkstraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDijkstraActionPerformed
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.busca(meuGrafo, textField_rotuloInicial.getText());
        buttonDijkstra.setEnabled(false);
        textField_rotuloInicial.setEnabled(false);
    }//GEN-LAST:event_buttonDijkstraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaDijkstra dialog = new TelaDijkstra(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonDijkstra;
    private javax.swing.JButton buttonXML;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_caminho;
    private javax.swing.JLabel label_rotuloInicial;
    private javax.swing.JTextField textField_rotuloInicial;
    public static javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
