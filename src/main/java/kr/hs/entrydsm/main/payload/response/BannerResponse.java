package kr.hs.entrydsm.main.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.PositiveOrZero;

@Getter
@Setter
@Builder
public class BannerResponse {

    private String id;

    @PositiveOrZero
    private long imageId;

}
