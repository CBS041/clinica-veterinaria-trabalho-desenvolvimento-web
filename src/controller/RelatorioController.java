package controller;

import model.Animal;
import model.Consulta;
import model.Relatorio;
import model.Vacinacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RelatorioController {
    private TutorController tutorController;
    private AnimalController animalController;
    private ConsultaController consultaController;
    private VacinacaoController vacinacaoController;
    private PersistenciaController persistenciaController;
    private LogController logController;
    private List<Relatorio> relatorios = new ArrayList<>();
    private int contadorId = 1;

    public RelatorioController(TutorController tutorController,
                               AnimalController animalController,
                               ConsultaController consultaController,
                               VacinacaoController vacinacaoController,
                               PersistenciaController persistenciaController,
                               LogController logController) {
        this.tutorController = tutorController;
        this.animalController = animalController;
        this.consultaController = consultaController;
        this.vacinacaoController = vacinacaoController;
        this.persistenciaController = persistenciaController;
        this.logController = logController;
    }

    public Relatorio gerarRelatorioGeral() {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("Tutores cadastrados: ")
                .append(tutorController.listarTutores().size())
                .append("\n");
        conteudo.append("Animais cadastrados: ")
                .append(animalController.listarAnimais().size())
                .append("\n");
        conteudo.append("Consultas cadastradas: ")
                .append(consultaController.getConsultas().size())
                .append("\n");
        conteudo.append("Vacinações cadastradas: ")
                .append(vacinacaoController.listarVacinacoes().size())
                .append("\n");
        conteudo.append("Registros de persistência: ")
                .append(persistenciaController.listarPersistencias().size())
                .append("\n");
        conteudo.append("Logs cadastrados: ")
                .append(logController.listarLogs().size());

        return registrarRelatorio("Relatório Geral", conteudo.toString());
    }

    public Relatorio gerarRelatorioAnimais() {
        StringBuilder conteudo = new StringBuilder();
        List<Animal> animais = animalController.listarAnimais();

        if (animais.isEmpty()) {
            conteudo.append("Nenhum animal cadastrado.");
        } else {
            for (Animal animal : animais) {
                conteudo.append(animal.toString()).append("\n");
            }
        }

        return registrarRelatorio("Relatório de Animais", conteudo.toString());
    }

    public Relatorio gerarRelatorioConsultas() {
        StringBuilder conteudo = new StringBuilder();
        List<Consulta> consultas = consultaController.getConsultas();

        if (consultas.isEmpty()) {
            conteudo.append("Nenhuma consulta cadastrada.");
        } else {
            for (Consulta consulta : consultas) {
                conteudo.append(consulta.toString()).append("\n");
            }
        }

        return registrarRelatorio("Relatório de Consultas", conteudo.toString());
    }

    public Relatorio gerarRelatorioVacinacoes() {
        StringBuilder conteudo = new StringBuilder();
        List<Vacinacao> vacinacoes = vacinacaoController.listarVacinacoes();

        if (vacinacoes.isEmpty()) {
            conteudo.append("Nenhuma vacinação cadastrada.");
        } else {
            for (Vacinacao vacinacao : vacinacoes) {
                conteudo.append(vacinacao.toString()).append("\n");
            }
        }

        return registrarRelatorio("Relatório de Vacinações", conteudo.toString());
    }

    public List<Relatorio> listarRelatorios() {
        return relatorios;
    }

    public boolean excluirRelatorio(int id) {
        for (int i = 0; i < relatorios.size(); i++) {
            if (relatorios.get(i).getId() == id) {
                relatorios.remove(i);
                return true;
            }
        }
        return false;
    }

    private Relatorio registrarRelatorio(String titulo, String conteudo) {
        Relatorio relatorio = new Relatorio(
                titulo,
                conteudo,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
        );
        relatorio.setId(contadorId++);
        relatorios.add(relatorio);
        return relatorio;
    }
}
