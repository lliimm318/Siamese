package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.service.dto.BannerRequest;

public interface BannerService {
    public void createBanner(BannerRequest bannerRequest);
    public void deleteBanner(int imageId);
}
