package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.service;

import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto.UsuarioDTO;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.model.Usuario;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        // Usuario que já tem ID e Data Cadastros automaticos
        // UsuarioDTO que esta setando nome e email
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        return usuarioRepository.save(usuario);
    }
}
