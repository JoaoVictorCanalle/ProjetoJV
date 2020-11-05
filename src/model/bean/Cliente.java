package model.bean;

public class Cliente {

    private int cliente_id;
    private String cliente_nome;
    private String cliente_endereco;
    private String cliente_bairro;
    private String cliente_cidade;
    private String cliente_uf;
    private String cliente_cep;
    private String cliente_telefone;
    private int cliente_status;
    private int cliente_ficha_id;

    public Cliente(int cliente_id, String cliente_nome, String cliente_endereco, String cliente_bairro, String cliente_cidade, String cliente_uf, String cliente_cep, String cliente_telefone, int cliente_ficha_id) {
        this.cliente_id = cliente_id;
        this.cliente_nome = cliente_nome;
        this.cliente_endereco = cliente_endereco;
        this.cliente_bairro = cliente_bairro;
        this.cliente_cidade = cliente_cidade;
        this.cliente_uf = cliente_uf;
        this.cliente_cep = cliente_cep;
        this.cliente_telefone = cliente_telefone;
        this.cliente_status = cliente_status;
        this.cliente_ficha_id = cliente_ficha_id;
    }

    public Cliente() {
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getCliente_endereco() {
        return cliente_endereco;
    }

    public void setCliente_endereco(String cliente_endereco) {
        this.cliente_endereco = cliente_endereco;
    }

    public String getCliente_bairro() {
        return cliente_bairro;
    }

    public void setCliente_bairro(String cliente_bairro) {
        this.cliente_bairro = cliente_bairro;
    }

    public String getCliente_cidade() {
        return cliente_cidade;
    }

    public void setCliente_cidade(String cliente_cidade) {
        this.cliente_cidade = cliente_cidade;
    }

    public String getCliente_uf() {
        return cliente_uf;
    }

    public void setCliente_uf(String cliente_uf) {
        this.cliente_uf = cliente_uf;
    }

    public String getCliente_cep() {
        return cliente_cep;
    }

    public void setCliente_cep(String cliente_cep) {
        this.cliente_cep = cliente_cep;
    }

    public String getCliente_telefone() {
        return cliente_telefone;
    }

    public void setCliente_telefone(String cliente_telefone) {
        this.cliente_telefone = cliente_telefone;
    }

    public int getCliente_ficha_id() {
        return cliente_ficha_id;
    }

    public void setCliente_ficha_id(int cliente_ficha_id) {
        this.cliente_ficha_id = cliente_ficha_id;
    }

    public int getCliente_status() {
        return cliente_status;
    }

    public void setCliente_status(int cliente_status) {
        this.cliente_status = cliente_status;
    }

}
