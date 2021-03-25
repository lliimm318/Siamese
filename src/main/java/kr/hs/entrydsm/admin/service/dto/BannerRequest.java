package kr.hs.entrydsm.admin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Pattern;

@Getter
@AllArgsConstructor
public class BannerRequest {
    private String imageId;

    @Pattern(regexp = "/^(19|20)\\d{2}(0[1-9]|1[012])" +
                      "(0[1-9]|[12][0-9]|3[0-1])\\s([1-9]|[01][0-9]|2[0-3])" +
                      ":([0-5][0-9])$/")
    private String expiredAt;
}
