package Controller;

import View.TelaCliente;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.Ficha;
import model.dao.ClienteDao;
import model.dao.FichaDao;
import net.proteanit.sql.DbUtils;

public class ClienteController {

    private final TelaCliente view;

    public ClienteController(TelaCliente view) { //Criei um construtor para ter controle da view
        this.view = view;
    }

    public void pesquisar_cliente() {  //Método para pesquisar clientes pelo nome com filtro
        try {
            ClienteDao cliente = new ClienteDao();
            ResultSet rs = null;
            rs = cliente.consultar_cliente(view.getTxtCliPesquisar().getText() + "%");
            view.getTblClientes().setEnabled(true);
            view.getTblClientes().setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private boolean validarCampos() { //Método para validar campos em branco
        if (view.getTxtCliNome().getText().equals("")) {
            JOptionPane.showMessageDialog(view, "Preencha o campo Nome!");
            view.getTxtCliNome().requestFocus();
            return false;
        }
        /* if(txtCliEndereco.getText().equals("")){
           JOptionPane.showMessageDialog(this, "Preencha o campo Endereço!");
           txtCliEndereco.requestFocus();
           return false;
        } */
        return true;
    }

    public void adicionar() { //Método para adicionar clientes
        if (validarCampos() == true) {
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
                    c.setCliente_nome(view.getTxtCliNome().getText());
                    c.setCliente_endereco(view.getTxtCliEndereco().getText());
                    c.setCliente_bairro(view.getTxtCliBairro().getText());
                    c.setCliente_cidade(view.getTxtCliCidade().getText());
                    c.setCliente_uf(view.getTxtCliUF().getText());
                    c.setCliente_cep(view.getTxtCliCep().getText());
                    c.setCliente_telefone(view.getTxtCliTelefone().getText());
                    c.setCliente_ficha_id(idficha);
                    if (view.getJcbStatus().getSelectedItem() == "ATIVO") {
                        c.setCliente_status(1);
                    } else if (view.getJcbStatus().getSelectedItem() == "INATIVO") {
                        c.setCliente_status(2);
                    }
                    daocliente.create(c);
                } else {
                    JOptionPane.showMessageDialog(null, "Erro na geração da ficha");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    public void editar() {
        try {
            ClienteDao daocliente = new ClienteDao();
            Cliente c = new Cliente();
            c.setCliente_nome(view.getTxtCliNome().getText());
            c.setCliente_endereco(view.getTxtCliEndereco().getText());
            c.setCliente_bairro(view.getTxtCliBairro().getText());
            c.setCliente_cidade(view.getTxtCliCidade().getText());
            c.setCliente_uf(view.getTxtCliUF().getText());
            c.setCliente_cep(view.getTxtCliCep().getText());
            c.setCliente_telefone(view.getTxtCliTelefone().getText());
            c.setCliente_id(Integer.parseInt(view.getTxtCliId().getText()));
            if (view.getJcbStatus().getSelectedItem() == "ATIVO") {
                c.setCliente_status(1);
            } else if (view.getJcbStatus().getSelectedItem() == "INATIVO") {
                c.setCliente_status(2);
            }
            daocliente.alterar(c);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void setar_campos() { //Método setar campos para os txt  
        int setar = (view.getTblClientes().getSelectedRow());
        view.getTxtCliId().setText(view.getTblClientes().getModel().getValueAt(setar, 0).toString());
        view.getTxtCliNome().setText(view.getTblClientes().getModel().getValueAt(setar, 1).toString());
        view.getTxtCliEndereco().setText(view.getTblClientes().getModel().getValueAt(setar, 2).toString());
        view.getTxtCliBairro().setText(view.getTblClientes().getModel().getValueAt(setar, 3).toString());
        view.getTxtCliCidade().setText(view.getTblClientes().getModel().getValueAt(setar, 4).toString());
        view.getTxtCliUF().setText(view.getTblClientes().getModel().getValueAt(setar, 5).toString());
        view.getTxtCliCep().setText(view.getTblClientes().getModel().getValueAt(setar, 6).toString());
        view.getTxtCliTelefone().setText(view.getTblClientes().getModel().getValueAt(setar, 7).toString());
        if (view.getTblClientes().getModel().getValueAt(setar, 8).equals(1)) {
            view.getJcbStatus().removeAllItems();
            view.getJcbStatus().addItem("ATIVO");
        } else if (view.getTblClientes().getModel().getValueAt(setar, 8).equals(2)) {
            view.getJcbStatus().removeAllItems();
            view.getJcbStatus().addItem("INATIVO");
        }
    }

}
