package kr.hs.entrydsm.enitity.repository;

import kr.hs.entrydsm.enitity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminImageRepository extends CrudRepository<Image, Long> {

}
