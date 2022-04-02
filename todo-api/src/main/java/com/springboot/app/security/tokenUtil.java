package com.springboot.app.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class tokenUtil {

    private final  String claimSub="sub";
    private final  String claimCreated="created";

    private long tokenValidate=604800L;// 7 days in mil seconds
    @Value("${auth.secretKey}")
    private  String secretKry;



    public  String generateToken(UserDetails userDetails){

        Map<String,Object>claims=new HashMap<>();
        claims.put(claimSub,userDetails.getUsername()) ;
        claims.put(claimCreated,new Date());
        return Jwts.builder().setClaims(claims).setExpiration(generateExpiertionDate()).signWith(SignatureAlgorithm.ES512,secretKry).compact();
    }

    private Date generateExpiertionDate() {
        return  new Date(System.currentTimeMillis()+tokenValidate*1000);
    }
    public String getUserNameFromToken(String token) {
        try {
            Claims claims = getClaims(token);

            return claims.getSubject();
        }catch (Exception ex) {
            return null;
        }
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + tokenValidate * 1000);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUserNameFromToken(token);

        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }

    private Claims getClaims(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secretKry)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception ex) {
            claims = null;
        }

        return claims;
    }
}
