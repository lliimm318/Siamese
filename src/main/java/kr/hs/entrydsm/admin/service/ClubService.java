package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.LoginRequest;
import kr.hs.entrydsm.admin.service.dto.LoginResponse;
import kr.hs.entrydsm.admin.service.dto.RefreshResponse;

public interface ClubService {
    public LoginResponse login(LoginRequest loginRequest);
    public RefreshResponse refresh(String refreshToken);
}
