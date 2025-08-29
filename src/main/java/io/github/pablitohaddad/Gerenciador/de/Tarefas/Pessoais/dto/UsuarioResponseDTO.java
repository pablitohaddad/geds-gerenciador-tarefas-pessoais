package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioResponseDTO {
    private String nome;
    private String email;
    private LocalDateTime dataNascimento;
    private String telefone;
}
