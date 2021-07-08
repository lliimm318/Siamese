package kr.hs.entrydsm.enitity.repository;

import kr.hs.entrydsm.enitity.Club;
import kr.hs.entrydsm.enitity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllByOrderByCreatedAtDesc();

    List<Post> findAllByClubOrderByCreatedAtDesc(Club club);

    List<Post> findAllByTitleContainsOrContentContainsOrAuthorContainsOrClubNameContainsOrderByCreatedAtDesc
            (String title, String content, String author, String clubName);
}

