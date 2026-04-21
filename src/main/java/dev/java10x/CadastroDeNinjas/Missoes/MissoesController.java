package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    // GET --> mandar uma requisicao para Mostrar as missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missoes listada com sucesso ";
    }

    // POST --> Mandar uma requisicao para Criar uma missao
    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao criada com sucesso";
    }

    // Put --> Mandar uma requisecao para Alterar uma missao
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao alterada com sucesso";
    }


   // DELETE --> Mandar uma requisicao para Deletar uma missao
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao deletada com sucesso";
    }

}
