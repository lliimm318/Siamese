package kr.hs.entrydsm.admin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
public class LoginRequest {
    @NotEmpty
    private String id;

    @NotEmpty
    private String password;
}
