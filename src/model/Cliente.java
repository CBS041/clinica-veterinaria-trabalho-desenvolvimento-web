package model;

public class Cliente extends Usuario {
    private String telefone;

    public Cliente(String nome, String login, String senha, String telefone) {
        super(nome, login, senha);
        this.telefone = telefone;
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    @Override
    public String getTipoUsuario() {
        return "Cliente";
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tipo: " + getTipoUsuario() + " | Nome: " + nome + " | Login: " + login + " | Tel: " + telefone;
    }
}