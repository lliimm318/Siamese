package kr.hs.entrydsm.enitity.repository;

import kr.hs.entrydsm.enitity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByClubOrderByCreatedAtDesc(String id);

}
