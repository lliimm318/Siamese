package kr.hs.entrydsm.main.enitity.repository;

import kr.hs.entrydsm.main.enitity.Banner;
import kr.hs.entrydsm.main.payload.response.BannerResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerListRepository extends CrudRepository<Banner, Integer> {

    List<BannerResponse> findAllBy();

}