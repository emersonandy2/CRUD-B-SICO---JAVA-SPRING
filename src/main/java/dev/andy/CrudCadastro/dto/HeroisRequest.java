package dev.andy.CrudCadastro.dto;

import dev.andy.CrudCadastro.Entity.Herois;
import dev.andy.CrudCadastro.enums.Classes;
import dev.andy.CrudCadastro.repository.HeroisRepository;

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
