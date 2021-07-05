package kr.hs.entrydsm.service.banner;

import kr.hs.entrydsm.payload.request.BannerRequest;
import kr.hs.entrydsm.payload.response.BannerResponse;

import java.util.List;

public interface BannerService {

    void createBanner(BannerRequest bannerRequest);

    void deleteBanner(long postId);

    List<BannerResponse> getBannerList();

}
