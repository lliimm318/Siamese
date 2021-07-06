package kr.hs.entrydsm.enitity.repository;

import kr.hs.entrydsm.enitity.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {

    Optional<Like> findByPostIdAndIp(Long postId, String ip);

}