package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    public ImageResponse createImage(MultipartFile file);
}
