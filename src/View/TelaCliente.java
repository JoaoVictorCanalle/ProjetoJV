package View;


import java.sql.ResultSet;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
import model.bean.Cliente;
import model.bean.Ficha;
import model.dao.ClienteDao;
import model.dao.FichaDao;
import net.proteanit.sql.DbUtils;


public class TelaCliente extends javax.swing.JInternalFrame {



    public TelaCliente() {
        initComponents();

    }

    //Método para limpar campos
    private void limparCampos() {
         txtCliId.setText(null);
         txtCliNome.setText(null);
         txtCliEndereco.setText(null);
         txtCliBairro.setText(null);
         txtCliCidade.setText(null);
         txtCliCidade.setText(null);
         txtCliUF.setText(null);
         txtCliCep.setText(null);
         txtCliTelefone.setText(null);
    }
    //Fim Método para limpar campos
      
    //Método para habilitar campos
       private void habilitarCampos(){
         txtCliNome.setEnabled(true);
         txtCliEndereco.setEnabled(true);
         txtCliBairro.setEnabled(true);
         txtCliCidade.setEnabled(true);
         txtCliCidade.setEnabled(true);
         txtCliUF.setEnabled(true);
         txtCliCep.setEnabled(true);
         txtCliTelefone.setEnabled(true); 
       }  
    //Fim Método habilitar campos
    
    //Método desabilitar Campos
       private void desabilitarCampos(){
         txtCliNome.setEnabled(false);
         txtCliEndereco.setEnabled(false);
         txtCliBairro.setEnabled(false);
         txtCliCidade.setEnabled(false);
         txtCliCidade.setEnabled(false);
         txtCliUF.setEnabled(false);
         txtCliCep.setEnabled(false);
         txtCliTelefone.setEnabled(false);  
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
    
       
    //Método para adicionar clientes
    private void adicionar() {
        int idficha; 
        try {
            FichaDao daoficha = new FichaDao();
            Ficha f = new Ficha();
             
            f.setValortotal(0);
            f.setPontuacao(0);
            daoficha.create(f);
            idficha = daoficha.retornaIdFicha();
            if (idficha != 0) {
                ClienteDao daocliente = new ClienteDao();
                Cliente c = new Cliente();
                c.setCliente_nome(txtCliNome.getText());
                c.setCliente_endereco(txtCliEndereco.getText());
                c.setCliente_bairro(txtCliBairro.getText());
                c.setCliente_cidade(txtCliCidade.getText());
                c.setCliente_uf(txtCliUF.getText());
                c.setCliente_cep(txtCliCep.getText());
                c.setCliente_telefone(txtCliTelefone.getText());
                c.setCliente_ficha_id(idficha);
                daocliente.create(c);
                limparCampos();
                botaoAdicionar();
                desabilitarCampos();
                
                
             //   p.setDescricao(txtDescricao.getText());
             //   p.setValor(Double.parseDouble(txtValor.getText().replace(",", ".")));
             //   p.setCategoria_id(categoria.getId());
                
            } else {
                  JOptionPane.showMessageDialog(null, "Erro na geração da ficha");
            }

 //           if ((txtCliNome.getText().isEmpty()) || (txtCliEndereco.getText().isEmpty())) {
 //               JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios");
 //           } else {


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    // Fim do adicionar
    

    
    //Método para pesquisar clientes pelo nome com filtro
    private void pesquisar_cliente() {
       ClienteDao cliente = new ClienteDao();
       ResultSet rs = null;
       
      rs = cliente.consultar_cliente(txtCliPesquisar.getText() + "%");
      // cliente.consultar_cliente(txtCliPesquisar.getText() + "%");
      // rs = cliente.consultar_cliente();
      //   rs = cliente.getResultado();
      
       tblClientes.setEnabled(true);
       tblClientes.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    
    
    
    
    
       // String sql = "select cliente_id as Id,cliente_nome as Nome,cliente_endereco as Endereco,cliente_bairro as Bairro,cliente_cidade as Cidade,cliente_uf as UF,"
       //         + "cliente_cep as Cep,cliente_telefone as Telefone from cliente where cliente_nome like ?";
        //select idcli as Id, nomecli as Nome, fonecli as Fone from tbclientes where nomecli like ?"
       // try {
 //           pst = conexao.prepareStatement(sql);
 //           pst.setString(1, txtCliPesquisar.getText() + "%");
 //           rs = pst.executeQuery();
 //           tblClientes.setModel(DbUtils.resultSetToTableModel(rs));

    //    } catch (Exception e) {
    //        JOptionPane.showMessageDialog(null, e);
     //   }

    
    //Fim do método para pesquisar
    
    //Método setar campos para os txt
    public void setar_campos(){
       int setar = tblClientes.getSelectedRow();
       txtCliId.setText(tblClientes.getModel().getValueAt(setar,0).toString());
       txtCliNome.setText(tblClientes.getModel().getValueAt(setar,1).toString());
       txtCliEndereco.setText(tblClientes.getModel().getValueAt(setar,2).toString());
       txtCliBairro.setText(tblClientes.getModel().getValueAt(setar,3).toString());
       txtCliCidade.setText(tblClientes.getModel().getValueAt(setar,4).toString());
       txtCliUF.setText(tblClientes.getModel().getValueAt(setar,5).toString());
       txtCliCep.setText(tblClientes.getModel().getValueAt(setar,6).toString());
       txtCliTelefone.setText(tblClientes.getModel().getValueAt(setar,7).toString());
       
       btnNovo.setEnabled(false);
       btnAdicionar.setEnabled(false);
       btnEditar.setEnabled(true);
       btnDeletar.setEnabled(true);
       btnCancelar.setEnabled(true);
       habilitarCampos();
    }
    
    //Fim Método setar campos
    
    
    //Método para validar campos em branco
    public boolean validarCampos(){ 
        if(txtCliNome.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Preencha o campo Nome!");
           txtCliNome.requestFocus();
           return false;
        }
        if(txtCliEndereco.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Preencha o campo Endereço!");
           txtCliEndereco.requestFocus();
           return false;
        }
        return true;
      }
    //Fim Método para validar campos em branco
    
    //Método para Alterar dados do Cliente
    private void alterar(){
 /*       String sql = "update cliente set cliente_nome=?,cliente_endereco=?,cliente_bairro=?,cliente_cidade=?,cliente_uf=?,cliente_cep=?,cliente_telefone=? where cliente_id=?";
        try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtCliNome.getText());
        pst.setString(2, txtCliEndereco.getText());
        pst.setString(3, txtCliBairro.getText());
        pst.setString(4, txtCliCidade.getText());
        pst.setString(5, txtCliUF.getText());
        pst.setString(6, txtCliCep.getText());
        pst.setString(7, txtCliTelefone.getText());  
        pst.setString(8, txtCliId.getText()); 
        
            if (txtCliNome.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
                
            } else {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso");
                
                limparCampos();
                
                btnNovo.setEnabled(true);
                btnAdicionar.setEnabled(false);
                btnEditar.setEnabled(false);
                btnDeletar.setEnabled(false);
       
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
   */
    }
    
  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtCliPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCliNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCliEndereco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCliBairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCliCidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCliUF = new javax.swing.JTextField();
        txtCliCep = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCliTelefone = new javax.swing.JTextField();
        txtCliId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Clientes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Endereço", "Bairro", "Cidade"
            }
        ));
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        txtCliPesquisar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCliPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliPesquisarActionPerformed(evt);
            }
        });
        txtCliPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCliPesquisarKeyPressed(evt);
            }
        });

        jLabel1.setText("Pesquisar Clientes:");

        lblData.setText("Data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblData)
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCliPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/New-48.png"))); // NOI18N
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAdicionar.setIcon(new javax.swing.ImageIcon("C:\\ProjetoSalao\\src\\Icones\\Save-48.png")); // NOI18N
        btnAdicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdicionar.setEnabled(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon("C:\\ProjetoSalao\\src\\Icones\\Edit-48.png")); // NOI18N
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Delete-48.png"))); // NOI18N
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletar.setEnabled(false);
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\ProjetoSalao\\src\\Icones\\Cancel-48.png")); // NOI18N
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        txtCliNome.setEnabled(false);

        jLabel3.setText("Endereço:");

        txtCliEndereco.setEnabled(false);

        jLabel4.setText("Bairro:");

        txtCliBairro.setEnabled(false);

        jLabel5.setText("Cidade:");

        txtCliCidade.setEnabled(false);

        jLabel6.setText("UF");

        txtCliUF.setEnabled(false);
        txtCliUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliUFActionPerformed(evt);
            }
        });

        txtCliCep.setEnabled(false);
        txtCliCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCliCepActionPerformed(evt);
            }
        });

        jLabel7.setText("Cep:");

        jLabel8.setText("Telefone:");

        txtCliTelefone.setEnabled(false);

        txtCliId.setEnabled(false);

        jLabel9.setText("Id:");

        jLabel10.setText("Status");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(694, 694, 694))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtCliEndereco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(198, 198, 198))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtCliUF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(141, 141, 141)
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(txtCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGap(166, 166, 166)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(573, 573, 573))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel4)
                                        .addComponent(txtCliBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                        .addComponent(txtCliTelefone))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCliId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdicionar)
                    .addComponent(btnEditar)
                    .addComponent(btnDeletar)
                    .addComponent(btnNovo)
                    .addComponent(btnCancelar))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 763, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtCliUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliUFActionPerformed

    private void txtCliPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCliPesquisarKeyPressed
        // TODO add your handling code here:
        pesquisar_cliente();
    }//GEN-LAST:event_txtCliPesquisarKeyPressed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        // TODO add your handling code here:
        setar_campos();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        limparCampos();
        btnNovo.setEnabled(false);
        btnEditar.setEnabled(false);
        btnAdicionar.setEnabled(true);
        btnDeletar.setEnabled(false);
        btnCancelar.setEnabled(true);
        txtCliPesquisar.enable(false);
        habilitarCampos();
        btnNovo.requestFocus();
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limparCampos();
        btnNovo.setEnabled(true);
        btnEditar.setEnabled(false);
        btnAdicionar.setEnabled(false);
        btnDeletar.setEnabled(false);
        btnCancelar.setEnabled(false);
        txtCliPesquisar.enable(true);
        desabilitarCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCliPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliPesquisarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void txtCliCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCliCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCliCepActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblData;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtCliBairro;
    private javax.swing.JTextField txtCliCep;
    private javax.swing.JTextField txtCliCidade;
    private javax.swing.JTextField txtCliEndereco;
    private javax.swing.JTextField txtCliId;
    private javax.swing.JTextField txtCliNome;
    private javax.swing.JTextField txtCliPesquisar;
    private javax.swing.JTextField txtCliTelefone;
    private javax.swing.JTextField txtCliUF;
    // End of variables declaration//GEN-END:variables
}
