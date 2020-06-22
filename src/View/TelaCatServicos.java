
package View;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.bean.CatProduto;
import model.dao.CatProdutoDao;
import net.proteanit.sql.DbUtils;


public class TelaCatServicos extends javax.swing.JFrame {

  
    public TelaCatServicos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCatServicos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Tipos de Serviços");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblCatServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tblCatServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCatServicosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCatServicos);

        jLabel1.setText("Descrição:");

        txtDescricao.setEnabled(false);

        btnNovo.setIcon(new javax.swing.ImageIcon("C:\\Users\\JaYVi\\Downloads\\Icones JV\\New-48.png")); // NOI18N
        btnNovo.setToolTipText("Novo");
        btnNovo.setPreferredSize(new java.awt.Dimension(50, 50));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon("C:\\Users\\JaYVi\\Downloads\\Icones JV\\Save-48.png")); // NOI18N
        btnAdicionar.setToolTipText("Salvar");
        btnAdicionar.setEnabled(false);
        btnAdicionar.setMaximumSize(new java.awt.Dimension(80, 57));
        btnAdicionar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon("C:\\Users\\JaYVi\\Downloads\\Icones JV\\Edit-48.png")); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.setPreferredSize(new java.awt.Dimension(50, 50));

        btnDeletar.setIcon(new javax.swing.ImageIcon("C:\\Users\\JaYVi\\Downloads\\Icones JV\\Delete-48.png")); // NOI18N
        btnDeletar.setToolTipText("Deletar");
        btnDeletar.setEnabled(false);
        btnDeletar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\JaYVi\\Downloads\\Icones JV\\Cancel-48.png")); // NOI18N
        btnCancelar.setToolTipText("Cancel");
        btnCancelar.setEnabled(false);
        btnCancelar.setMaximumSize(new java.awt.Dimension(80, 57));
        btnCancelar.setPreferredSize(new java.awt.Dimension(50, 50));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtId.setEnabled(false);

        jLabel6.setText("Status:");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));
        jcbStatus.setEnabled(false);
        jcbStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbStatusMouseClicked(evt);
            }
        });
        jcbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(201, 201, 201)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDescricao)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Método para limpar campos
    private void limparCampos() {
         txtDescricao.setText(null);
         jcbStatus.setSelectedIndex(0);
    }     
    //Fim Método para limpar campos
      
    //Método para habilitar campos
       private void habilitarCampos(){
         txtDescricao.setEnabled(true);
         jcbStatus.setEnabled(true);
       }  
    //Fim Método habilitar campos
    
    //Método desabilitar Campos
       private void desabilitarCampos(){
         txtDescricao.setEnabled(false);
         jcbStatus.setEnabled(false);
       }
    //Fim Método desabilitar Campos
    
        //Menu de botões - Padronizar
    public void botaoNovo() {
        btnNovo.setEnabled(true);
        btnAdicionar.setEnabled(true);
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnCancelar.setEnabled(true);
    }

    public void botaoAdicionar() {
        btnNovo.setEnabled(true);
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }
     
    public void botaoDeletar() {
        btnNovo.setEnabled(true);
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnCancelar.setEnabled(false);       
    }
    
    public void botaoSetarCampos() {
        btnNovo.setEnabled(false);
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(true);
        btnDeletar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    public void botaoCancelar() {
        btnNovo.setEnabled(true);
        btnAdicionar.setEnabled(false);
        btnEditar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnCancelar.setEnabled(false);
    }
    //Fim do Menu de botões - Padronizar 
    
    //Método para Validar Campos   
   /* public boolean validarCampos(){
        if(txtDescricao.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Digite a descrição do produto!");
            txtDescricao.requestFocus();
            return false;
        } if(txtValor.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Digite o valor do produto!");
            txtValor.requestFocus();
            return false;
        } if(jcbStatus.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Selecione o status do produto!");
            jcbStatus.requestFocus();
            return false; 
        }  
            return true;
        
    }     */
    //Fim Método para Validar Campos
    
    //Método setar campos para os txt
    public void setar_campos() {
        habilitarCampos();
        botaoSetarCampos();
        
        int setar = tblCatServicos.getSelectedRow();
        txtId.setText(tblCatServicos.getModel().getValueAt(setar, 0).toString());
        txtDescricao.setText(tblCatServicos.getModel().getValueAt(setar, 1).toString());
        if (tblCatServicos.getModel().getValueAt(setar, 2).equals(1)) {
            jcbStatus.removeAllItems();
            jcbStatus.addItem("ATIVO");
        } else if (tblCatServicos.getModel().getValueAt(setar, 2).equals(2)) {
            jcbStatus.removeAllItems();
            jcbStatus.addItem("INATIVO");
        }
        
               
    }
    
    //Passar dados para a tabela
      public void atualizarDadosGrid(){
          CatProdutoDao cat = new CatProdutoDao(); 
          ResultSet rs = null;
    
          tblCatServicos.setEnabled(true);
          tblCatServicos.setModel(DbUtils.resultSetToTableModel(cat.consultarServico()));
          tblCatServicos.getColumn(tblCatServicos.getColumnName(0)).setMinWidth(0);
          tblCatServicos.getColumn(tblCatServicos.getColumnName(0)).setMaxWidth(0);
          tblCatServicos.getColumn(tblCatServicos.getColumnName(1)).setPreferredWidth(150);
      }
    //Fim Passar dados para a tabela
       
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        limparCampos();
        habilitarCampos();
        tblCatServicos.setEnabled(false);
        botaoNovo();
        txtDescricao.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
       
        CatProduto cp = new CatProduto();
        CatProdutoDao dao = new CatProdutoDao();
       // CatProduto categoria = (CatProduto) jcbCategoria.getSelectedItem();

        cp.setDescricao(txtDescricao.getText());
        cp.setTipo("Servico");
        dao.create(cp);
        limparCampos();
        desabilitarCampos();
  //      btnPesquisar.setEnabled(true);
        tblCatServicos.setEnabled(true);
        botaoAdicionar();
        atualizarDadosGrid();

      //  btnPesquisar.doClick();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limparCampos();
        desabilitarCampos();
        atualizarDadosGrid();
        //btnPesquisar.setEnabled(true);
        tblCatServicos.setEnabled(true);
        botaoDeletar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       atualizarDadosGrid();
    }//GEN-LAST:event_formWindowOpened

    private void tblCatServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCatServicosMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tblCatServicosMouseClicked

    private void jcbStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbStatusMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbStatusMouseClicked

    private void jcbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbStatusActionPerformed
        // Adiciona o item faltando no combobox
        if (jcbStatus.getItemCount() < 2) {
            if (jcbStatus.getSelectedItem() == "ATIVO") {
                jcbStatus.addItem("INATIVO");
            } else if (jcbStatus.getSelectedItem() == "INATIVO") {
                jcbStatus.addItem("ATIVO");
            }
        }
    }//GEN-LAST:event_jcbStatusActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaCatServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCatServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCatServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCatServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCatServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JTable tblCatServicos;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
