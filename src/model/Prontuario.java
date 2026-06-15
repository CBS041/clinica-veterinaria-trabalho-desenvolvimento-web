package model;

import java.io.Serializable;

    public class Prontuario implements Serializable {

        private String nomeAnimal;
        private String diagnostico;
        private String tratamento;
        private String observacoes;

        public Prontuario(String nomeAnimal,
                          String diagnostico,
                          String tratamento,
                          String observacoes) {

            this.nomeAnimal = nomeAnimal;
            this.diagnostico = diagnostico;
            this.tratamento = tratamento;
            this.observacoes = observacoes;
        }

        public String getNomeAnimal() {
            return nomeAnimal;
        }

        public String getDiagnostico() {
            return diagnostico;
        }

        public String getTratamento() {
            return tratamento;
        }

        public String getObservacoes() {
            return observacoes;
        }

        public String toString() {

            return "\nAnimal: " + nomeAnimal +
                    "\nDiagnóstico: " + diagnostico +
                    "\nTratamento: " + tratamento +
                    "\nObservações: " + observacoes;
        }
    }

