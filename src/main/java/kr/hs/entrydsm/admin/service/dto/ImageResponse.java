package kr.hs.entrydsm.admin.service.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

@Getter
@Builder
public class ImageResponse {
    private String imagePath;
    private long imageId;
}
