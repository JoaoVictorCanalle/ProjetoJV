
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.bean.Ficha;


public class FichaDao {
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    int idficha = 0;
    //Método Create Ficha
    public void create(Ficha f) {
        //int idficha = 0;
        try {
            
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

            stmt = con.prepareStatement("insert into ficha(ficha_valortotal,ficha_pontuacao,ficha_dtabertura) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(1, f.getValortotal());
            stmt.setInt(2, f.getPontuacao());
            stmt.setDate(3, dataSql);
            stmt.executeUpdate();
            
            //Recupera e salva id
            rs = stmt.getGeneratedKeys();
            //idficha = 0;
            if (rs.next()){
               idficha = rs.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }     
    }
    //Fim do Método Create Ficha
   
    public int retornaIdFicha()
    {
           return idficha;
    }
}    
