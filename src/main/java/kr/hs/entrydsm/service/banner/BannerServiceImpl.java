package kr.hs.entrydsm.service.banner;

import kr.hs.entrydsm.payload.request.BannerRequest;
import kr.hs.entrydsm.payload.response.BannerResponse;
import kr.hs.entrydsm.service.banner.BannerService;
import kr.hs.entrydsm.service.exception.BannerExistException;
import kr.hs.entrydsm.service.exception.BannerNotFoundException;
import kr.hs.entrydsm.service.exception.ForbiddenException;
import kr.hs.entrydsm.service.exception.ImageNotFoundException;
import kr.hs.entrydsm.security.AuthMiddleware;
import kr.hs.entrydsm.enitity.Banner;
import kr.hs.entrydsm.enitity.Club;
import kr.hs.entrydsm.enitity.Image;
import kr.hs.entrydsm.enitity.repository.AdminImageRepository;
import kr.hs.entrydsm.enitity.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<BannerResponse> getBannerList() {
        return bannerRepository.findAllBy().stream()
                .map(bannerList -> BannerResponse.builder()
                        .imageId(bannerList.getImageId())
                        .build())
                .collect(Collectors.toList());
    }
}
