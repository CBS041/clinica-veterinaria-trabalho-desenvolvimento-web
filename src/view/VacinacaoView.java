package view;

import controller.VacinacaoController;
import model.Vacinacao;

import java.util.List;
import java.util.Scanner;

public class VacinacaoView {
    private VacinacaoController controller;
    private Scanner scanner;

    public VacinacaoView(VacinacaoController controller) {
        this(controller, new Scanner(System.in));
    }

    public VacinacaoView(VacinacaoController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE VACINAÇÕES ===");
            System.out.println("1 - Cadastrar Vacinação");
            System.out.println("2 - Listar Vacinações");
            System.out.println("3 - Alterar Vacinação");
            System.out.println("4 - Excluir Vacinação");
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
            case 0: System.out.println("Saindo do menu de vacinações..."); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private void cadastrar() {
        System.out.println("\n--- Cadastro de Vacinação ---");
        System.out.print("Nome do Animal: ");
        String nomeAnimal = scanner.nextLine();
        System.out.print("Nome da Vacina: ");
        String nomeVacina = scanner.nextLine();
        System.out.print("Data de Aplicação: ");
        String dataAplicacao = scanner.nextLine();
        System.out.print("Próxima Dose: ");
        String proximaDose = scanner.nextLine();
        System.out.print("Veterinário Responsável: ");
        String veterinarioResponsavel = scanner.nextLine();

        Vacinacao vacinacao = new Vacinacao(
                nomeAnimal,
                nomeVacina,
                dataAplicacao,
                proximaDose,
                veterinarioResponsavel
        );

        controller.cadastrarVacinacao(vacinacao);
        System.out.println("Vacinação cadastrada com sucesso!");
    }

    private void listar() {
        System.out.println("\n--- Lista de Vacinações ---");
        List<Vacinacao> lista = controller.listarVacinacoes();
        if (lista.isEmpty()) {
            System.out.println("Nenhuma vacinação cadastrada.");
        } else {
            for (Vacinacao v : lista) {
                System.out.println(v.toString());
            }
        }
    }

    private void alterar() {
        System.out.println("\n--- Alterar Vacinação ---");
        System.out.print("Digite o ID da vacinação: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nome do Animal: ");
        String nomeAnimal = scanner.nextLine();
        System.out.print("Nome da Vacina: ");
        String nomeVacina = scanner.nextLine();
        System.out.print("Data de Aplicação: ");
        String dataAplicacao = scanner.nextLine();
        System.out.print("Próxima Dose: ");
        String proximaDose = scanner.nextLine();
        System.out.print("Veterinário Responsável: ");
        String veterinarioResponsavel = scanner.nextLine();

        if (controller.alterarVacinacao(
                id,
                nomeAnimal,
                nomeVacina,
                dataAplicacao,
                proximaDose,
                veterinarioResponsavel
        )) {
            System.out.println("Vacinação alterada com sucesso!");
        } else {
            System.out.println("Vacinação não encontrada.");
        }
    }

    private void excluir() {
        System.out.println("\n--- Excluir Vacinação ---");
        System.out.print("Digite o ID da vacinação: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (controller.excluirVacinacao(id)) {
            System.out.println("Vacinação excluída com sucesso!");
        } else {
            System.out.println("Vacinação não encontrada.");
        }
    }
}
