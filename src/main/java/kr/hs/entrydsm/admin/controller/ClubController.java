package kr.hs.entrydsm.admin.controller;

import kr.hs.entrydsm.admin.service.ClubService;
import kr.hs.entrydsm.admin.service.dto.LoginRequest;
import kr.hs.entrydsm.admin.service.dto.LoginResponse;
import kr.hs.entrydsm.admin.service.dto.RefreshResponse;
import kr.hs.entrydsm.common.security.RefreshRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/club")
public class ClubController {
    private final ClubService clubService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        return clubService.login(loginRequest);
    }

    @RefreshRequired
    @PutMapping("/refresh")
    public RefreshResponse refresh() {
        return clubService.refresh();
    }
}
