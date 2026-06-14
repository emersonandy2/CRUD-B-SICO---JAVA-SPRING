package dev.andy.CrudCadastro.REPOSITORY;

import dev.andy.CrudCadastro.ENTITYS.Herois;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroisRepository extends JpaRepository<Herois, Long> {

    boolean existsByEmail(String email);


}
