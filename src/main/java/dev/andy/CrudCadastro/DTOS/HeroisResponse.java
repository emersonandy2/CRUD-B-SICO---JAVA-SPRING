package dev.andy.CrudCadastro.DTOS;

import dev.andy.CrudCadastro.ENTITYS.Herois;
import dev.andy.CrudCadastro.ENUMS.Classes;

public record HeroisResponse(
        Long id,
        String nome,
        Classes classe,
        String email,
        Integer pontuacao
) {

   public static HeroisResponse fromEntity(Herois herois) {
       return new HeroisResponse(
               herois.getId(),
               herois.getNome(),
               herois.getClasse(),
               herois.getEmail(),
               herois.getPontuacao()
       );
   }
}
