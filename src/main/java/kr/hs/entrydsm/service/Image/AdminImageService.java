package kr.hs.entrydsm.service.Image;

import kr.hs.entrydsm.payload.response.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface AdminImageService {

    ImageResponse createImage(Optional<MultipartFile> file) throws IOException;

}
