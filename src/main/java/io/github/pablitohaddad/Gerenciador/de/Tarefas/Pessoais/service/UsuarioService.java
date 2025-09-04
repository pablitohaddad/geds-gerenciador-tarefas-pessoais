package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.service;

import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto.UsuarioCreateDTO;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto.UsuarioResponseDTO;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.exception.EmailDuplicadoException;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.exception.UsuarioNaoEncontradoException;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.model.Usuario;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(UsuarioCreateDTO usuarioDTO) {

        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()).isPresent()){ // true
            throw new EmailDuplicadoException("Email já cadastrado");
        }
        Usuario usuario = new Usuario();
        usuario.setNome(usuario.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setTelefone(usuarioDTO.getTelefone());
        usuario.setDataNascimento(usuarioDTO.getDataNascimento());
        usuario.setDataCadastro(LocalDateTime.now());

        return usuarioRepository.save(usuario);
    }

    public UsuarioResponseDTO buscarPorId(Long id) {
        return usuarioRepository.findById(id).map(this::convertParaDTO)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuario com id não existe"));
    }

    public UsuarioResponseDTO convertParaDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getDataNascimento(),
                usuario.getTelefone()
        );
    }
    public boolean deletarUsuario(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if(usuario.isPresent()){
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
