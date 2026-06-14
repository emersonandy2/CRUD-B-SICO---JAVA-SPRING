package dev.andy.CrudCadastro.repository;

import dev.andy.CrudCadastro.Entity.Herois;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroisRepository extends JpaRepository<Herois, Long> {

}
