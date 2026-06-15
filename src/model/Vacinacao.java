package model;

public class Vacinacao {
    private int id;
    private String nomeAnimal;
    private String nomeVacina;
    private String dataAplicacao;
    private String proximaDose;
    private String veterinarioResponsavel;

    public Vacinacao(String nomeAnimal,
                     String nomeVacina,
                     String dataAplicacao,
                     String proximaDose,
                     String veterinarioResponsavel) {
        this.nomeAnimal = nomeAnimal;
        this.nomeVacina = nomeVacina;
        this.dataAplicacao = dataAplicacao;
        this.proximaDose = proximaDose;
        this.veterinarioResponsavel = veterinarioResponsavel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getProximaDose() {
        return proximaDose;
    }

    public void setProximaDose(String proximaDose) {
        this.proximaDose = proximaDose;
    }

    public String getVeterinarioResponsavel() {
        return veterinarioResponsavel;
    }

    public void setVeterinarioResponsavel(String veterinarioResponsavel) {
        this.veterinarioResponsavel = veterinarioResponsavel;
    }

    
    public String toString() {
        return "ID: " + id +
                " | Animal: " + nomeAnimal +
                " | Vacina: " + nomeVacina +
                " | Data: " + dataAplicacao +
                " | Próxima Dose: " + proximaDose +
                " | Veterinário: " + veterinarioResponsavel;
    }
}
