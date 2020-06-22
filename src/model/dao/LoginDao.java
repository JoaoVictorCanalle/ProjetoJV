
package model.dao;

import View.TelaPrincipal;
import connection.ConnectionFactory;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Login;


public class LoginDao {

    
    Connection con = ConnectionFactory.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;

    //Método logar
    public void logar(Login l){
        try {
            stmt = con.prepareStatement("select * from usuario where usuario_login=? and usuario_senha =?");
            
            stmt.setString(1, l.getLogin());
            stmt.setString(2, l.getSenha());
            rs = stmt.executeQuery();
             if (rs.next()) {
                 String perfil = rs.getString(5);
                 if (perfil.equals("admin")){            
                 
                 TelaPrincipal principal = new TelaPrincipal();
                 principal.setVisible(true);
                 TelaPrincipal.menRel.setEnabled(true);
                 TelaPrincipal.menCadUsu.setEnabled(true);
                 TelaPrincipal.lblUsuario.setText(rs.getString(2));
                 TelaPrincipal.lblUsuario.setForeground(Color.red);
                 this.dispose();
                 ConnectionFactory.closeConnection(con, stmt, rs);
               
                 }else{
                 TelaPrincipal principal = new TelaPrincipal();
                 principal.setVisible(true);    
                 TelaPrincipal.lblUsuario.setText(rs.getString(2));
                 this.dispose();
                 ConnectionFactory.closeConnection(con, stmt, rs);
    
                 }
             } else {
                JOptionPane.showMessageDialog(null,"usuário e/ou senha inválido(s)");
             }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
          
        }
    //Fim Método logar
    
    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    }
  