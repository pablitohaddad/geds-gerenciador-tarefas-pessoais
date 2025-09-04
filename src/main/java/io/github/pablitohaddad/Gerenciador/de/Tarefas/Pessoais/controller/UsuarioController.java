package io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.controller;

import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto.UsuarioCreateDTO;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.dto.UsuarioResponseDTO;
import io.github.pablitohaddad.Gerenciador.de.Tarefas.Pessoais.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody UsuarioCreateDTO usuarioDTO){
        UsuarioResponseDTO responseDTO = usuarioService.convertParaDTO(usuarioService.criarUsuario(usuarioDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}") // localhost:8080/usuarios/2
    public ResponseEntity<UsuarioResponseDTO> getUsuarioById(@PathVariable Long id){
        UsuarioResponseDTO usuarioDTO = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @Operation(
        summary = "Retorna todos os usuarios do sistema",
        description = ""
    )
    @GetMapping("/all") // localhost:8080/usuarios/all
    public ResponseEntity<List<UsuarioResponseDTO>> getAll(){
        List<UsuarioResponseDTO> usuarios = usuarioService.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }
    
    // Put
    // Delete

}
