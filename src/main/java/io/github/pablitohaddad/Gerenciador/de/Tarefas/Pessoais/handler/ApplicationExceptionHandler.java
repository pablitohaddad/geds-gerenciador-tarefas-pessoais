package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.handler;

import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.exception.EmailDuplicadoException;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.exception.UsuarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(EmailDuplicadoException.class)
    public ResponseEntity<Map<String, String>> handleEmailDuplicadoException(EmailDuplicadoException ex){
        String msg = "Email já encontrado no sistema, faça com outro email";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", msg));
    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException ex){
        String msg = "Usuario com esse id não encontrado";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", msg));
    }

}
