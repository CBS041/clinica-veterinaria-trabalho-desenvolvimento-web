package view;

import controller.VeterinarioController;
import model.Veterinario;
import java.util.List;
import java.util.Scanner;

public class VeterinarioView {
    private VeterinarioController controller;
    private Scanner scanner;

    public VeterinarioView(VeterinarioController controller) {
        this(controller, new Scanner(System.in));
    }

    public VeterinarioView(VeterinarioController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE VETERINÁRIOS ===");
            System.out.println("1 - Cadastrar Veterinário");
            System.out.println("2 - Listar Veterinários");
            System.out.println("3 - Alterar Veterinário");
            System.out.println("4 - Excluir Veterinário");
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
            case 0: System.out.println("Saindo do menu de veterinários..."); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private void cadastrar() {
        System.out.println("\n--- Cadastro de Veterinário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("CRMV: ");
        String crmv = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        Veterinario veterinario = new Veterinario(nome, cpf, telefone, crmv, especialidade);
        controller.cadastrarVeterinario(veterinario);
        System.out.println("Veterinário cadastrado com sucesso!");
    }

    private void listar() {
        System.out.println("\n--- Lista de Veterinários ---");
        List<Veterinario> lista = controller.listarVeterinarios();
        if (lista.isEmpty()) {
            System.out.println("Nenhum veterinário cadastrado.");
        } else {
            for (Veterinario v : lista) {
                System.out.println(v.toString());
            }
        }
    }

    private void alterar() {
        System.out.println("\n--- Alterar Veterinário ---");
        System.out.print("Digite o ID do veterinário: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Nova Especialidade: ");
        String especialidade = scanner.nextLine();

        if (controller.alterarVeterinario(id, nome, telefone, especialidade)) {
            System.out.println("Veterinário alterado com sucesso!");
        } else {
            System.out.println("Veterinário não encontrado.");
        }
    }

    private void excluir() {
        System.out.println("\n--- Excluir Veterinário ---");
        System.out.print("Digite o ID do veterinário: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (controller.excluirVeterinario(id)) {
            System.out.println("Veterinário excluído com sucesso!");
        } else {
            System.out.println("Veterinário não encontrado.");
        }
    }
}
