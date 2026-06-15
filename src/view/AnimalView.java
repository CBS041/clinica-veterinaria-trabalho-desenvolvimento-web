package view;

import controller.AnimalController;
import controller.TutorController;
import model.Cachorro;
import model.Gato;
import model.Tutor;
import model.Animal;

import java.util.List;
import java.util.Scanner;

public class AnimalView {
    private AnimalController animalController;
    private TutorController tutorController; 
    private Scanner scanner;

    public AnimalView(AnimalController animalController, TutorController tutorController) {
        this(animalController, tutorController, new Scanner(System.in));
    }

    public AnimalView(AnimalController animalController, TutorController tutorController, Scanner scanner) {
        this.animalController = animalController;
        this.tutorController = tutorController;
        this.scanner = scanner;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== GERENCIAMENTO DE ANIMAIS ===");
            System.out.println("1 - Cadastrar Cachorro");
            System.out.println("2 - Cadastrar Gato");
            System.out.println("3 - Listar Animais");
            System.out.println("4 - Alterar Animal");
            System.out.println("5 - Excluir Animal");
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
            case 1: cadastrarCachorro(); break;
            case 2: cadastrarGato(); break;
            case 3: listar(); break;
            case 4: alterar(); break;
            case 5: excluir(); break;
            case 0: System.out.println("Saindo do menu de animais..."); break;
            default: System.out.println("Opção inválida!");
        }
    }

    private void cadastrarCachorro() {
        System.out.println("\n--- Cadastro de Cachorro ---");
        System.out.print("Nome do Cachorro: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Raça: ");
        String raca = scanner.nextLine();
        
        System.out.print("Digite o ID do Tutor deste animal: ");
        int idTutor = Integer.parseInt(scanner.nextLine());
        Tutor tutor = tutorController.buscarPorId(idTutor);

        if (tutor == null) {
            System.out.println("Aviso: Tutor não encontrado! O animal ficará cadastrado sem tutor responsável.");
        }

        Cachorro dog = new Cachorro(nome, idade, tutor, raca);
        animalController.cadastrarAnimal(dog);
        System.out.println("Cachorro cadastrado com sucesso!");
    }

    private void cadastrarGato() {
        System.out.println("\n--- Cadastro de Gato ---");
        System.out.print("Nome do Gato: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Cor da Pelagem: ");
        String pelagem = scanner.nextLine();

        System.out.print("Digite o ID do Tutor deste animal: ");
        int idTutor = Integer.parseInt(scanner.nextLine());
        Tutor tutor = tutorController.buscarPorId(idTutor);

        if (tutor == null) {
            System.out.println("Aviso: Tutor não encontrado! O animal ficará cadastrado sem tutor responsável.");
        }

        Gato cat = new Gato(nome, idade, tutor, pelagem);
        animalController.cadastrarAnimal(cat);
        System.out.println("Gato cadastrado com sucesso!");
    }

    private void listar() {
        System.out.println("\n--- Lista de Animais Cadastrados ---");
        List<Animal> lista = animalController.listarAnimais();
        if (lista.isEmpty()) {
            System.out.println("Nenhum animal cadastrado.");
        } else {
            for (Animal a : lista) {
                System.out.println(a.toString());
            }
        }
    }

    private void alterar() {
        System.out.println("\n--- Alterar Dados do Animal ---");
        System.out.print("Digite o ID do animal: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());

        if (animalController.alterarAnimal(id, nome, idade)) {
            System.out.println("Dados do animal alterados com sucesso!");
        } else {
            System.out.println("Animal não encontrado.");
        }
    }

    private void excluir() {
        System.out.println("\n--- Excluir Animal ---");
        System.out.print("Digite o ID do animal: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (animalController.excluirAnimal(id)) {
            System.out.println("Animal excluído com sucesso!");
        } else {
            System.out.println("Animal não encontrado.");
        }
    }
}
