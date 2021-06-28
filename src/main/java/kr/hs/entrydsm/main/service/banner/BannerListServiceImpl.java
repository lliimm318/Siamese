package kr.hs.entrydsm.main.service.banner;

import kr.hs.entrydsm.main.enitity.repository.BannerListRepository;
import kr.hs.entrydsm.main.payload.response.BannerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BannerListServiceImpl implements BannerListService{

    private final BannerListRepository bannerListRepository;

    @Override
    public List<BannerResponse> getListBannerList() {

        return bannerListRepository.findAllBy().stream()
                .map(bannerList -> BannerResponse.builder()
                        .imageId(bannerList.getImageId())
                        .build())
                .collect(Collectors.toList());
    }
}
