package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.controller;

import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto.UsuarioDTO;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.model.Usuario;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Usuario", description = "Endpoints de usuários do sistema")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(
            summary = "Realiza o cadastro de usuários no sistema",
            description = "O endpoint recebe um UsuarioDTO para a inserção dos usuários no banco de dados. Você deve passar o nome e o email"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação de inserção realizada com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Parametros invalidos."),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor.")
    })
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        Usuario novoUsuario = usuarioService.criarUsuario(usuarioDTO);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }
    // Get By id

    // Get All
    // Put
    // Delete

}
