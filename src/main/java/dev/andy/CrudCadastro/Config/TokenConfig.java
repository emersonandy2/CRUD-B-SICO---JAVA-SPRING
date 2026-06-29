package dev.andy.CrudCadastro.Config;


import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.algorithms.Algorithm;
import dev.andy.CrudCadastro.ENTITYS.UserLogin;
import org.springframework.stereotype.Component;

import java.time.Instant;


@Component
public class TokenConfig {


    private final String secret = "secret";
    private final Algorithm algorithm = Algorithm.HMAC256(secret);

    public String generateToken(UserLogin userLogin) {
        return JWT.create()
                .withClaim("UserId", userLogin.getId())
                .withSubject(userLogin.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(600))
                .withIssuedAt(Instant.now())
                .sign(algorithm);

    }

    public String validateToken(String token) {
        try {
            return JWT.require(algorithm)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            return null;
        }
    }
}
