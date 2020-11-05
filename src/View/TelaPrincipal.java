
package View;

import java.text.DateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblData = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        desktop = new javax.swing.JPanel();
        Menu = new javax.swing.JMenuBar();
        menCad = new javax.swing.JMenu();
        MenCadCli = new javax.swing.JMenuItem();
        MenCadProd = new javax.swing.JMenuItem();
        MenCadServ = new javax.swing.JMenuItem();
        menCadUsu = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        menRel = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        MenAju = new javax.swing.JMenu();
        MenAjuSob = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MenOpc = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X- Controle para Ordem de Serviço");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblData.setText("Data");

        lblUsuario.setText("Usuário");

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 575, Short.MAX_VALUE)
        );

        menCad.setText("Cadastros");
        menCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadActionPerformed(evt);
            }
        });

        MenCadCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        MenCadCli.setText("Clientes");
        MenCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadCliActionPerformed(evt);
            }
        });
        menCad.add(MenCadCli);

        MenCadProd.setText("Produtos");
        MenCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadProdActionPerformed(evt);
            }
        });
        menCad.add(MenCadProd);

        MenCadServ.setText("Serviços");
        MenCadServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenCadServActionPerformed(evt);
            }
        });
        menCad.add(MenCadServ);

        menCadUsu.setText("Usuários");
        menCadUsu.setEnabled(false);
        menCadUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadUsuActionPerformed(evt);
            }
        });
        menCad.add(menCadUsu);

        Menu.add(menCad);

        jMenu1.setText("Caixa");
        Menu.add(jMenu1);

        jMenu3.setText("Comandas");
        Menu.add(jMenu3);

        menRel.setText("Relatórios");
        menRel.setEnabled(false);

        jMenu5.setText("Clientes");

        jMenuItem3.setText("Lista de Clientes");
        jMenu5.add(jMenuItem3);

        jMenuItem4.setText("Créditos dos Clientes");
        jMenu5.add(jMenuItem4);

        jMenuItem5.setText("Clientes ausentes a mais de 60 Dias");
        jMenu5.add(jMenuItem5);

        jMenuItem6.setText("Clientes/Lucro");
        jMenu5.add(jMenuItem6);

        jMenuItem7.setText("Clientes em Atraso");
        jMenu5.add(jMenuItem7);

        menRel.add(jMenu5);

        jMenu6.setText("Vendas");
        menRel.add(jMenu6);

        jMenu7.setText("Estoque");
        menRel.add(jMenu7);

        jMenu8.setText("Cadastros");

        jMenuItem8.setText("Lista de Clientes");
        jMenu8.add(jMenuItem8);

        jMenuItem2.setText("Lista de Serviços");
        jMenu8.add(jMenuItem2);

        jMenuItem9.setText("Lista de Produtos");
        jMenu8.add(jMenuItem9);

        menRel.add(jMenu8);

        Menu.add(menRel);

        MenAju.setText("Ajuda");

        MenAjuSob.setText("Sobre");
        MenAjuSob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenAjuSobActionPerformed(evt);
            }
        });
        MenAju.add(MenAjuSob);

        jMenu2.setText("jMenu2");
        MenAju.add(jMenu2);

        Menu.add(MenAju);

        MenOpc.setText("Opções");

        jMenuItem1.setText("jMenuItem1");
        MenOpc.add(jMenuItem1);

        Menu.add(MenOpc);

        jMenu4.setText("Estoque");
        Menu.add(jMenu4);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(781, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addGap(124, 124, 124)
                .addComponent(lblData)
                .addGap(78, 78, 78))
            .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(lblUsuario)))
        );

        setSize(new java.awt.Dimension(1058, 660));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadCliActionPerformed
        // Chamar TelaCliente
        TelaCliente cliente = new TelaCliente();
        cliente.setVisible(true);
        desktop.add(cliente);

        // As linhas abaixo vão abri o form TelaUsuario dentro do desktoppane
        //criar uma instancia da classe
        //  TelaUsuario usuario = new TelaUsuario();
        // usuario.setVisible(true);
        //a linha abaixo vai abrir o formulário dentro do espaço
        // desktop.add(usuario);
    }//GEN-LAST:event_MenCadCliActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Quando esta janela for ativada 
        // as linhas abaixo substitui a lbl data pela data atual do sistema ao iniciar o form
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.SHORT);
        //lblData.setText(data.toString()); sem a linha de cima só com essa linha aparece a hora completa a linha de baixo vai chamar só a data
        lblData.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void MenAjuSobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenAjuSobActionPerformed
        // chamando a Tela sobre

    }//GEN-LAST:event_MenAjuSobActionPerformed

    private void menCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menCadActionPerformed

    private void menCadUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadUsuActionPerformed
        // As linhas abaixo vão abrir o form Tela do usuario dentro do desktop pane
        TelaLogin usuario = new TelaLogin();
        usuario.setVisible(true);
        desktop.add(usuario);


    }//GEN-LAST:event_menCadUsuActionPerformed

    private void MenCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadProdActionPerformed
        // TODO add your handling code here:
        TelaProduto produto = new TelaProduto();
        produto.setVisible(true);
        desktop.add(produto);
    }//GEN-LAST:event_MenCadProdActionPerformed

    private void MenCadServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenCadServActionPerformed
        // TODO add your handling code here:
        TelaServico servico = new TelaServico();
        servico.setVisible(true);
        desktop.add(servico);
    }//GEN-LAST:event_MenCadServActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenAju;
    private javax.swing.JMenuItem MenAjuSob;
    private javax.swing.JMenuItem MenCadCli;
    private javax.swing.JMenuItem MenCadProd;
    private javax.swing.JMenuItem MenCadServ;
    private javax.swing.JMenu MenOpc;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JPanel desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menCad;
    public static javax.swing.JMenuItem menCadUsu;
    public static javax.swing.JMenu menRel;
    // End of variables declaration//GEN-END:variables
}
