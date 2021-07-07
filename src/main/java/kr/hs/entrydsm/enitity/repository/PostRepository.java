package kr.hs.entrydsm.enitity.repository;

import kr.hs.entrydsm.enitity.Club;
import kr.hs.entrydsm.enitity.Post;
import kr.hs.entrydsm.enitity.PostType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllBy();

    List<Post> findByOrderByLikesDesc();

    List<Post> findAllByTitleContainsOrContentContainsOrAuthorContainsOrClubNameContainsOrderByCreatedAtDesc
            (String title, String content, String author, String clubName);
}

