package controller;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    // Simulando um banco de dados em memória
    private List<Usuario> bancoUsuarios = new ArrayList<>();
    private int contadorId = 1; // Para gerar IDs automáticos

    // 1. Cadastrar
    public void cadastrarUsuario(Usuario usuario) {
        usuario.setId(contadorId++); // Atribui um ID e incrementa
        bancoUsuarios.add(usuario);
    }

    // 2. Listar
    public List<Usuario> listarUsuarios() {
        return bancoUsuarios;
    }

    // 3. Alterar (Busca pelo ID e atualiza os dados básicos)
    public boolean alterarUsuario(int id, String novoNome, String novaSenha) {
        for (Usuario u : bancoUsuarios) {
            if (u.getId() == id) {
                u.setNome(novoNome);
                u.setSenha(novaSenha);
                return true; // Alterado com sucesso
            }
        }
        return false; // Usuário não encontrado
    }

    // 4. Excluir
    public boolean excluirUsuario(int id) {
        for (int i = 0; i < bancoUsuarios.size(); i++) {
            if (bancoUsuarios.get(i).getId() == id) {
                bancoUsuarios.remove(i);
                return true; // Excluído com sucesso
            }
        }
        return false; // Usuário não encontrado
    }
}