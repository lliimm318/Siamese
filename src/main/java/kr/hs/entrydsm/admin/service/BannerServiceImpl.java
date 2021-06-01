package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.entity.*;
import kr.hs.entrydsm.admin.service.dto.BannerRequest;
import kr.hs.entrydsm.admin.service.exception.BannerExistException;
import kr.hs.entrydsm.admin.service.exception.BannerNotFoundException;
import kr.hs.entrydsm.admin.service.exception.ForbiddenException;
import kr.hs.entrydsm.admin.service.exception.ImageNotFoundException;
import kr.hs.entrydsm.common.security.AuthMiddleware;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService {
    private final AdminImageRepository adminImageRepository;
    private final BannerRepository bannerRepository;

    @Override
    public void createBanner(BannerRequest bannerRequest) {
        Image image = adminImageRepository.findById(bannerRequest.getImageId()).orElseThrow(ImageNotFoundException::new);
        if (bannerRepository.findById(image.getId()).isPresent()) { throw new BannerExistException(); }
        Club currentClub = AuthMiddleware.currentClub();
        if (!currentClub.getId().equals(image.getClub().getId())) { throw new ForbiddenException(); }
        bannerRepository.save(Banner.builder()
                .imageId(image.getId())
                .ttl(bannerRequest.getTtl())
                .build());
    }

    @Override
    public void deleteBanner(long imageId) {
        Banner banner = bannerRepository.findById(imageId).orElseThrow(BannerNotFoundException::new);
        Image image = adminImageRepository.findById(imageId).orElseThrow(ImageNotFoundException::new);
        Club currentClub = AuthMiddleware.currentClub();
        if (!image.getClub().getId().equals(currentClub.getId())) { throw new ForbiddenException(); }
        bannerRepository.delete(banner);
    }
}
