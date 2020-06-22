
package model.bean;

import java.util.Date;


public class Ficha {
    private int id;
    private double valortotal;
    private Date ultpagamento;
    private Date ultcompra;
    private int pontuacao;
    private Date dtabertura;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public Date getUltpagamento() {
        return ultpagamento;
    }

    public void setUltpagamento(Date ultpagamento) {
        this.ultpagamento = ultpagamento;
    }

    public Date getUltcompra() {
        return ultcompra;
    }

    public void setUltcompra(Date ultcompra) {
        this.ultcompra = ultcompra;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Date getDtabertura() {
        return dtabertura;
    }

    public void setDtabertura(Date dtabertura) {
        this.dtabertura = dtabertura;
    }


    
    
}
