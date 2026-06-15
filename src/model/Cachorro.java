package model;

public class Cachorro extends Animal {
    private String raca;

    public Cachorro(String nome, int idade, Tutor tutor, String raca) {
        super(nome, idade, tutor);
        this.raca = raca;
    }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    
    public String getEspecie() { return "Cachorro"; }

    
    public String toString() {
        String nomeTutor = (tutor != null) ? tutor.getNome() : "Sem Tutor";
        return "ID: " + id + " | Espécie: " + getEspecie() + " | Nome: " + nome + " | Idade: " + idade + " anos | Raça: " + raca + " | Tutor: " + nomeTutor;
    }
}