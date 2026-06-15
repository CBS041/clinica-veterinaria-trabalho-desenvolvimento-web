package controller;

import model.Veterinario;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioController {
    private List<Veterinario> bancoVeterinarios = new ArrayList<>();
    private int contadorId = 1;

    public void cadastrarVeterinario(Veterinario veterinario) {
        veterinario.setId(contadorId++);
        bancoVeterinarios.add(veterinario);
    }

    public List<Veterinario> listarVeterinarios() {
        return bancoVeterinarios;
    }

    public Veterinario buscarPorId(int id) {
        for (Veterinario v : bancoVeterinarios) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public boolean alterarVeterinario(int id, String novoNome, String novoTelefone, String novaEspecialidade) {
        Veterinario v = buscarPorId(id);
        if (v != null) {
            v.setNome(novoNome);
            v.setTelefone(novoTelefone);
            v.setEspecialidade(novaEspecialidade);
            return true;
        }
        return false;
    }

    public boolean excluirVeterinario(int id) {
        Veterinario v = buscarPorId(id);
        if (v != null) {
            bancoVeterinarios.remove(v);
            return true;
        }
        return false;
    }
}
