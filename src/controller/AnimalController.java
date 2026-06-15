package controller;

import model.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalController {
    private List<Animal> bancoAnimais = new ArrayList<>();
    private int contadorId = 1;

    public void cadastrarAnimal(Animal animal) {
        animal.setId(contadorId++);
        bancoAnimais.add(animal);
    }

    public List<Animal> listarAnimais() {
        return bancoAnimais;
    }

    public boolean alterarAnimal(int id, String novoNome, int novaIdade) {
        for (Animal a : bancoAnimais) {
            if (a.getId() == id) {
                a.setNome(novoNome);
                a.setIdade(novaIdade);
                return true;
            }
        }
        return false;
    }

    public boolean excluirAnimal(int id) {
        for (int i = 0; i < bancoAnimais.size(); i++) {
            if (bancoAnimais.get(i).getId() == id) {
                bancoAnimais.remove(i);
                return true;
            }
        }
        return false;
    }
}