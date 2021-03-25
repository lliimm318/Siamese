package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.ImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public ImageResponse createImage(MultipartFile file) {
        return null;
    }
}
