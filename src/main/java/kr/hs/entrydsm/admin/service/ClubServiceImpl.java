package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.LoginRequest;
import kr.hs.entrydsm.admin.service.dto.LoginResponse;
import kr.hs.entrydsm.admin.service.dto.RefreshResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClubServiceImpl implements ClubService {
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }

    @Override
    public RefreshResponse refresh(String refreshToken) {
        return null;
    }
}
