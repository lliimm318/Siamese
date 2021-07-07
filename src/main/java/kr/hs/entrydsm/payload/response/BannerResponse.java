package kr.hs.entrydsm.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class BannerResponse {
    List<Long> postIds;
}
