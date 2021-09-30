package br.com.alura.forum.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}")
	private String expiration;

	@Value("${forum.jwt.secret}")
	private String secret;

	public String generateToken(Authentication authentication) {

		User user = (User) authentication.getPrincipal();
		Date now = new Date();
		Date expirationDate = new Date(now.getTime() + Long.parseLong(expiration));

		return Jwts.builder().setIssuer("API do Fórum da Alura").setSubject(user.getId().toString()).setIssuedAt(now)
				.setExpiration(expirationDate).signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public boolean isTokenValid(String token) {

		if (token == null || token.isEmpty())
			return false;
		else {

			try {

				Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);

				return true;

			} catch (ExpiredJwtException e) {

				return false;
			}
		}
	}

	public Long getUserId(String token) {

		Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
		
		System.out.println(claims.getSubject());
		
		return Long.parseLong(claims.getSubject());
	}
}
