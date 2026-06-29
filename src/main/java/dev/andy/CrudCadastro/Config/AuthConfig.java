package dev.andy.CrudCadastro.Config;

import dev.andy.CrudCadastro.REPOSITORY.HeroisRepository;
import dev.andy.CrudCadastro.REPOSITORY.SecutiryRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthConfig implements UserDetailsService {

    private final SecutiryRepository secutiryRepository;


    public AuthConfig(SecutiryRepository secutiryRepository) {
        this.secutiryRepository = secutiryRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return secutiryRepository.findUserLoginByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));





    }


    }
