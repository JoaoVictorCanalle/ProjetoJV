
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.bean.CatProduto;


public class CatProdutoDao {
    
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
   
    public void create(CatProduto cp){
        try {
            stmt = con.prepareStatement("insert into categoria(categoria_descricao,categoria_tipo,categoria_status) values(?,?,?)");
            stmt.setString(1, cp.getDescricao());
            stmt.setString(2, cp.getTipo());
            stmt.setInt(2, cp.getStatus());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: "+e);
        } finally {
          ConnectionFactory.closeConnection(con, stmt);
        }
           
    }
    
    public void alterar(CatProduto cp){
        try {
            stmt = con.prepareStatement("update categoria set categoria_descricao = ?,categoria_status = ? where categoria_id = ?");
            stmt.setString(1, cp.getDescricao());
            stmt.setInt(2, cp.getStatus());
            stmt.setInt(3, cp.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados de categoria alterados com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
      
    public ResultSet consultarServico(){
        try {                        
          //stmt = con.prepareStatement("select cliente_id as Id,cliente_nome as Nome,cliente_endereco as Endereco,cliente_bairro as Bairro,cliente_cidade as Cidade,cliente_uf as UF,cliente_cep as Cep,cliente_telefone as Telefone from cliente where cliente_nome like ?"); 
          stmt = con.prepareStatement("select categoria_id as Id,categoria_descricao,categoria_status as Categoria from categoria where categoria_tipo = 'Servico' order by categoria_descricao");
        //  stmt.setString(1, consulta);
          rs = stmt.executeQuery();
          return rs;
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar: " +e);
        }
        return rs;//return null;
    }

        public ResultSet consultarProduto(){
        try {                        
          //stmt = con.prepareStatement("select cliente_id as Id,cliente_nome as Nome,cliente_endereco as Endereco,cliente_bairro as Bairro,cliente_cidade as Cidade,cliente_uf as UF,cliente_cep as Cep,cliente_telefone as Telefone from cliente where cliente_nome like ?"); 
          stmt = con.prepareStatement("select categoria_id as Id,categoria_descricao,categoria_status as Categoria from categoria where categoria_tipo = 'Produto' order by categoria_descricao");
        //  stmt.setString(1, consulta);
          rs = stmt.executeQuery();
          return rs;
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar: " +e);
        }
        return rs;//return null;
    }
}
