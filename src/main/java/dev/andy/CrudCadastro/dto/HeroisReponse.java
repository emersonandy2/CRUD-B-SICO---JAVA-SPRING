package dev.andy.CrudCadastro.dto;

import dev.andy.CrudCadastro.Entity.Herois;
import dev.andy.CrudCadastro.enums.Classes;
import jakarta.persistence.criteria.CriteriaBuilder;

public record HeroisReponse(
        Long id,
        String nome,
        Classes classe,
        String email,
        Integer pontuacao
) {

   public static HeroisReponse fromEntity(Herois herois) {
       return new HeroisReponse(
               herois.getId(),
               herois.getNome(),
               herois.getClasse(),
               herois.getEmail(),
               herois.getPontuacao()
       );
   }
}
