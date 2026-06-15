package view;

import controller.RelatorioController;
import model.Relatorio;

import java.util.List;
import java.util.Scanner;

public class RelatorioView {
    private RelatorioController controller;
    private Scanner scanner;

    public RelatorioView(RelatorioController controller) {
        this(controller, new Scanner(System.in));
    }

    public RelatorioView(RelatorioController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE RELATÓRIOS ===");
            System.out.println("1 - Gerar Relatório Geral");
            System.out.println("2 - Gerar Relatório de Animais");
            System.out.println("3 - Gerar Relatório de Consultas");
            System.out.println("4 - Gerar Relatório de Vacinações");
            System.out.println("5 - Listar Relatórios Gerados");
            System.out.println("6 - Excluir Relatório");
            System.out.println("0 - Voltar/Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
            }
        }
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1: exibirRelatorio(controller.gerarRelatorioGeral()); break;
            case 2: exibirRelatorio(controller.gerarRelatorioAnimais()); break;
            case 3: exibirRelatorio(controller.gerarRelatorioConsultas()); break;
            case 4: exibirRelatorio(controller.gerarRelatorioVacinacoes()); break;
            case 5: listar(); break;
            case 6: excluir(); break;
            case 0: System.out.println("Saindo do menu de relatórios..."); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private void exibirRelatorio(Relatorio relatorio) {
        System.out.println("\n--- Relatório Gerado ---");
        System.out.println(relatorio.toString());
    }

    private void listar() {
        System.out.println("\n--- Relatórios Gerados ---");
        List<Relatorio> lista = controller.listarRelatorios();
        if (lista.isEmpty()) {
            System.out.println("Nenhum relatório gerado.");
        } else {
            for (Relatorio relatorio : lista) {
                System.out.println(relatorio.toString());
            }
        }
    }

    private void excluir() {
        System.out.println("\n--- Excluir Relatório ---");
        System.out.print("Digite o ID do relatório: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (controller.excluirRelatorio(id)) {
            System.out.println("Relatório excluído com sucesso!");
        } else {
            System.out.println("Relatório não encontrado.");
        }
    }
}
