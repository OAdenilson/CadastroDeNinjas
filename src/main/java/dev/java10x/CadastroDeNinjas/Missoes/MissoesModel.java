package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.Controller.Service.NinjaModel;
import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.util.List;

@Enabled
@Table (name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;


   // Uma missao pode ter varios ninjas uma Lista de ninjas
   @OneToMany(mappedBy = "missoes")
   private List<NinjaModel> ninjas;

}
