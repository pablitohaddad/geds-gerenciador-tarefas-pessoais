package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EmailDuplicadoException extends RuntimeException{
    public EmailDuplicadoException(String msg) {
        super(msg);
    }

}
