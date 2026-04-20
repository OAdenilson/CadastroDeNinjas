package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;


// Entity ele transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   private long id;

   private String nome;

   private String email;

   private int idade;


   // @ManytoOne --> 1 Ninja tem uma unica missao
   @ManyToOne
   @JoinColumn(name = "missoes_id")  // Foreing King ou chave estrangeira
   private MissoesModel missoes;
}
