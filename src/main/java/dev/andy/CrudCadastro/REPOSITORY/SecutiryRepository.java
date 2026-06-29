package dev.andy.CrudCadastro.REPOSITORY;

import dev.andy.CrudCadastro.ENTITYS.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecutiryRepository extends JpaRepository<UserLogin, Long> {

        Optional<UserDetails> findUserLoginByEmail(String email);

}
