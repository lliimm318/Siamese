package kr.hs.entrydsm.main.enitity.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import kr.hs.entrydsm.main.enitity.Post;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllBy();

    Page<Post> findByOrderByLikesDesc(Pageable pageable);

}

