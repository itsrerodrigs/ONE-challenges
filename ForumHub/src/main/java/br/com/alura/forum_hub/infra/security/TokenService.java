package br.com.alura.forum_hub.infra.security;

import br.com.alura.forum_hub.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
@Value("@{api.security.token.secret}")
private String secret;

private static final String ISSUER = "Forum api";

private Instant dataExpiracao(){
    return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
}


    public String gerarToken(Usuario usuario){
        try{
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar token jwt: ", e);
        }
    }

    public String getSubject (String tokenJWT){
    try{
        var algoritmo = Algorithm.HMAC256(secret);
        return JWT.require(algoritmo)
                .withIssuer(ISSUER)
                .build()
                .verify(tokenJWT)
                .getSubject();
    } catch (JWTVerificationException e){
        throw new RuntimeException("Token inválido ou expirado" + tokenJWT);
    }
    }
}
