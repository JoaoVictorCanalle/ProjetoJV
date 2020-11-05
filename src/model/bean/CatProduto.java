
package model.bean;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;


public class CatProduto {
    private int id;
    private String descricao;
    private String tipo;
    private int Status;

    public CatProduto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String toString(){
        return this.descricao;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    
 
    
    public Vector<CatProduto> mostrarCategoria(){
         //Alimentando o combobox 
       
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       ResultSet rs = null; 
        
       Vector<CatProduto> dados = new Vector<CatProduto>();
       CatProduto dat = null;
       
      try{

       stmt = con.prepareStatement("select categoria_id,categoria_descricao from categoria where categoria_tipo = 'Produto' order by categoria_descricao");
       rs = stmt.executeQuery();
       
       dat = new CatProduto();
       dat.setId(0);
       dat.setDescricao("Selecione a categoria");
       dados.add(dat);
       
       while (rs.next()){
           dat = new CatProduto();
           dat.setId(rs.getInt("categoria_id"));
           dat.setDescricao(rs.getString("categoria_descricao"));
           dados.add(dat);         
       }    
       rs.close();
       
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar: " +e);
       }
      return dados;
       
    }
    //fim do alimentando Produto
    
    public Vector<CatProduto> mostrarCategoriaServico(){
         //Alimentando o combobox 
       
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       ResultSet rs = null; 
        
       Vector<CatProduto> dados = new Vector<CatProduto>();
       CatProduto dat = null;
       
      try{

       stmt = con.prepareStatement("select categoria_id,categoria_descricao from categoria where categoria_tipo = 'Servico' order by categoria_descricao");
       rs = stmt.executeQuery();
       
       dat = new CatProduto();
       dat.setId(0);
       dat.setDescricao("Selecione a categoria");
       dados.add(dat);
       
       while (rs.next()){
           dat = new CatProduto();
           dat.setId(rs.getInt("categoria_id"));
           dat.setDescricao(rs.getString("categoria_descricao"));
           dados.add(dat);         
       }    
       rs.close();
       
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Erro ao salvar: " +e);
       }
      return dados;
       
    }
    //fim do alimentando Produto 
    
}
