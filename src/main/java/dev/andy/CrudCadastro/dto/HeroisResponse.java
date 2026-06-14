package dev.andy.CrudCadastro.dto;

import dev.andy.CrudCadastro.Entity.Herois;
import dev.andy.CrudCadastro.enums.Classes;

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
