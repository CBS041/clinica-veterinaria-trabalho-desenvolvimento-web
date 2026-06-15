package controller;

import model.Tutor;
import java.util.ArrayList;
import java.util.List;

public class TutorController {
    private List<Tutor> bancoTutores = new ArrayList<>();
    private int contadorId = 1;

    public void cadastrarTutor(Tutor tutor) {
        tutor.setId(contadorId++);
        bancoTutores.add(tutor);
    }

    public List<Tutor> listarTutores() {
        return bancoTutores;
    }

    public Tutor buscarPorId(int id) {
        for (Tutor t : bancoTutores) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null; // Retorna null se não encontrar
    }

    public boolean alterarTutor(int id, String novoNome, String novoTelefone) {
        Tutor t = buscarPorId(id);
        if (t != null) {
            t.setNome(novoNome);
            t.setTelefone(novoTelefone);
            return true;
        }
        return false;
    }

    public boolean excluirTutor(int id) {
        Tutor t = buscarPorId(id);
        if (t != null) {
            bancoTutores.remove(t);
            return true;
        }
        return false;
    }
}