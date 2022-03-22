package com.idip.idiptecnologia.security.JWT;

import com.idip.idiptecnologia.models.entities.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService{
    @Value("${security.jwt.key-word}")
    private String jwtSecret;

    @Value("${security.jwt.expire}")
    private Long jwtExpiration;

    public String generateJwtToken(UserModel user) {
        // calc to expiration token
        long expString = Long.valueOf(jwtExpiration);
        LocalDateTime dateToExpire = LocalDateTime.now().plusMinutes(expString);
        Instant instant = dateToExpire.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        // end calc

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userEmail:", user.getUserEmail());
        claims.put("userType:", user.getUserType());
        claims.put("userImage:", user.getUserImage());

        return Jwts.builder()
                   .setSubject(user.getUserName())
                   .setExpiration(date)
                   .setId(user.getId().toString())
                   .setClaims(claims)
                   .signWith(SignatureAlgorithm.HS512, jwtSecret)
                   .compact();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Claims claims = getClaims(authToken);
            Date dataExpiration = claims.getExpiration();
            LocalDateTime date = dataExpiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(date);
        } catch ( Exception e ) {
            return false;
        }
    }

    public String getLoggedUser(String token) throws ExpiredJwtException {
        return getClaims(token).getSubject();
    }

}



