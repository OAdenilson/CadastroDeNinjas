package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;
    private int ok;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas a quem acessa ela")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota !";
    }


    // Adicionar Ninja (Create)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso : " + novoNinja.getNome() + "(id): " + novoNinja.getId());

    }

    //Mostrar todos os  Ninjas (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok()
                .body(ninjas);
    }

    // Mostrar Ninjas por Id (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista o ninja por Id", description = "Rota lista um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "rota encontrada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado")
    })
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id) {
        NinjaModel ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" Ninja com o id : " + id + " nao encontrado nos nossos resgistros ");
        }
    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por Id", description = "Rota altera um ninja pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
    public ResponseEntity<?> alterarNinjasPorID(
            @Parameter(description = "Usuario mando o id no caminho da requisicao")
            @PathVariable Long id,
            @Parameter(description = "Usuario mando os dados do ninja a ser atualizado no corpo da requisicao")
            @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaModel ninja = ninjaService.atualizarNinja(id, ninjaAtualizado);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" O ninja com id " + id + " nao foi encontrado nos nossos resgistros ");
        }
    }


    //Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjasPorID(@PathVariable Long id) {

        if (ninjaService.listarNinjasPorId(id) != null) {
            ninjaService.deletarNinjasPorId(id);
            return ResponseEntity.ok()
                    .body("Ninja com o ID " + id + " deletado com sucesso ");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o ID " + id + " nao foi encontrado .");
        }
    }

}
