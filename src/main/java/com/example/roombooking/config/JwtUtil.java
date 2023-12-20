package com.example.roombooking.config;

import java.sql.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	
	public static final String SECRET_KEY="secretkey";
	public static final long EXPIRATION_TIME=860000;
	
	public static String generateToken(String Username) {
		return Jwts.builder()
				.setSubject(Username)
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();
	}
	
	public static String EctractUsername(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}

}
