package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface AdminImageService {
    ImageResponse createImage(Optional<MultipartFile> file) throws IOException;
}
