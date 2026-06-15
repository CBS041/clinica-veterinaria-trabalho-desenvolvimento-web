package controller;

import model.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    
    private List<Usuario> bancoUsuarios = new ArrayList<>();
    private int contadorId = 1;

    // 1. Cadastrar
    public void cadastrarUsuario(Usuario usuario) {
        usuario.setId(contadorId++); 
        bancoUsuarios.add(usuario);
    }

    
    public List<Usuario> listarUsuarios() {
        return bancoUsuarios;
    }

  
    public boolean alterarUsuario(int id, String novoNome, String novaSenha) {
        for (Usuario u : bancoUsuarios) {
            if (u.getId() == id) {
                u.setNome(novoNome);
                u.setSenha(novaSenha);
                return true; 
            }
        }
        return false; 
    }

   
    public boolean excluirUsuario(int id) {
        for (int i = 0; i < bancoUsuarios.size(); i++) {
            if (bancoUsuarios.get(i).getId() == id) {
                bancoUsuarios.remove(i);
                return true; 
            }
        }
        return false; 
    }
}
