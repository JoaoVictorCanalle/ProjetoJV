package Controller;

import View.TelaCatProdutos;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.bean.CatProduto;
import model.dao.CatProdutoDao;
import net.proteanit.sql.DbUtils;

public class CatProdutosController {

    private final TelaCatProdutos view;

    public CatProdutosController(TelaCatProdutos view) {
        this.view = view;
    }

    public boolean validarCampos() { //Método para Validar Campos 
        if (view.getTxtdescricao().getText().equals("")) {
            JOptionPane.showMessageDialog(view, "Digite a descrição do produto!");
            view.getTxtdescricao().requestFocus();
            return false;
        }
        return true;
    }

    public void adicionar() {
        if (validarCampos() == true) {
            CatProduto cp = new CatProduto();
            CatProdutoDao dao = new CatProdutoDao();

            cp.setDescricao(view.getTxtdescricao().getText());
            cp.setTipo("Produto");
            if (view.getJcbStatus().getSelectedItem() == "ATIVO") {
                cp.setStatus(1);
            } else if (view.getJcbStatus().getSelectedItem() == "INATIVO") {
                cp.setStatus(2);
            }
            dao.create(cp);
            atualizarGrid();
        }
    }

    public void editar() {
        if (validarCampos() == true) {
            CatProduto cp = new CatProduto();
            CatProdutoDao dao = new CatProdutoDao();
            cp.setId(Integer.parseInt(view.getTxtId().getText()));
            cp.setDescricao(view.getTxtDescricao().getText());
            if (view.getJcbStatus().getSelectedItem() == "ATIVO") {
                cp.setStatus(1);
            } else if (view.getJcbStatus().getSelectedItem() == "INATIVO") {
                cp.setStatus(2);
            }
            dao.alterar(cp);
            atualizarGrid();
        }
    }

    public void atualizarGrid() {
        CatProdutoDao cat = new CatProdutoDao();
        ResultSet rs = null;

        view.getTblCatProdutos().setEnabled(true);
        view.getTblCatProdutos().setModel(DbUtils.resultSetToTableModel(cat.consultarProduto()));
        view.getTblCatProdutos().getColumn(view.getTblCatProdutos().getColumnName(0)).setMinWidth(0);
        view.getTblCatProdutos().getColumn(view.getTblCatProdutos().getColumnName(0)).setMaxWidth(0);
        view.getTblCatProdutos().getColumn(view.getTblCatProdutos().getColumnName(1)).setPreferredWidth(150);
        view.getTblCatProdutos().getColumn(view.getTblCatProdutos().getColumnName(3)).setMinWidth(0);
        view.getTblCatProdutos().getColumn(view.getTblCatProdutos().getColumnName(3)).setMaxWidth(0);
    }

    public void setar_campos() {
        int setar = view.getTblCatProdutos().getSelectedRow();
        view.getTxtId().setText(view.getTblCatProdutos().getModel().getValueAt(setar, 0).toString());
        view.getTxtDescricao().setText(view.getTblCatProdutos().getModel().getValueAt(setar, 1).toString());
        if (view.getTblCatProdutos().getModel().getValueAt(setar, 2).equals(1)) {
            view.getJcbStatus().removeAllItems();
            view.getJcbStatus().addItem("ATIVO");
        } else if (view.getTblCatProdutos().getModel().getValueAt(setar, 2).equals(2)) {
            view.getJcbStatus().removeAllItems();
            view.getJcbStatus().addItem("INATIVO");
        }
    }
}
