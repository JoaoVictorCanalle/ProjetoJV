/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Produto;

/**
 *
 * @author JaYVi
 */
public class ServicoDao {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
     
    // dentro () é um objeto
    public void createServico(Produto p){
        
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
            
            JOptionPane.showMessageDialog(null, "Serviço salvo com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " +ex);
           
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
     public ResultSet consultar_servico(){
        try {                        
          stmt = con.prepareStatement("select p.produto_id, p.produto_descricao from produto as p inner join categoria as c on p.produto_categoria_id = c.categoria_id where categoria_tipo = 'Servico' order by produto_descricao"); 
          //stmt = con.prepareStatement("select categoria_id as Id,categoria_descricao as Categoria from categoria where categoria_tipo = 'Produto' order by categoria_descricao");
          rs = stmt.executeQuery();
          return rs;
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar: " +e);
        }
        return null;
    }
}
