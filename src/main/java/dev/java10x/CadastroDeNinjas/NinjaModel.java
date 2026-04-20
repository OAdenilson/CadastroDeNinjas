package dev.java10x.CadastroDeNinjas;

import jakarta.persistence.*;


// Entity ele transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nome;
    String email;
    int idade;
}
