package view;

import controller.UsuarioController;
import model.Administrador;
import model.Cliente;
import model.Usuario;

import java.util.List;
import java.util.Scanner;

public class UsuarioView {
    private UsuarioController controller;
    private Scanner scanner;

    public UsuarioView() {
        this.controller = new UsuarioController();
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE USUÁRIOS ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Administrador");
            System.out.println("3 - Listar Usuários");
            System.out.println("4 - Alterar Usuário");
            System.out.println("5 - Excluir Usuário");
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
            case 1:
                cadastrarCliente();
                break;
            case 2:
                cadastrarAdmin();
                break;
            case 3:
                listar();
                break;
            case 4:
                alterar();
                break;
            case 5:
                excluir();
                break;
            case 0:
                System.out.println("Saindo do menu de usuários...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void cadastrarCliente() {
        System.out.println("\n--- Cadastro de Cliente ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cli = new Cliente(nome, login, senha, telefone);
        controller.cadastrarUsuario(cli);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void cadastrarAdmin() {
        System.out.println("\n--- Cadastro de Administrador ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Nível de Acesso (Ex: Total, Restrito): ");
        String nivel = scanner.nextLine();

        Administrador admin = new Administrador(nome, login, senha, nivel);
        controller.cadastrarUsuario(admin);
        System.out.println("Administrador cadastrado com sucesso!");
    }

    private void listar() {
        System.out.println("\n--- Lista de Usuários ---");
        List<Usuario> lista = controller.listarUsuarios();
        
        if (lista.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario u : lista) {
                System.out.println(u.toString());
            }
        }
    }

    private void alterar() {
        System.out.println("\n--- Alterar Usuário ---");
        System.out.print("Digite o ID do usuário que deseja alterar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Senha: ");
        String senha = scanner.nextLine();

        boolean sucesso = controller.alterarUsuario(id, nome, senha);
        if (sucesso) {
            System.out.println("Usuário alterado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private void excluir() {
        System.out.println("\n--- Excluir Usuário ---");
        System.out.print("Digite o ID do usuário que deseja excluir: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean sucesso = controller.excluirUsuario(id);
        if (sucesso) {
            System.out.println("Usuário excluído com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
}