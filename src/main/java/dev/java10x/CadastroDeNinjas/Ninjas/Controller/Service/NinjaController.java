package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;
    private int ok;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Essa é a minha primeira mensagem nessa rota !";
    }

    // Adicionar Ninja (Create)
    @PostMapping("/criar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
       NinjaDTO novoNinja =  ninjaService.criarNinjas(ninjaDTO);
       return ResponseEntity.status(HttpStatus.CREATED)
        .body("Ninja criado com sucesso : " +  novoNinja.getNome() + "(id): " +  novoNinja.getId());

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
    public ResponseEntity<?> listarNinjasPorID(@PathVariable Long id){
        NinjaModel ninja = ninjaService.listarNinjasPorId(id);
            if(ninja != null){
             return ResponseEntity.ok(ninja);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" Ninja com o id : " + id + " nao encontrado nos nossos resgistros ");
        }
    }

    // Alterar dados dos Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarNinjasPorID(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaModel ninja = ninjaService.atualizarNinja(id , ninjaAtualizado);
        if (ninja !=null) {
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
