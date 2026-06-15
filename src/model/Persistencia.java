package model;

public class Persistencia {
    private int id;
    private String chave;
    private String valor;
    private String dataRegistro;

    public Persistencia(String chave, String valor, String dataRegistro) {
        this.chave = chave;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    
    public String toString() {
        return "ID: " + id +
                " | Chave: " + chave +
                " | Valor: " + valor +
                " | Registrado em: " + dataRegistro;
    }
}
