package view;

import controller.FuncionarioController;
import model.Funcionario;
import java.util.List;
import java.util.Scanner;

public class FuncionarioView {
    private FuncionarioController controller;
    private Scanner scanner;

    public FuncionarioView(FuncionarioController controller) {
        this(controller, new Scanner(System.in));
    }

    public FuncionarioView(FuncionarioController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE FUNCIONÁRIOS ===");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Listar Funcionários");
            System.out.println("3 - Alterar Funcionário");
            System.out.println("4 - Excluir Funcionário");
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
            case 0: System.out.println("Saindo do menu de funcionários..."); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private void cadastrar() {
        System.out.println("\n--- Cadastro de Funcionário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Setor: ");
        String setor = scanner.nextLine();

        Funcionario funcionario = new Funcionario(nome, cpf, telefone, cargo, setor);
        controller.cadastrarFuncionario(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    private void listar() {
        System.out.println("\n--- Lista de Funcionários ---");
        List<Funcionario> lista = controller.listarFuncionarios();
        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : lista) {
                System.out.println(f.toString());
            }
        }
    }

    private void alterar() {
        System.out.println("\n--- Alterar Funcionário ---");
        System.out.print("Digite o ID do funcionário: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Novo Cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Novo Setor: ");
        String setor = scanner.nextLine();

        if (controller.alterarFuncionario(id, nome, telefone, cargo, setor)) {
            System.out.println("Funcionário alterado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private void excluir() {
        System.out.println("\n--- Excluir Funcionário ---");
        System.out.print("Digite o ID do funcionário: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (controller.excluirFuncionario(id)) {
            System.out.println("Funcionário excluído com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }
}
