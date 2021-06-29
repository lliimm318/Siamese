package kr.hs.entrydsm.common.security;

import io.jsonwebtoken.Claims;
import kr.hs.entrydsm.common.exception.TokenInvalidException;
import kr.hs.entrydsm.common.security.authentication.ClubAuthentication;
import kr.hs.entrydsm.main.enitity.Club;
import kr.hs.entrydsm.main.enitity.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Component
public class AuthMiddleware implements HandlerInterceptor {
    private final JWTResolver jwtResolver;
    private final ClubRepository clubRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod)) { return true; }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Class<?> handlerClass = handlerMethod.getBeanType();

        if (handlerMethod.hasMethodAnnotation(JWTRequired.class) || handlerClass.getAnnotation(JWTRequired.class) != null) {
            accessRequired(request);
        }

        if (handlerMethod.hasMethodAnnotation(RefreshRequired.class) || handlerClass.getDeclaredAnnotation(RefreshRequired.class) != null) {
            refreshRequired(request);
        }

        return true;
    }

    public static Club currentClub() {
        return (Club) SecurityContextHolder.getContext().getAuthentication().getCredentials();
    }

    private void accessRequired(HttpServletRequest request) {
        setCurrentClub(jwtResolver.parseAccessToken(getToken(request, "Authorization")));
    }

    private void refreshRequired(HttpServletRequest request) {
        setCurrentClub(jwtResolver.parseRefreshToken(getToken(request, "X-Refresh-Token")));
    }

    private String getToken(HttpServletRequest request, String header) {
        String token = request.getHeader(header);
        String JWT_PREFIX = "Bearer ";
        if (token != null && token.startsWith(JWT_PREFIX)) {
            return token.substring(JWT_PREFIX.length());
        }
        return null;
    }

    private void setCurrentClub(Claims claims) {
        Club club = clubRepository.findById(claims.getSubject()).orElseThrow(TokenInvalidException::new);
        SecurityContextHolder.getContext().setAuthentication(new ClubAuthentication(club));
    }
}
