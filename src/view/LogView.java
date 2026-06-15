package view;

import controller.LogController;
import model.LogSistema;

import java.util.List;
import java.util.Scanner;

public class LogView {
    private LogController controller;
    private Scanner scanner;

    public LogView(LogController controller) {
        this(controller, new Scanner(System.in));
    }

    public LogView(LogController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE LOGS ===");
            System.out.println("1 - Registrar Log");
            System.out.println("2 - Listar Logs");
            System.out.println("3 - Alterar Log");
            System.out.println("4 - Excluir Log");
            System.out.println("5 - Limpar Todos os Logs");
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
            case 1: cadastrar(); break;
            case 2: listar(); break;
            case 3: alterar(); break;
            case 4: excluir(); break;
            case 5: limpar(); break;
            case 0: System.out.println("Saindo do menu de logs..."); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private void cadastrar() {
        System.out.println("\n--- Registrar Log ---");
        System.out.print("Nível (INFO/AVISO/ERRO): ");
        String nivel = scanner.nextLine();
        System.out.print("Mensagem: ");
        String mensagem = scanner.nextLine();

        controller.registrarLog(nivel, mensagem);
        System.out.println("Log registrado com sucesso!");
    }

    private void listar() {
        System.out.println("\n--- Lista de Logs ---");
        List<LogSistema> lista = controller.listarLogs();
        if (lista.isEmpty()) {
            System.out.println("Nenhum log cadastrado.");
        } else {
            for (LogSistema log : lista) {
                System.out.println(log.toString());
            }
        }
    }

    private void alterar() {
        System.out.println("\n--- Alterar Log ---");
        System.out.print("Digite o ID do log: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo Nível: ");
        String nivel = scanner.nextLine();
        System.out.print("Nova Mensagem: ");
        String mensagem = scanner.nextLine();

        if (controller.alterarLog(id, nivel, mensagem)) {
            System.out.println("Log alterado com sucesso!");
        } else {
            System.out.println("Log não encontrado.");
        }
    }

    private void excluir() {
        System.out.println("\n--- Excluir Log ---");
        System.out.print("Digite o ID do log: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (controller.excluirLog(id)) {
            System.out.println("Log excluído com sucesso!");
        } else {
            System.out.println("Log não encontrado.");
        }
    }

    private void limpar() {
        controller.limparLogs();
        System.out.println("Todos os logs foram removidos.");
    }
}
