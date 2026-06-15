package model;

public class Funcionario extends Pessoa {
    private String telefone;
    private String cargo;
    private String setor;

    public Funcionario(String nome, String cpf, String telefone, String cargo, String setor) {
        super(nome, cpf);
        this.telefone = telefone;
        this.cargo = cargo;
        this.setor = setor;
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }

    @Override
    public String toString() {
        return "ID: " + id + " | Funcionário: " + nome + " | CPF: " + cpf + " | Tel: " + telefone
                + " | Cargo: " + cargo + " | Setor: " + setor;
    }
}
