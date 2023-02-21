package br.com.cabeb.api.service;

import br.com.cabeb.api.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> obterTodosUsuarios();
    Usuario obterUsuarioPorId(Long id);
    Usuario obterUsuarioPorEmail(String email);
    Usuario criarUsuario(Usuario usuario);
    void deletarUsuario(Long id);
}
