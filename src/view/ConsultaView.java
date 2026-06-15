package view;

import controller.ConsultaController;
import model.Consulta;

import java.util.Scanner;

public class ConsultaView {

    private ConsultaController controller;
    private Scanner scanner;

    public ConsultaView(ConsultaController controller) {
        this(controller, new Scanner(System.in));
    }

    public ConsultaView(ConsultaController controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE CONSULTAS ===");
            System.out.println("1 - Agendar Consulta");
            System.out.println("2 - Listar Consultas");
            System.out.println("3 - Alterar Consulta");
            System.out.println("4 - Cancelar Consulta");
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
                cadastrar();
                break;

            case 2:
                listar();
                break;

            case 3:
                alterar();
                break;

            case 4:
                excluir();
                break;

            case 0:
                System.out.println("Saindo do menu de consultas...");
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }

    private void cadastrar() {

        System.out.println("\n--- Agendar Consulta ---");

        System.out.print("Nome do Animal: ");
        String animal = scanner.nextLine();

        System.out.print("Nome do Veterinário: ");
        String veterinario = scanner.nextLine();

        System.out.print("Data: ");
        String data = scanner.nextLine();

        System.out.print("Horário: ");
        String horario = scanner.nextLine();

        Consulta consulta =
                new Consulta(
                        animal,
                        veterinario,
                        data,
                        horario
                );

        controller.agendarConsulta(consulta);

        System.out.println("Consulta agendada com sucesso!");
    }

    private void listar() {

        System.out.println("\n--- Lista de Consultas ---");

        controller.listarConsultas();
    }

    private void alterar() {

        System.out.println("\n--- Alterar Consulta ---");

        controller.listarConsultas();

        System.out.print("Digite o número da consulta: ");
        int indice =
                Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Nova Data: ");
        String novaData =
                scanner.nextLine();

        System.out.print("Novo Horário: ");
        String novoHorario =
                scanner.nextLine();

        controller.alterarConsulta(
                indice,
                novaData,
                novoHorario
        );
    }

    private void excluir() {

        System.out.println("\n--- Cancelar Consulta ---");

        controller.listarConsultas();

        System.out.print("Digite o número da consulta: ");

        int indice =
                Integer.parseInt(scanner.nextLine()) - 1;

        controller.cancelarConsulta(indice);
    }
}