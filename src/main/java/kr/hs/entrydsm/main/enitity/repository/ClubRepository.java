package kr.hs.entrydsm.main.enitity.repository;

import kr.hs.entrydsm.main.enitity.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends CrudRepository<Club, String> {

}
