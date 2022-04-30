/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Projeto.IntegradorII.View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author felip
 */
public class VisualizarProdutos extends javax.swing.JPanel {

    /**
     * Creates new form VisualizarProdutos
     */
    public VisualizarProdutos() {
        initComponents();
    }
    
    public class tabel extends javax.swing.JFrame{
        public tabel (){
            initComponents();
            setBackground(new Color(0,0,0,0));
        
            jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,12));
            jTable1.getTableHeader().setOpaque(false);
            jTable1.getTableHeader().setBackground(new Color(0,0,0,60));
            jTable1.getTableHeader().setForeground(new Color(0,0,0,60));
            jTable1.setRowHeight(25);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Pesquisar Produtos:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Perfume ", "Burberry Her", "Burberry", "Perfume", "R$ 269", "89327", "Nda", "30", "ml", "24/12/2040", null},
                {"Perfume ", "Burberry Her", "Burberry", "Perfume", "R$ 300", "30485", "Nda", "50", "ml", "21/11/2067", null},
                {"Perfume ", "Bad Boy Carolina Herrera Eau de Toilette", "Carolina Herrera", "Perfume", "R$ 738.90", "49202", "Nda", "150", "g", "12/02/2032", null},
                {"Perfume ", "Bad Boy Carolina Herrera Eau de Toilette", "Carolina Herrera", "Perfume", "R$ 598.90", "3947", "Nda", "100", "ml", "10/01/2025", null},
                {"Perfume ", "Idôle Lancôme Eau de Parfum", "Lancôme", "Perfume", "R$ 720", "1045", "Nda", "399", "ml", "01/01/2054", null},
                {"Esmalte", "o Boticário Intense by Manu Gavassi Azul Claro Cute - Esmalte 7ml", "O Boticário", "Esmalte", "R$ 7,99", "1245", "Azul claro Cute", "7", "ml", "12/12/2025", null},
                {"Esmalte", "Esmalte Impala Cremoso Preto", "Impala", "Esmalte", "R$ 2,59", "2918", "Preto", "7,5", "ml", "23/11/2025", null},
                {"Esmalte", "Esmalte Natural Colorama ", "Colorama", "Esmalte", "R$ 4,75", "281", "Petala", "8", "ml", "05/04/2024", null},
                {"Esmalte", "Granado Pink SOS 7 em 1 - Base Fortalecedora para Unhas", "Granda", "Esmalte", "R$ 29,99", "4967", "Incolor", "10", "ml", "24/06/2026", null},
                {"Esmalte", "Esmalte Risqué Cremoso - Lavanda Alma", "Risqué", "Esmalte", "R$ 3,99", "19183", "Lavanda Alma", "8", "ml", "09/01/2027", null},
                {"Sabonete", "Sephora Collection Bath Bar Soap", "Sephora", "Higiene", "R$ 39,00", "24", "Nda", "150", "g", "29/04/2027", null},
                {"Sabonete", "Sabonete Líquido Korres Jasmim", "Korres", "Higiene", "R$ 28,99", "623", "Nda", "250", "ml", "12/01/2024", null},
                {"Sabonete", "Sabonete Líquido Essências do Brasil Vitória Régia", "Lux", "Higiene", "R$ 11,49", "2873", "Nda", "300", "ml", "08/07/2029", null},
                {"Sabonete", "Sabonete Líquido Nutrição Profunda", "Dove", "Higiene", "R$ 10,39", "29485", "Nda", "250", "ml", "10/02/2040", null},
                {"Sabonete", "Sabonete Mandarina Asiática", "Phebo", "Higiene", "R$ 6,49", "0", "Nda", "100", "g", "20/12/2044", null},
                {"Sabonete ", "Sabonete Líquido Fisher-Price Bebê", "Biotropic", "Higiene", "R$ 14,49", "20439", "Nda", "400", "ml", "06/08/2028", null},
                {"Sabonete ", "Sabonete Barra Lavanda", "Vyedas", "Higiene", "R$ 17.80", "23495", "Nda", "120", "g", null, null},
                {"", null, null, null, null, null, null, null, null, null, null},
                {"", null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tipo de Produto", "Nome", "Marca", "Setor", "Preço", "Qtd. em estoque", "Cor", "Tamanho", "Unidade", "Validade", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(205, 203, 203));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(9, 158, 199));
        jPanel5.setAutoscrolls(true);

        jLabel33.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("VISUALIZAR PRODUTOS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel33)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Projeto/IntegradorII/Imagens/icons8_box_24px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(293, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(380, 380, 380))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
        String search = jTextField1.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}