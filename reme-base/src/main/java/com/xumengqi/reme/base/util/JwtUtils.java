package com.xumengqi.reme.base.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xumengqi
 * @date 2021/2/8 10:09
 */
@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private JwtUtils() {

    }

    public String generateToken(String sub) {
        if (sub == null || "".equals(sub.trim())) {
            throw new IllegalArgumentException("sub is blank");
        }
        Claims claims = new DefaultClaims();
        claims.setSubject(sub).setIssuedAt(new Date()).setExpiration(generateExpirationDate());
        return generateToken(claims);
    }

    public String generateToken(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public boolean validateToken(String token) {
        Claims claims = getClaimsFromToken(token);
        if (claims == null) {
            return false;
        }
        Date expiration = claims.getExpiration();
        return expiration.after(new Date());
    }

    public Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
