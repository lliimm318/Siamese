package kr.hs.entrydsm.enitity.repository;

import kr.hs.entrydsm.enitity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("mainImageRepository")
public interface ImageRepository extends CrudRepository<Image, Integer> {

}