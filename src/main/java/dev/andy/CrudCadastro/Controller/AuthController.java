package dev.andy.CrudCadastro.Controller;


import dev.andy.CrudCadastro.Config.TokenConfig;
import dev.andy.CrudCadastro.DTOS.LoginRequest;
import dev.andy.CrudCadastro.DTOS.LoginResponse;
import dev.andy.CrudCadastro.DTOS.UserRegisterResponse;
import dev.andy.CrudCadastro.DTOS.UserResisterRequest;
import dev.andy.CrudCadastro.ENTITYS.UserLogin;
import dev.andy.CrudCadastro.REPOSITORY.SecutiryRepository;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final SecutiryRepository secutiryRepository;

    private final TokenConfig tokenConfig;
    public AuthController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, SecutiryRepository secutiryRepository, TokenConfig tokenConfig) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.secutiryRepository = secutiryRepository;
        this.tokenConfig = tokenConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        UserLogin user = (UserLogin) authentication.getPrincipal();
        String Token = tokenConfig.generateToken(user);
        return ResponseEntity.ok(new LoginResponse(Token));
    }


    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> register(@Valid @RequestBody UserResisterRequest request) {
          UserLogin userLogin = new UserLogin();
          userLogin.setPassword(passwordEncoder.encode(request.password()));
          userLogin.setEmail(request.email());
          userLogin.setLogin(request.login());

          secutiryRepository.save(userLogin);

          return ResponseEntity.ok(new UserRegisterResponse(userLogin.getLogin(), userLogin.getEmail()));

    }


}
