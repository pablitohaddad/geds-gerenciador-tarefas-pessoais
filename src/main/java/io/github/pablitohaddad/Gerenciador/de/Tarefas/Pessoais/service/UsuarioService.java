package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.service;

import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto.UsuarioCreateDTO;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto.UsuarioResponseDTO;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto.UsuarioUpdateDTO;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.exception.EmailDuplicadoException;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.exception.UsuarioNaoEncontradoException;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.model.Usuario;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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
        usuario.setNome(usuarioDTO.getNome());
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

    public List<UsuarioResponseDTO> buscarTodos() {
        var transaction = usuarioRepository.findAll();
        var stream = transaction.stream();

        return stream.map(this::convertParaDTO).toList();
    }

    public boolean deletarUsuario (Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário com id não existe"));


        usuario.setNome(usuarioUpdateDTO.getNome());
        usuario.setTelefone(usuarioUpdateDTO.getTelefone());

        Usuario salvo = usuarioRepository.save(usuario);
        return convertParaDTO(salvo);
    }
}

