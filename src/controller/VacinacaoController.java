package controller;

import model.Vacinacao;

import java.util.ArrayList;
import java.util.List;

public class VacinacaoController {
    private List<Vacinacao> bancoVacinacoes = new ArrayList<>();
    private int contadorId = 1;

    public void cadastrarVacinacao(Vacinacao vacinacao) {
        vacinacao.setId(contadorId++);
        bancoVacinacoes.add(vacinacao);
    }

    public List<Vacinacao> listarVacinacoes() {
        return bancoVacinacoes;
    }

    public Vacinacao buscarPorId(int id) {
        for (Vacinacao v : bancoVacinacoes) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public boolean alterarVacinacao(int id,
                                    String nomeAnimal,
                                    String nomeVacina,
                                    String dataAplicacao,
                                    String proximaDose,
                                    String veterinarioResponsavel) {
        Vacinacao v = buscarPorId(id);
        if (v != null) {
            v.setNomeAnimal(nomeAnimal);
            v.setNomeVacina(nomeVacina);
            v.setDataAplicacao(dataAplicacao);
            v.setProximaDose(proximaDose);
            v.setVeterinarioResponsavel(veterinarioResponsavel);
            return true;
        }
        return false;
    }

    public boolean excluirVacinacao(int id) {
        Vacinacao v = buscarPorId(id);
        if (v != null) {
            bancoVacinacoes.remove(v);
            return true;
        }
        return false;
    }
}
