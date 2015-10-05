package br.univali.grafos.visao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.univali.grafos.modelo.Painel;
import br.univali.grafos.modelo.AStar;
import br.univali.grafos.modelo.LeitorXML_Aestrela;
import br.univali.grafos.principal.Grafo;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 *
 * @author Ailton Cardoso Jr
 */
public class TelaAEstrela extends javax.swing.JDialog {

    private Painel[][] paineis;
    private Grafo meuGrafo = null;
    public static String opcaoSelecionada = "-";
    AStar aStar;
    

    public TelaAEstrela(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        painel_tabela = new javax.swing.JPanel();
        painel_legenda = new javax.swing.JPanel();
        painel_vermelho = new javax.swing.JPanel();
        label_fim = new javax.swing.JLabel();
        painel_verde2 = new javax.swing.JPanel();
        label_inicio = new javax.swing.JLabel();
        painel_cinza = new javax.swing.JPanel();
        label_obstaculo = new javax.swing.JLabel();
        painel_vermelho1 = new javax.swing.JPanel();
        label_fim1 = new javax.swing.JLabel();
        botao_XML = new javax.swing.JButton();
        botao_iniciar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        spinner_coluna = new javax.swing.JSpinner();
        label_x = new javax.swing.JLabel();
        spinner_linha = new javax.swing.JSpinner();
        botao_criar = new javax.swing.JButton();
        painel_x = new javax.swing.JPanel();
        painel_y = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        painel_tabela.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        painel_tabela.setLayout(new java.awt.GridLayout(1, 10));

        painel_legenda.setBorder(javax.swing.BorderFactory.createTitledBorder("Paleta"));

        painel_vermelho.setBackground(new java.awt.Color(255, 102, 102));
        painel_vermelho.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel_vermelho.setPreferredSize(new java.awt.Dimension(30, 30));
        painel_vermelho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painel_vermelhoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painel_vermelhoLayout = new javax.swing.GroupLayout(painel_vermelho);
        painel_vermelho.setLayout(painel_vermelhoLayout);
        painel_vermelhoLayout.setHorizontalGroup(
            painel_vermelhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        painel_vermelhoLayout.setVerticalGroup(
            painel_vermelhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        label_fim.setText("Fim");

        painel_verde2.setBackground(new java.awt.Color(0, 153, 51));
        painel_verde2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel_verde2.setPreferredSize(new java.awt.Dimension(30, 30));
        painel_verde2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painel_verdeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painel_verde2Layout = new javax.swing.GroupLayout(painel_verde2);
        painel_verde2.setLayout(painel_verde2Layout);
        painel_verde2Layout.setHorizontalGroup(
            painel_verde2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        painel_verde2Layout.setVerticalGroup(
            painel_verde2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        label_inicio.setText("Início");

        painel_cinza.setBackground(java.awt.Color.gray);
        painel_cinza.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel_cinza.setPreferredSize(new java.awt.Dimension(30, 30));
        painel_cinza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painel_cinzaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painel_cinzaLayout = new javax.swing.GroupLayout(painel_cinza);
        painel_cinza.setLayout(painel_cinzaLayout);
        painel_cinzaLayout.setHorizontalGroup(
            painel_cinzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        painel_cinzaLayout.setVerticalGroup(
            painel_cinzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );

        label_obstaculo.setText("Obstáculo");

        painel_vermelho1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel_vermelho1.setPreferredSize(new java.awt.Dimension(30, 30));
        painel_vermelho1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painel_vermelho1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout painel_vermelho1Layout = new javax.swing.GroupLayout(painel_vermelho1);
        painel_vermelho1.setLayout(painel_vermelho1Layout);
        painel_vermelho1Layout.setHorizontalGroup(
            painel_vermelho1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        painel_vermelho1Layout.setVerticalGroup(
            painel_vermelho1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label_fim1.setText("Normal");

        javax.swing.GroupLayout painel_legendaLayout = new javax.swing.GroupLayout(painel_legenda);
        painel_legenda.setLayout(painel_legendaLayout);
        painel_legendaLayout.setHorizontalGroup(
            painel_legendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_legendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_legendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_legendaLayout.createSequentialGroup()
                        .addComponent(painel_cinza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_obstaculo))
                    .addGroup(painel_legendaLayout.createSequentialGroup()
                        .addComponent(painel_verde2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_inicio))
                    .addGroup(painel_legendaLayout.createSequentialGroup()
                        .addComponent(painel_vermelho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_fim))
                    .addGroup(painel_legendaLayout.createSequentialGroup()
                        .addComponent(painel_vermelho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_fim1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_legendaLayout.setVerticalGroup(
            painel_legendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_legendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_legendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_verde2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_legendaLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(label_inicio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_legendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_cinza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_legendaLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(label_obstaculo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_legendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_vermelho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painel_legendaLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label_fim)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_legendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painel_vermelho1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_fim1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botao_XML.setText("xml");
        botao_XML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_XMLActionPerformed(evt);
            }
        });

        botao_iniciar.setText("Iniciar");
        botao_iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_iniciarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Matriz"));

        spinner_coluna.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(0), null, Integer.valueOf(1)));

        label_x.setText("X");

        spinner_linha.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(10), Integer.valueOf(0), null, Integer.valueOf(1)));

        botao_criar.setText("Criar");
        botao_criar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_criarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(spinner_linha, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(label_x)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinner_coluna, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botao_criar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinner_linha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinner_coluna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_x))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botao_criar)
                .addGap(7, 7, 7))
        );

        painel_x.setLayout(new java.awt.GridLayout(1, 1));

        painel_y.setLayout(new java.awt.GridLayout(0, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painel_y, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_x, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(painel_legenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botao_iniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botao_XML, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(painel_x, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(painel_y, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                            .addComponent(painel_tabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(painel_legenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botao_XML)
                            .addComponent(botao_iniciar))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao_XMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_XMLActionPerformed
        LeitorXML_Aestrela leitor = new LeitorXML_Aestrela();
        paineis = leitor.montaMatriz();
        if (leitor.getLinhas() > 0 && leitor.getColunas() > 0) {

            spinner_linha.setValue(leitor.getLinhas());
            spinner_coluna.setValue(leitor.getColunas());

            // Adiciona os paineis na tela
            addPaineisTela(leitor.getLinhas(), leitor.getColunas());
            aStar = new AStar(paineis);
            aStar.desenhaMatriz();
            painel_tabela.revalidate();
        }

    }//GEN-LAST:event_botao_XMLActionPerformed

    private void botao_iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_iniciarActionPerformed
        aStar = new AStar(paineis);
        aStar.inicia();
    }//GEN-LAST:event_botao_iniciarActionPerformed

    private void botao_criarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_criarActionPerformed
        if ((int) spinner_linha.getValue() > 0 && (int) spinner_coluna.getValue() > 0) {
            criaTabelaEmBranco((int) spinner_linha.getValue(), (int) spinner_coluna.getValue());
        }
    }//GEN-LAST:event_botao_criarActionPerformed

    private void painel_cinzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painel_cinzaMouseClicked
        opcaoSelecionada = "Muro";
    }//GEN-LAST:event_painel_cinzaMouseClicked

    private void painel_vermelhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painel_vermelhoMouseClicked
        opcaoSelecionada = "Final";
    }//GEN-LAST:event_painel_vermelhoMouseClicked

    private void painel_vermelho1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painel_vermelho1MouseClicked
        opcaoSelecionada = "-";
    }//GEN-LAST:event_painel_vermelho1MouseClicked

    private void painel_verdeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painel_verdeMouseClicked
        opcaoSelecionada = "Inicial";
    }//GEN-LAST:event_painel_verdeMouseClicked

    private void addPaineisTela(int linha, int coluna) {
        painel_tabela.removeAll();
        painel_x.removeAll();
        painel_y.removeAll();
        painel_tabela.setLayout(new GridLayout(linha, coluna));

        // Adiciona indices para o eixo y
        for (int lin = 0; lin < linha; lin++) {
            painel_y.add(new JLabel("" + lin));
        }

        // Adiciona indices para o eixo x
        for (int col = 0; col < coluna; col++) {
            painel_x.add(new JLabel("    " + col));
        }

        // Adiciona os paineis na tela
        for (int lin = 0; lin < linha; lin++) {
            for (int col = 0; col < coluna; col++) {
                painel_tabela.add(paineis[lin][col]);
            }
        }
        painel_tabela.revalidate();
    }

    private void criaTabelaEmBranco(int linhas, int colunas) {
        // if (paineis == null) {
        paineis = new Painel[linhas][colunas];

        for (int lin = 0; lin < linhas; lin++) {
            for (int col = 0; col < colunas; col++) {
                if (paineis[lin][col] == null) {
                    paineis[lin][col] = new Painel(lin, col);
                }
            }
        }
        addPaineisTela(linhas, colunas);
    }

    public static void main(String args[]) {

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaAEstrela dialog = new TelaAEstrela(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botao_XML;
    private javax.swing.JButton botao_criar;
    private javax.swing.JButton botao_iniciar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_fim;
    private javax.swing.JLabel label_fim1;
    private javax.swing.JLabel label_inicio;
    private javax.swing.JLabel label_obstaculo;
    private javax.swing.JLabel label_x;
    private javax.swing.JPanel painel_cinza;
    private javax.swing.JPanel painel_legenda;
    private javax.swing.JPanel painel_tabela;
    private javax.swing.JPanel painel_verde2;
    private javax.swing.JPanel painel_vermelho;
    private javax.swing.JPanel painel_vermelho1;
    private javax.swing.JPanel painel_x;
    private javax.swing.JPanel painel_y;
    private javax.swing.JSpinner spinner_coluna;
    private javax.swing.JSpinner spinner_linha;
    // End of variables declaration//GEN-END:variables

}
