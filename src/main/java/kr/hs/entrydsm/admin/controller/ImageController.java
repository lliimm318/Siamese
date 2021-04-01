package kr.hs.entrydsm.admin.controller;

import kr.hs.entrydsm.admin.service.ImageService;
import kr.hs.entrydsm.admin.service.dto.ImageResponse;
import kr.hs.entrydsm.common.security.JWTRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@JWTRequired
@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public ImageResponse createImage(@Nullable @RequestParam MultipartFile file) throws IOException {
        return imageService.createImage(Optional.ofNullable(file));
    }
}
