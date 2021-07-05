package kr.hs.entrydsm.controller;

import kr.hs.entrydsm.payload.request.BannerRequest;
import kr.hs.entrydsm.payload.response.BannerResponse;
import kr.hs.entrydsm.security.JWTRequired;
import kr.hs.entrydsm.service.banner.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BannerController {

    private final BannerService bannerService;

    @JWTRequired
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/banner")
    public void createBanner(@Valid @RequestBody BannerRequest bannerRequest) {
        bannerService.createBanner(bannerRequest);
    }

    @JWTRequired
    @DeleteMapping("/banner/{imageId}")
    public void deleteBanner(@PathVariable int postId) {
        bannerService.deleteBanner(postId);
    }

    @GetMapping("/main/banner")
    public List<BannerResponse> getBanners() {

        return bannerService.getBannerList();

    }

}
