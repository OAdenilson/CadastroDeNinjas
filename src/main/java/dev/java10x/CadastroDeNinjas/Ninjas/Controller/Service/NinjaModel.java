package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {
   // seus campos aqui, ex:
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nome;
   private String email;
   private String imgUrl;
   private int idade;
   private String rank;

   @ManyToOne
   private MissoesModel missoes;
}