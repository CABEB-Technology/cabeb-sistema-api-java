package br.com.cabeb.api.java.service;

import br.com.cabeb.api.java.entity.Usuario;

import java.util.List;

public interface IUsuarioService {

    List<Usuario> obterTodosUsuarios();
    Usuario obterUsuarioPorId(Long id);
    Usuario obterUsuarioPorEmail(String email);
    Usuario criarUsuario(Usuario usuario);
    void deletarUsuario(Long id);
}
