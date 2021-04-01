package kr.hs.entrydsm.admin.entity;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    @Override
    @Modifying
    @Query("DELETE FROM tbl_post post WHERE post.id = ?1")
    void deleteById(Long aLong);
}
