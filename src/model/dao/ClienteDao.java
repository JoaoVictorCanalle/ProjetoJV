package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.bean.Cliente;

public class ClienteDao {

    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    public ResultSet consultar_cliente(String consulta) {
        try {
            stmt = con.prepareStatement("select cliente_id as Id,cliente_nome as Nome,cliente_endereco as Endereco,cliente_bairro as Bairro,cliente_cidade as Cidade,cliente_uf as UF,cliente_cep as Cep,cliente_telefone as Telefone from cliente where cliente_nome like ?");
            stmt.setString(1, consulta);
            rs = stmt.executeQuery();
            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
        }
        return rs;//return null;
    }

    public void create(Cliente c) {     //Método para Adicionar dados do Cliente
        try {
            stmt = con.prepareStatement("Insert into cliente(cliente_nome,cliente_endereco,cliente_bairro,cliente_cidade,cliente_uf,cliente_cep,cliente_telefone,cliente_ficha_id,cliente_status) values(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, c.getCliente_nome());
            stmt.setString(2, c.getCliente_endereco());
            stmt.setString(3, c.getCliente_bairro());
            stmt.setString(4, c.getCliente_cidade());
            stmt.setString(5, c.getCliente_uf());
            stmt.setString(6, c.getCliente_cep());
            stmt.setString(7, c.getCliente_telefone());
            stmt.setInt(8, c.getCliente_ficha_id());
            stmt.setInt(9, c.getCliente_status());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterar(Cliente c) { //Método para Alterar dados do Cliente
        try {
            stmt = con.prepareStatement("update cliente set cliente_nome=?,cliente_endereco=?,cliente_bairro=?,cliente_cidade=?,cliente_uf=?,cliente_cep=?,cliente_telefone=?,cliente_status=? where cliente_id=?");
            stmt.setString(1, c.getCliente_nome());
            stmt.setString(2, c.getCliente_endereco());
            stmt.setString(3, c.getCliente_bairro());
            stmt.setString(4, c.getCliente_cidade());
            stmt.setString(5, c.getCliente_uf());
            stmt.setString(6, c.getCliente_cep());
            stmt.setString(7, c.getCliente_telefone());
            stmt.setInt(8, c.getCliente_status());
            stmt.setInt(9, c.getCliente_id());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
