package br.com.ekan.plano.service;

import br.com.ekan.plano.entity.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public static final String TOKEN_SECRET = "ff31df96-57ed-48e7-be32-3afb44706005";
    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("Beneficiario")
                .withSubject(usuario.getLogin())
                .withClaim("id",usuario.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(2)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC512(TOKEN_SECRET));
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC512(TOKEN_SECRET))
                .withIssuer("Beneficiario")
                .build().verify(token).getSubject();
    }
}
