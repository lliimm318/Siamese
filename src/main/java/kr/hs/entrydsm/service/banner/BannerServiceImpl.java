package kr.hs.entrydsm.service.banner;

import kr.hs.entrydsm.enitity.Post;
import kr.hs.entrydsm.enitity.repository.PostRepository;
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
    private final PostRepository postRepository;
    private final BannerRepository bannerRepository;

    @Override
    public void createBanner(BannerRequest bannerRequest) {
        Post post = postRepository.findById(bannerRequest.getPostId()).orElseThrow(ImageNotFoundException::new);
        if (bannerRepository.findById(post.getId()).isPresent()) { throw new BannerExistException(); }
        Club currentClub = AuthMiddleware.currentClub();
        if (!currentClub.getId().equals(post.getClub().getId())) { throw new ForbiddenException(); }
        bannerRepository.save(Banner.builder()
                .postId(post.getId())
                .ttl(bannerRequest.getTtl())
                .build());
    }

    @Override
    public void deleteBanner(long postId) {
        Banner banner = bannerRepository.findById(postId).orElseThrow(BannerNotFoundException::new);
        Post post = postRepository.findById(postId).orElseThrow(ImageNotFoundException::new);
        Club currentClub = AuthMiddleware.currentClub();
        if (!post.getClub().getId().equals(currentClub.getId())) { throw new ForbiddenException(); }
        bannerRepository.delete(banner);
    }

}
