package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.entity.Club;
import kr.hs.entrydsm.admin.entity.ClubRepository;
import kr.hs.entrydsm.admin.service.dto.ClubResponse;
import kr.hs.entrydsm.admin.service.dto.LoginRequest;
import kr.hs.entrydsm.admin.service.dto.LoginResponse;
import kr.hs.entrydsm.admin.service.dto.RefreshResponse;
import kr.hs.entrydsm.common.exception.CredentialInvalidException;
import kr.hs.entrydsm.common.security.AuthMiddleware;
import kr.hs.entrydsm.common.security.JWTResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClubServiceImpl implements ClubService {
    private final JWTResolver jwtResolver;

    private final ClubRepository clubRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Club club = clubRepository.findById(loginRequest.getId())
                .filter(user -> passwordEncoder.matches(loginRequest.getPassword(), user.getPassword()))
                .orElseThrow(CredentialInvalidException::new);

        return LoginResponse.builder()
                .accessToken(jwtResolver.generateAccessToken(club.getId()))
                .refreshToken(jwtResolver.generateRefreshToken(club.getId()))
                .build();
    }

    @Override
    public RefreshResponse refresh() {
        return new RefreshResponse(jwtResolver.generateAccessToken(AuthMiddleware.currentClub().getId()));
    }

    @Override
    public ClubResponse getClub() {
        return ClubResponse.builder().name(AuthMiddleware.currentClub().getName()).build();
    }
}
