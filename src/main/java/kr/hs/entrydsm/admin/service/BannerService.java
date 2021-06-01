package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.BannerRequest;

public interface BannerService {
    void createBanner(BannerRequest bannerRequest);
    void deleteBanner(long imageId);
}
