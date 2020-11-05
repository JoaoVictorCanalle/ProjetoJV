package Controller;

import View.TelaLogin;
import javax.swing.JOptionPane;
import model.bean.Login;
import model.dao.LoginDao;

public class LoginController {

    private final TelaLogin view;

        
    public LoginController(TelaLogin view) {
        this.view = view;        
    }
    
    //Método para validar campos em branco
    public boolean validarCampos(){ 
        if(view.getTxtUsuario().getText().equals("")){
           JOptionPane.showMessageDialog(this.view, "Preencha o campo Usuário!");
           view.getTxtUsuario().requestFocus();
           return false;
        }
        if(view.getTxtSenha().getText().equals("")){
           JOptionPane.showMessageDialog(this.view, "Preencha o campo Senha!");
           view.getTxtSenha().requestFocus();
           return false;
        }
        return true;
      }
    //Fim Método para validar campos em branco 
    
    
    
    public void logar(){
        if (validarCampos()==true){
           Login l = new Login();
           LoginDao dao = new LoginDao();
           l.setLogin(view.getTxtUsuario().getText());
           l.setSenha(view.getTxtSenha().getText());
           dao.logar(l);
        }       
    }
    
    
    
}
