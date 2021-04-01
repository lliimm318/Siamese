package kr.hs.entrydsm.common.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import kr.hs.entrydsm.common.exception.TokenInvalidException;
import kr.hs.entrydsm.common.exception.TokenTypeInvalidException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@RequiredArgsConstructor
@Component
public class JWTResolver {
    @Value("${auth.jwt.secret_key}")
    private String secretKey;

    public String generateAccessToken(String clubId) {
        return JWTBuild(JWTType.CLUB_ACCESS_TOKEN, clubId);
    }

    public String generateRefreshToken(String clubId) {
        return JWTBuild(JWTType.CLUB_REFRESH_TOKEN, clubId);
    }

    private String JWTBuild(JWTType type, String clubId) {
        return Jwts.builder().setIssuedAt(new Date())
                             .setExpiration(type.getExpiration())
                             .setSubject(clubId)
                             .claim("type", type)
                             .signWith(SignatureAlgorithm.HS256, secretKey)
                             .compact();
    }

    public Claims parseAccessToken(String token) {
        return parseToken(JWTType.CLUB_ACCESS_TOKEN, token);
    }

    public Claims parseRefreshToken(String token) {
        return parseToken(JWTType.CLUB_REFRESH_TOKEN, token);
    }

    private Claims parseToken(JWTType type, String token) {
        Claims parsed;
        try {
            parsed = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            throw new TokenInvalidException();
        }
        if (!(parsed.get("type").equals(type.toString()))) { throw new TokenTypeInvalidException(); }
        return parsed;
    }
}
