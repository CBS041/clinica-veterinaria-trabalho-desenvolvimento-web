package model;

public class Veterinario extends Pessoa {
    private String telefone;
    private String crmv;
    private String especialidade;

    public Veterinario(String nome, String cpf, String telefone, String crmv, String especialidade) {
        super(nome, cpf);
        this.telefone = telefone;
        this.crmv = crmv;
        this.especialidade = especialidade;
    }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCrmv() { return crmv; }
    public void setCrmv(String crmv) { this.crmv = crmv; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    
    public String toString() {
        return "ID: " + id + " | Veterinário: " + nome + " | CPF: " + cpf + " | Tel: " + telefone
                + " | CRMV: " + crmv + " | Especialidade: " + especialidade;
    }
}
