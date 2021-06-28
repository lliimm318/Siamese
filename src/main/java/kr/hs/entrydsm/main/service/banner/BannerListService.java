package kr.hs.entrydsm.main.service.banner;

import kr.hs.entrydsm.main.payload.response.BannerResponse;

import java.util.List;

public interface BannerListService {

    List<BannerResponse> getListBannerList();

}
