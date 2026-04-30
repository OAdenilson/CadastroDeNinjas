package dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "missoes")

public class NinjaModel {
   // seus campos aqui, ex:
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

   @Column (name = "id")
   private Long id;

   @Column (name = "nome")
   private String nome;

   @Column ( name = "email")
   private String email;

   @Column ( name = "imgUrl")
   private String imgUrl;

   @Column ( name = "idade")
   private int idade;

   @Column ( name = "rank")
   private String rank;

   @ManyToOne
   @JoinColumn ( name = "missoes_id")
   private MissoesModel missoes;
}