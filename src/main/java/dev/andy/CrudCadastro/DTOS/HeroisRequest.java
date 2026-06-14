package dev.andy.CrudCadastro.DTOS;

import dev.andy.CrudCadastro.ENTITYS.Herois;
import dev.andy.CrudCadastro.ENUMS.Classes;

public record HeroisRequest(
        long id,
        String nome,
        Classes classe,
        String email,
        Integer potuacao
) {

    public Herois toEntity() {
        Herois entity = new Herois();
        preencher(entity);
        return entity;

    }

       public void preencher(Herois herois){
           herois.setId(id);
           herois.setNome(nome);
           herois.setClasse(classe);
           herois.setEmail(email);
           herois.setPontuacao(potuacao);

       }
}
