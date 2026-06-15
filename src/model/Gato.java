package model;

public class Gato extends Animal {
    private String corPelagem;

    public Gato(String nome, int idade, Tutor tutor, String corPelagem) {
        super(nome, idade, tutor);
        this.corPelagem = corPelagem;
    }

    public String getCorPelagem() { return corPelagem; }
    public void setCorPelagem(String corPelagem) { this.corPelagem = corPelagem; }

    @Override
    public String getEspecie() { return "Gato"; }

    @Override
    public String toString() {
        String nomeTutor = (tutor != null) ? tutor.getNome() : "Sem Tutor";
        return "ID: " + id + " | Espécie: " + getEspecie() + " | Nome: " + nome + " | Idade: " + idade + " anos | Pelagem: " + corPelagem + " | Tutor: " + nomeTutor;
    }
}