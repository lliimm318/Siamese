package kr.hs.entrydsm.controller;

import kr.hs.entrydsm.service.Image.AdminImageService;
import kr.hs.entrydsm.payload.response.ImageResponse;
import kr.hs.entrydsm.security.JWTRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@JWTRequired
@RestController
@RequestMapping("/admin/image")
public class ImageController {
    private final AdminImageService imageService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ImageResponse createImage(@Nullable @RequestParam MultipartFile file) throws IOException {
        return imageService.createImage(Optional.ofNullable(file));
    }
}
