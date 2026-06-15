package controller;

import model.Prontuario;

import java.util.ArrayList;

public class ProntuarioController {

    private ArrayList<Prontuario> prontuarios =
            new ArrayList<>();

    public void cadastrarProntuario(
            Prontuario prontuario) {

        prontuarios.add(prontuario);

        System.out.println(
                "Prontuário cadastrado!"
        );
    }

    public void listarProntuarios() {

        if(prontuarios.isEmpty()) {

            System.out.println(
                    "Nenhum prontuário cadastrado."
            );

            return;
        }

        for(Prontuario p : prontuarios) {

            System.out.println(p);
        }
    }
}
