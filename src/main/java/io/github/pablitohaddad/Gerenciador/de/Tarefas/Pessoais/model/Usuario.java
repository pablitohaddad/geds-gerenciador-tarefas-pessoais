package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private LocalDateTime dataNascimento;

    private String telefone;

    private LocalDateTime dataCadastro;

    public Usuario(String nome, String email, LocalDateTime dataNascimento, String telefone, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
    }
}
