package model;

import java.io.Serializable;

public class Consulta implements Serializable {

    private String nomeAnimal;
    private String nomeVeterinario;
    private String data;
    private String horario;

    public Consulta(String nomeAnimal,
                    String nomeVeterinario,
                    String data,
                    String horario) {

        this.nomeAnimal = nomeAnimal;
        this.nomeVeterinario = nomeVeterinario;
        this.data = data;
        this.horario = horario;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "Animal: " + nomeAnimal +
                " | Veterinário: " + nomeVeterinario +
                " | Data: " + data +
                " | Horário: " + horario;
    }
}