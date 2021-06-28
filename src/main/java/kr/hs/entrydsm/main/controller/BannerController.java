package kr.hs.entrydsm.main.controller;

import kr.hs.entrydsm.main.payload.response.BannerResponse;
import kr.hs.entrydsm.main.service.banner.BannerListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class BannerController {

    private final BannerListService bannerListService;

    @GetMapping("/banner")
    public List<BannerResponse> getBanners() {

        return bannerListService.getListBannerList();

    }


}
