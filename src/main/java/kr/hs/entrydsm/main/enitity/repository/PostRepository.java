package kr.hs.entrydsm.main.enitity.repository;

import kr.hs.entrydsm.main.enitity.Like;
import kr.hs.entrydsm.main.enitity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAllBy();

    List<Post> findAllByTitleContaining(String title); //검색어

    Page<Post> findByOrderByLikesDesc();
}
