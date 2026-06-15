package model;

public class LogSistema {
    private int id;
    private String dataHora;
    private String nivel;
    private String mensagem;

    public LogSistema(String dataHora, String nivel, String mensagem) {
        this.dataHora = dataHora;
        this.nivel = nivel;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    
    public String toString() {
        return "ID: " + id +
                " | Data/Hora: " + dataHora +
                " | Nível: " + nivel +
                " | Mensagem: " + mensagem;
    }
}
