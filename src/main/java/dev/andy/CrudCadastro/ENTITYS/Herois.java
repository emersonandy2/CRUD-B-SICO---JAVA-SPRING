package dev.andy.CrudCadastro.ENTITYS;


import dev.andy.CrudCadastro.ENUMS.Classes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Herois_db" )
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Herois {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Classes classe;


    private String email;

    private Integer pontuacao;


}
