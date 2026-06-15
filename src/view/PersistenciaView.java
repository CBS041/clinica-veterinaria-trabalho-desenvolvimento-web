package view;

import controller.PersistenciaController;
import model.Persistencia;

import java.util.List;
import java.util.Scanner;

public class PersistenciaView {
    private PersistenciaController controller;
    private Scanner scanner;

    public PersistenciaView(PersistenciaController controller) {
        this(controller, new Scanner(System.in));
    }

    public PersistenciaView(PersistenciaController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE PERSISTÊNCIA ===");
            System.out.println("1 - Registrar Informação");
            System.out.println("2 - Listar Registros");
            System.out.println("3 - Alterar Registro");
            System.out.println("4 - Excluir Registro");
            System.out.println("5 - Salvar Registros em Arquivo");
            System.out.println("6 - Carregar Registros do Arquivo");
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
            case 5: salvar(); break;
            case 6: carregar(); break;
            case 0: System.out.println("Saindo do menu de persistência..."); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private void cadastrar() {
        System.out.println("\n--- Registrar Informação Persistente ---");
        System.out.print("Chave: ");
        String chave = scanner.nextLine();
        System.out.print("Valor: ");
        String valor = scanner.nextLine();

        Persistencia persistencia = new Persistencia(
                chave,
                valor,
                controller.gerarDataHoraAtual()
        );

        controller.cadastrarPersistencia(persistencia);
        System.out.println("Registro criado com sucesso!");
    }

    private void listar() {
        System.out.println("\n--- Registros de Persistência ---");
        List<Persistencia> lista = controller.listarPersistencias();
        if (lista.isEmpty()) {
            System.out.println("Nenhum registro cadastrado.");
        } else {
            for (Persistencia p : lista) {
                System.out.println(p.toString());
            }
        }
    }

    private void alterar() {
        System.out.println("\n--- Alterar Registro ---");
        System.out.print("Digite o ID do registro: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nova Chave: ");
        String chave = scanner.nextLine();
        System.out.print("Novo Valor: ");
        String valor = scanner.nextLine();

        if (controller.alterarPersistencia(id, chave, valor)) {
            System.out.println("Registro alterado com sucesso!");
        } else {
            System.out.println("Registro não encontrado.");
        }
    }

    private void excluir() {
        System.out.println("\n--- Excluir Registro ---");
        System.out.print("Digite o ID do registro: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (controller.excluirPersistencia(id)) {
            System.out.println("Registro excluído com sucesso!");
        } else {
            System.out.println("Registro não encontrado.");
        }
    }

    private void salvar() {
        if (controller.salvarEmArquivo()) {
            System.out.println("Registros salvos em: " + controller.getCaminhoArquivo());
        } else {
            System.out.println("Não foi possível salvar os registros.");
        }
    }

    private void carregar() {
        if (controller.carregarDoArquivo()) {
            System.out.println("Registros carregados de: " + controller.getCaminhoArquivo());
        } else {
            System.out.println("Não foi possível carregar os registros.");
        }
    }
}
