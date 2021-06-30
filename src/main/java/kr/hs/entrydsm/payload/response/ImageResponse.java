package kr.hs.entrydsm.payload.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ImageResponse {
    private String imagePath;
    private long imageId;
}
