package kr.hs.entrydsm.admin.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageResponse {
    private String imagePath;
    private int imageId;
}
