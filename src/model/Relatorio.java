package model;

public class Relatorio {
    private int id;
    private String titulo;
    private String conteudo;
    private String dataGeracao;

    public Relatorio(String titulo, String conteudo, String dataGeracao) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataGeracao = dataGeracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getDataGeracao() {
        return dataGeracao;
    }

    
    public String toString() {
        return "\nID: " + id +
                " | Relatório: " + titulo +
                " | Gerado em: " + dataGeracao +
                "\n" + conteudo;
    }
}
