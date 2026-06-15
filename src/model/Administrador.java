package model;

public class Administrador extends Usuario {
    private String nivelAcesso;

    public Administrador(String nome, String login, String senha, String nivelAcesso) {
        super(nome, login, senha);
        this.nivelAcesso = nivelAcesso;
    }

    public String getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(String nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    
    public String getTipoUsuario() {
        return "Administrador";
    }

    
    public String toString() {
        return "ID: " + id + " | Tipo: " + getTipoUsuario() + " | Nome: " + nome + " | Login: " + login + " | Nível: " + nivelAcesso;
    }
}