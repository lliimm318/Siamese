package kr.hs.entrydsm.service.club;

import kr.hs.entrydsm.payload.response.ClubResponse;
import kr.hs.entrydsm.payload.request.LoginRequest;
import kr.hs.entrydsm.payload.response.LoginResponse;
import kr.hs.entrydsm.payload.response.RefreshResponse;

public interface ClubService {

    LoginResponse login(LoginRequest loginRequest);

    RefreshResponse refresh();

    ClubResponse getClub();

}
