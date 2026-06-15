package controller;

import model.LogSistema;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogController {
    private List<LogSistema> logs = new ArrayList<>();
    private int contadorId = 1;

    public void registrarLog(String nivel, String mensagem) {
        LogSistema log = new LogSistema(gerarDataHoraAtual(), nivel, mensagem);
        log.setId(contadorId++);
        logs.add(log);
    }

    public List<LogSistema> listarLogs() {
        return logs;
    }

    public LogSistema buscarPorId(int id) {
        for (LogSistema log : logs) {
            if (log.getId() == id) {
                return log;
            }
        }
        return null;
    }

    public boolean alterarLog(int id, String nivel, String mensagem) {
        LogSistema log = buscarPorId(id);
        if (log != null) {
            log.setNivel(nivel);
            log.setMensagem(mensagem);
            return true;
        }
        return false;
    }

    public boolean excluirLog(int id) {
        LogSistema log = buscarPorId(id);
        if (log != null) {
            logs.remove(log);
            return true;
        }
        return false;
    }

    public void limparLogs() {
        logs.clear();
    }

    private String gerarDataHoraAtual() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
