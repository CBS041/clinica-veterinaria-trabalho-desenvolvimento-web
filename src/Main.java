import controller.AnimalController;
import controller.TutorController;
import view.AnimalView;
import view.TutorView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        TutorController tutorController = new TutorController();
        AnimalController animalController = new AnimalController();

        
        TutorView tutorView = new TutorView(tutorController);
        AnimalView animalView = new AnimalView(animalController, tutorController);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=================================");
            System.out.println("    SISTEMA CLINICA VETERINÁRIA  ");
            System.out.println("=================================");
            System.out.println("1 - Menu de Tutores");
            System.out.println("2 - Menu de Animais");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha o módulo: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao == 1) {
                    tutorView.exibirMenu();
                } else if (opcao == 2) {
                    animalView.exibirMenu();
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
            }
        }
        System.out.println("Sistema encerrado.");
        scanner.close();
    }
}
