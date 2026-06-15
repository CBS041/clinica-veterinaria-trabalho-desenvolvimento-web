package view;

import controller.TutorController;
import model.Tutor;
import java.util.List;
import java.util.Scanner;

public class TutorView {
    private TutorController controller;
    private Scanner scanner;

    
    public TutorView(TutorController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE TUTORES ===");
            System.out.println("1 - Cadastrar Tutor");
            System.out.println("2 - Listar Tutores");
            System.out.println("3 - Alterar Tutor");
            System.out.println("4 - Excluir Tutor");
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
            case 0: System.out.println("Saindo do menu de tutores..."); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private void cadastrar() {
        System.out.println("\n--- Cadastro de Tutor ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Tutor tutor = new Tutor(nome, cpf, telefone);
        controller.cadastrarTutor(tutor);
        System.out.println("Tutor cadastrado com sucesso!");
    }

    private void listar() {
        System.out.println("\n--- Lista de Tutores ---");
        List<Tutor> lista = controller.listarTutores();
        if (lista.isEmpty()) {
            System.out.println("Nenhum tutor cadastrado.");
        } else {
            for (Tutor t : lista) {
                System.out.println(t.toString());
            }
        }
    }

    private void alterar() {
        System.out.println("\n--- Alterar Tutor ---");
        System.out.print("Digite o ID do tutor: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();

        if (controller.alterarTutor(id, nome, telefone)) {
            System.out.println("Tutor alterado com sucesso!");
        } else {
            System.out.println("Tutor não encontrado.");
        }
    }

    private void excluir() {
        System.out.println("\n--- Excluir Tutor ---");
        System.out.print("Digite o ID do tutor: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (controller.excluirTutor(id)) {
            System.out.println("Tutor excluído com sucesso!");
        } else {
            System.out.println("Tutor não encontrado.");
        }
    }
}
