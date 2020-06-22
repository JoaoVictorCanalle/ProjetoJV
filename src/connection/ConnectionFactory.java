
package connection;
//pacote para importar bibliotecas para o java trabalhar com o sql.
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/dbsalao";
    private static final String USER = "root";
    private static final String PASS = "";
    
    //Método Público para obter conexões
    public static Connection getConnection(){
      
        try {
            Class.forName(DRIVER);    
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão",ex);
        }
    }
    //Fim do Método Público para obter conexões          
    
    //Método para fechar conexão
    public static void closeConnection(Connection con){
        
        try {
            if(con!=null){
                con.close();
            }                     
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Fim do Método para fechar conexão
    
    //Método para fechar conexão e Prepared
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
        closeConnection(con);
        try {
            if(stmt != null){
               stmt.close();     
            }                     
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    //Fim do Método para fechar conexão
    
     //Método para fechar conexão e Prepared
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con,stmt);
        try {
            if(stmt != null){
               rs.close();     
            }                     
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Fim do Método para fechar conexão
    
    
    
}
 
/*
public class ConnectionFactory {
    // método responsável por estabelecer a conexão com o banco
    private Connection conexao;
    public conexao() throws Exception{
        
      // java.sql.Connection conexao = null; linha q tava antes p cima não existia
       // a linha abaixo "chama" o driver que importou pela biblioteca
       String driver = "com.mysql.jdbc.Driver";
       // Armazenando informações referente ao banco
       // poderia ser  String url="jdbc:mysql://localhost:3306/dbinfox";
       String url="jdbc:mysql://127.0.0.1:3306/dbsalao";
       String user="root";
       String password = "";
       // Estabelecendo a conexão com o bando de dados
       //tratando possíveis erros do banco de dados ou imprevistos
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // a linha abaixo serve de apoio para esclarecer o erro
            //System.out.println("e");
            return null;
        }
    } 
} */
