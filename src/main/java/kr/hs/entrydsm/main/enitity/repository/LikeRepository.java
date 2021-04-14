package kr.hs.entrydsm.main.enitity.repository;

import kr.hs.entrydsm.main.enitity.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends CrudRepository<Like, Integer> {
    Optional<Like> findByPostIdAndIp(Integer postId, String ip);
}