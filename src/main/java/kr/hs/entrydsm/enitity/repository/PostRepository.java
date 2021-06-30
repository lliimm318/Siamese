package kr.hs.entrydsm.enitity.repository;

import kr.hs.entrydsm.enitity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mainRepository")
public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findAllBy();

    Page<Post> findByOrderByLikesDesc(Pageable pageable);

}

