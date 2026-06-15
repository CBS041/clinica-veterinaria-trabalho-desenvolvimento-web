package controller;

import model.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private List<Funcionario> bancoFuncionarios = new ArrayList<>();
    private int contadorId = 1;

    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionario.setId(contadorId++);
        bancoFuncionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return bancoFuncionarios;
    }

    public Funcionario buscarPorId(int id) {
        for (Funcionario f : bancoFuncionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public boolean alterarFuncionario(int id, String novoNome, String novoTelefone, String novoCargo, String novoSetor) {
        Funcionario f = buscarPorId(id);
        if (f != null) {
            f.setNome(novoNome);
            f.setTelefone(novoTelefone);
            f.setCargo(novoCargo);
            f.setSetor(novoSetor);
            return true;
        }
        return false;
    }

    public boolean excluirFuncionario(int id) {
        Funcionario f = buscarPorId(id);
        if (f != null) {
            bancoFuncionarios.remove(f);
            return true;
        }
        return false;
    }
}
