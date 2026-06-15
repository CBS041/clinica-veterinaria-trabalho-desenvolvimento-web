package controller;

import model.Consulta;

import java.util.ArrayList;
import java.util.List;

public class ConsultaController {

    private ArrayList<Consulta> consultas =
            new ArrayList<>();

    public void agendarConsulta(
            Consulta consulta) {

        consultas.add(consulta);

        System.out.println(
                "Consulta agendada com sucesso!"
        );
    }

    public void listarConsultas() {

        if (consultas.isEmpty()) {

            System.out.println(
                    "Nenhuma consulta cadastrada."
            );

            return;
        }

        for (int i = 0; i < consultas.size(); i++) {

            System.out.println(
                    (i + 1) + " - " +
                            consultas.get(i)
            );
        }
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void cancelarConsulta(
            int indice) {

        if (indice >= 0 &&
                indice < consultas.size()) {

            consultas.remove(indice);

            System.out.println(
                    "Consulta cancelada."
            );
        } else {

            System.out.println(
                    "Consulta não encontrada."
            );
        }
    }

    public void alterarConsulta(
            int indice,
            String novaData,
            String novoHorario) {

        if (indice >= 0 &&
                indice < consultas.size()) {

            consultas.get(indice)
                    .setData(novaData);

            consultas.get(indice)
                    .setHorario(novoHorario);

            System.out.println(
                    "Consulta alterada."
            );
        } else {

            System.out.println(
                    "Consulta não encontrada."
            );
        }
    }
}
