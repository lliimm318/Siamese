package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.ClubResponse;
import kr.hs.entrydsm.admin.service.dto.LoginRequest;
import kr.hs.entrydsm.admin.service.dto.LoginResponse;
import kr.hs.entrydsm.admin.service.dto.RefreshResponse;

public interface ClubService {
    LoginResponse login(LoginRequest loginRequest);
    RefreshResponse refresh();
    ClubResponse getClub();
}
