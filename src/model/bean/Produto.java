
package model.bean;

import java.util.Date;


public class Produto {
    
   private int id;
   private String descricao;
   private Date data;
   private double valor;
   private int categoria_id;
   private int pontfid;
   private int status;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getPontfid() {
        return pontfid;
    }

    public void setPontfid(int pontfid) {
        this.pontfid = pontfid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
   
   
   
    
}
