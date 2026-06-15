import controller.AnimalController;
import controller.FuncionarioController;
import controller.TutorController;
import controller.VeterinarioController;
import controller.ConsultaController;

import view.AnimalView;
import view.FuncionarioView;
import view.TutorView;
import view.VeterinarioView;
import view.ConsultaView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Controllers
        TutorController tutorController = new TutorController();
        AnimalController animalController = new AnimalController();
        VeterinarioController veterinarioController = new VeterinarioController();
        FuncionarioController funcionarioController = new FuncionarioController();
        ConsultaController consultaController = new ConsultaController();

        // Views
        TutorView tutorView =
                new TutorView(tutorController, scanner);

        AnimalView animalView =
                new AnimalView(animalController,
                        tutorController,
                        scanner);

        VeterinarioView veterinarioView =
                new VeterinarioView(veterinarioController,
                        scanner);

        FuncionarioView funcionarioView =
                new FuncionarioView(funcionarioController,
                        scanner);

        ConsultaView consultaView =
                new ConsultaView(
                        consultaController,
                        scanner
                );

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n=================================");
            System.out.println("    SISTEMA CLÍNICA VETERINÁRIA");
            System.out.println("=================================");
            System.out.println("1 - Menu de Tutores");
            System.out.println("2 - Menu de Animais");
            System.out.println("3 - Menu de Veterinários");
            System.out.println("4 - Menu de Funcionários");
            System.out.println("5 - Menu de Consultas");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha o módulo: ");

            try {

                opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 1) {

                    tutorView.exibirMenu();

                } else if (opcao == 2) {

                    animalView.exibirMenu();

                } else if (opcao == 3) {

                    veterinarioView.exibirMenu();

                } else if (opcao == 4) {

                    funcionarioView.exibirMenu();

                } else if (opcao == 5) {

                    consultaView.exibirMenu();

                } else if (opcao != 0) {

                    System.out.println("Opção inválida!");
                }

            } catch (Exception e) {

                System.out.println("Opção inválida!");
            }
        }

        System.out.println("Sistema encerrado.");
        scanner.close();
    }
}