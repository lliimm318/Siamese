package kr.hs.entrydsm.admin.controller;

import kr.hs.entrydsm.admin.service.ImageService;
import kr.hs.entrydsm.admin.service.dto.ImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public ImageResponse createImage(@Valid @RequestParam("file") MultipartFile file) {
        return imageService.createImage(file);
    }
}
