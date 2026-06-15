import controller.AnimalController;
import controller.FuncionarioController;
import controller.LogController;
import controller.PersistenciaController;
import controller.RelatorioController;
import controller.TutorController;
import controller.VeterinarioController;
import controller.ConsultaController;
import controller.VacinacaoController;

import view.AnimalView;
import view.FuncionarioView;
import view.LogView;
import view.PersistenciaView;
import view.RelatorioView;
import view.TutorView;
import view.VeterinarioView;
import view.ConsultaView;
import view.VacinacaoView;

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
        VacinacaoController vacinacaoController = new VacinacaoController();
        PersistenciaController persistenciaController = new PersistenciaController();
        LogController logController = new LogController();
        RelatorioController relatorioController =
                new RelatorioController(
                        tutorController,
                        animalController,
                        consultaController,
                        vacinacaoController,
                        persistenciaController,
                        logController
                );

        logController.registrarLog("INFO", "Sistema iniciado");

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

        VacinacaoView vacinacaoView =
                new VacinacaoView(
                        vacinacaoController,
                        scanner
                );

        RelatorioView relatorioView =
                new RelatorioView(
                        relatorioController,
                        scanner
                );

        PersistenciaView persistenciaView =
                new PersistenciaView(
                        persistenciaController,
                        scanner
                );

        LogView logView =
                new LogView(
                        logController,
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
            System.out.println("6 - Menu de Vacinações");
            System.out.println("7 - Menu de Relatórios");
            System.out.println("8 - Menu de Persistência");
            System.out.println("9 - Menu de Logs");
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

                } else if (opcao == 6) {

                    vacinacaoView.exibirMenu();

                } else if (opcao == 7) {

                    relatorioView.exibirMenu();

                } else if (opcao == 8) {

                    persistenciaView.exibirMenu();

                } else if (opcao == 9) {

                    logView.exibirMenu();

                } else if (opcao != 0) {

                    System.out.println("Opção inválida!");
                }

            } catch (Exception e) {

                System.out.println("Opção inválida!");
            }
        }

        logController.registrarLog("INFO", "Sistema encerrado");
        System.out.println("Sistema encerrado.");
        scanner.close();
    }
}
