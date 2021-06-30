package kr.hs.entrydsm.service.club;

import kr.hs.entrydsm.payload.response.ClubResponse;
import kr.hs.entrydsm.payload.request.LoginRequest;
import kr.hs.entrydsm.payload.response.LoginResponse;
import kr.hs.entrydsm.payload.response.RefreshResponse;
import kr.hs.entrydsm.exception.CredentialInvalidException;
import kr.hs.entrydsm.security.AuthMiddleware;
import kr.hs.entrydsm.security.JWTResolver;
import kr.hs.entrydsm.enitity.Club;
import kr.hs.entrydsm.enitity.repository.ClubRepository;
import kr.hs.entrydsm.service.club.ClubService;
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
