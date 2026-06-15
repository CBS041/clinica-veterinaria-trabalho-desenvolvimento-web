package model;

public class Tutor extends Pessoa {
    private String telefone;

    public Tutor(String nome, String cpf, String telefone) {
        super(nome, cpf);
        this.telefone = telefone;
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    
    public String toString() {
        return "ID: " + id + " | Tutor: " + nome + " | CPF: " + cpf + " | Tel: " + telefone;
    }
}