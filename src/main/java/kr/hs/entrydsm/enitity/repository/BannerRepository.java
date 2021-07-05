package kr.hs.entrydsm.enitity.repository;

import kr.hs.entrydsm.enitity.Banner;
import kr.hs.entrydsm.payload.response.BannerResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerRepository extends CrudRepository<Banner, Long> {

}
