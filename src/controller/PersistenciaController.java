package controller;

import model.Persistencia;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class PersistenciaController {
    private List<Persistencia> registros = new ArrayList<>();
    private int contadorId = 1;
    private Path arquivo = Paths.get("dados", "persistencia.txt");

    public void cadastrarPersistencia(Persistencia persistencia) {
        persistencia.setId(contadorId++);
        registros.add(persistencia);
    }

    public List<Persistencia> listarPersistencias() {
        return registros;
    }

    public Persistencia buscarPorId(int id) {
        for (Persistencia p : registros) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean alterarPersistencia(int id, String chave, String valor) {
        Persistencia p = buscarPorId(id);
        if (p != null) {
            p.setChave(chave);
            p.setValor(valor);
            p.setDataRegistro(gerarDataHoraAtual());
            return true;
        }
        return false;
    }

    public boolean excluirPersistencia(int id) {
        Persistencia p = buscarPorId(id);
        if (p != null) {
            registros.remove(p);
            return true;
        }
        return false;
    }

    public boolean salvarEmArquivo() {
        try {
            Files.createDirectories(arquivo.getParent());
            List<String> linhas = new ArrayList<>();
            for (Persistencia registro : registros) {
                linhas.add(serializar(registro));
            }
            Files.write(arquivo, linhas, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean carregarDoArquivo() {
        if (!Files.exists(arquivo)) {
            return false;
        }

        try {
            List<String> linhas = Files.readAllLines(arquivo, StandardCharsets.UTF_8);
            List<Persistencia> registrosCarregados = new ArrayList<>();
            int maiorId = 0;

            for (String linha : linhas) {
                if (linha.trim().isEmpty()) {
                    continue;
                }

                Persistencia registro = desserializar(linha);
                registrosCarregados.add(registro);

                if (registro.getId() > maiorId) {
                    maiorId = registro.getId();
                }
            }

            registros.clear();
            registros.addAll(registrosCarregados);
            contadorId = maiorId + 1;
            return true;
        } catch (IOException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getCaminhoArquivo() {
        return arquivo.toString();
    }

    public String gerarDataHoraAtual() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    private String serializar(Persistencia registro) {
        return registro.getId() + "|" +
                codificar(registro.getChave()) + "|" +
                codificar(registro.getValor()) + "|" +
                codificar(registro.getDataRegistro());
    }

    private Persistencia desserializar(String linha) {
        String[] partes = linha.split("\\|", -1);
        if (partes.length != 4) {
            throw new IllegalArgumentException("Registro inválido");
        }

        Persistencia registro = new Persistencia(
                decodificar(partes[1]),
                decodificar(partes[2]),
                decodificar(partes[3])
        );
        registro.setId(Integer.parseInt(partes[0]));
        return registro;
    }

    private String codificar(String valor) {
        return Base64.getEncoder()
                .encodeToString(valor.getBytes(StandardCharsets.UTF_8));
    }

    private String decodificar(String valor) {
        return new String(
                Base64.getDecoder().decode(valor),
                StandardCharsets.UTF_8
        );
    }
}
