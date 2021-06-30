package com.onlineclass.tibet_online_class.utils;

import com.onlineclass.tibet_online_class.model.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * JWT tool class
 * ----the produced JWT can be decrypted with base64
 * ----can't decode if the payload is change
 * ----the issued toke can't be changed unless the key is changed
 */

public class JWTUtils {

    /**
     * expiration of token duration
     */
    private static final long EXPIRATION = 60000 * 60 * 24 * 7;
 //   private static final long EXPIRATION = 1;

    /**
     * private key
     */
   private static final String SECRET ="onlineClass123";

    /**
     * token prefix String
     */
   private static final String TOKEN_PREFIX = "onlineClass";

    /**
     * subject of Token
     */
   private static final String SUBJECT = "onlineClass";


    /**
     * generating token the bases of your info
     * @param user
     * @return
     */
    public static String generateJsonToken(User user){
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img", user.getHeadImg())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * method to verify the token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){

        try {

            final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();
            return claims;

        }catch ( Exception e){

            return null;

        }

    }
}
