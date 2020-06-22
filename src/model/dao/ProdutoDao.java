
package model.dao;

import View.TelaProduto;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import model.bean.Produto;


public class ProdutoDao {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
     
    // dentro () é um objeto
    public void create(Produto p){
        
        try {
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
            
            stmt = con.prepareStatement("insert into produto(produto_descricao,produto_data,produto_valor,produto_categoria_id,produto_pontfid,produto_status) values(?,?,?,?,?,?)");
            stmt.setString(1, p.getDescricao());
            stmt.setDate(2, dataSql);
            stmt.setDouble(3, p.getValor());
            stmt.setInt(4, p.getCategoria_id());
            stmt.setInt(5, p.getPontfid());
            stmt.setInt(6, p.getStatus());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " +ex);
           
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
/*    //Método para Alterar dados do Cliente
    private void alterar(){
        String sql = "update cliente set cliente_nome=?,cliente_endereco=?,cliente_bairro=?,cliente_cidade=?,cliente_uf=?,cliente_cep=?,cliente_telefone=? where cliente_id=?";
        try {
            stmt = con.prepareStatement("update into produto(produto_descricao,produto_data,produto_valor,produto_categoria_id,produto_pontfid,produto_status) values(?,?,?,?,?,?)");
        
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
       
    }
    //Fim do Método para Alterar dados do Cliente */
    
    
    
    public ResultSet consultar_produto(){
        try {                        
          stmt = con.prepareStatement("select p.produto_id, p.produto_descricao, p.produto_valor, p.produto_pontfid, p.produto_status, c.categoria_descricao from produto as p inner join categoria as c on p.produto_categoria_id = c.categoria_id where categoria_tipo = 'Produto' and categoria_status = 1 order by produto_descricao"); 
          //stmt = con.prepareStatement("select categoria_id as Id,categoria_descricao as Categoria from categoria where categoria_tipo = 'Produto' order by categoria_descricao");
          rs = stmt.executeQuery();
          return rs;
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar: " +e);
        }
        return null;
    }
    
    
    
}          
    

