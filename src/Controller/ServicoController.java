package Controller;

import View.TelaServico;
import javax.swing.JOptionPane;
import model.bean.CatProduto;
import model.bean.Produto;
import model.dao.ProdutoDao;
import net.proteanit.sql.DbUtils;

public class ServicoController {

    private final TelaServico view;

    public ServicoController(TelaServico view) {
        this.view = view;
    }

    public boolean validarCampos() { //Método para Validar Campos
        if (view.getTxtDescricao().getText().equals("")) {
            JOptionPane.showMessageDialog(view, "Digite a descrição do produto!");
            view.getTxtDescricao().requestFocus();
            return false;
        }
        if (view.getTxtValor().getText().equals("")) {
            JOptionPane.showMessageDialog(view, "Digite o valor do produto!");
            view.getTxtValor().requestFocus();
            return false;
        }
        if (view.getJcbFid().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(view, "Selecione a pontuação de fidelidade referente ao produto!");
            view.getJcbFid().requestFocus();
            return false;
        }
        if (view.getJcbCategoria().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(view, "Selecione a categoria do produto!");
            view.getJcbCategoria().requestFocus();
            return false;
        }
        if (view.getJcbStatus().getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(view, "Selecione o status do produto!");
            view.getJcbStatus().requestFocus();
            return false;
        }
        return true;
    }

    public void setar_campos() {  //Método setar campos para os txt
        int setar = view.getTblServicos().getSelectedRow();
        view.getTxtId().setText(view.getTblServicos().getModel().getValueAt(setar, 0).toString());
        view.getTxtDescricao().setText(view.getTblServicos().getModel().getValueAt(setar, 1).toString());
        view.getTxtValor().setText(view.getTblServicos().getModel().getValueAt(setar, 2).toString());
        view.getJcbFid().removeAllItems();
        view.getJcbFid().addItem(view.getTblServicos().getModel().getValueAt(setar, 3).toString());
        view.getJcbStatus().removeAllItems();
        if (view.getTblServicos().getModel().getValueAt(setar, 4).equals(1)) {
            view.getJcbStatus().removeAllItems();
            view.getJcbStatus().addItem("ATIVO");
        } else if (view.getTblServicos().getModel().getValueAt(setar, 4).equals(2)) {
            view.getJcbStatus().removeAllItems();
            view.getJcbStatus().addItem("INATIVO");
        }
        view.getJcbCategoria().removeAllItems();
        view.getJcbCategoria().addItem(view.getTblServicos().getModel().getValueAt(setar, 5).toString());
    }

    public void adicionar() {
        if (validarCampos() == true) {
            Produto p = new Produto();
            ProdutoDao dao = new ProdutoDao();
            CatProduto categoria = (CatProduto) view.getJcbCategoria().getSelectedItem();

            p.setDescricao(view.getTxtDescricao().getText());
            p.setValor(Double.parseDouble(view.getTxtValor().getText().replace(",", ".")));
            p.setCategoria_id(categoria.getId());
            p.setPontfid(Integer.parseInt(view.getJcbFid().getSelectedItem().toString()));
            if (view.getJcbStatus().getSelectedItem() == "ATIVO") {
                p.setStatus(1);
            } else if (view.getJcbStatus().getSelectedItem() == "INATIVO") {
                p.setStatus(2);
            }
            dao.create(p);
        }
    }

    public void atualizarGrid() {
        ProdutoDao dao = new ProdutoDao();
        view.getTblServicos().setModel(DbUtils.resultSetToTableModel(dao.consultar_produto()));
        //omitir campo de coluna
        view.getTblServicos().getColumn(view.getTblServicos().getColumnName(0)).setMinWidth(0);
        view.getTblServicos().getColumn(view.getTblServicos().getColumnName(0)).setMaxWidth(0);
        //tblProdutos.getColumn(tblProdutos.getColumnName(0)).setPreferredWidth(0);
        view.getTblServicos().getColumn(view.getTblServicos().getColumnName(1)).setPreferredWidth(150);
        view.getTblServicos().enable(true);
    }
}
