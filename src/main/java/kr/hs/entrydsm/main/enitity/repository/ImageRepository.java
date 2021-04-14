package kr.hs.entrydsm.main.enitity.repository;

import kr.hs.entrydsm.main.enitity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Integer> {

}