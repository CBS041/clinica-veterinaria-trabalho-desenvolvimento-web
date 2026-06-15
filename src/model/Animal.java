package model;

public abstract class Animal {
    protected int id;
    protected String nome;
    protected int idade;
    protected Tutor tutor; // Associação: Todo animal pertence a um Tutor

    public Animal(String nome, int idade, Tutor tutor) {
        this.nome = nome;
        this.idade = idade;
        this.tutor = tutor;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public Tutor getTutor() { return tutor; }
    public void setTutor(Tutor tutor) { this.tutor = tutor; }

    public abstract String getEspecie();
}