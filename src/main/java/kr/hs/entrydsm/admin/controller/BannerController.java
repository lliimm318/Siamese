package kr.hs.entrydsm.admin.controller;

import kr.hs.entrydsm.admin.service.BannerService;
import kr.hs.entrydsm.admin.service.dto.BannerRequest;
import kr.hs.entrydsm.common.security.JWTRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@JWTRequired
@RestController
@RequestMapping("/banner")
public class BannerController {
    private final BannerService bannerService;

    @PostMapping
    public void createBanner(@Valid @RequestBody BannerRequest bannerRequest) {
        bannerService.createBanner(bannerRequest);
    }

    @DeleteMapping("/{imageId}")
    public void deleteBanner(@PathVariable int imageId) {
        bannerService.deleteBanner(imageId);
    }
}
