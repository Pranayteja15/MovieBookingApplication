package com.example.MovieBookingApplication.Jwtutil;

import java.sql.Date;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	@Value("{app.secret}")
	private String secret;

	public String generateToken( String subject) {

		return Jwts.builder().setSubject(subject).setIssuer("pranay")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(30)))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	
	public java.util.Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}
	

	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	private boolean isTokenExpired(String token) {
		final Date expiration = (Date) getExpDate(token);
		return expiration.before(new Date(System.currentTimeMillis()));
	}

	public boolean validateToken(String token, String username) {
		String usernameInToken = getUsername(token);
		return (usernameInToken.equals(username) && !isTokenExpired(token));
	}

}
