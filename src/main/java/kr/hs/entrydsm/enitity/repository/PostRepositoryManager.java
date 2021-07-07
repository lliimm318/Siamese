package kr.hs.entrydsm.enitity.repository;

import kr.hs.entrydsm.enitity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class PostRepositoryManager {

    private final PostRepository postRepository;

    public List<Post> searchPost(String query) {

        return postRepository.findAllByTitleContainsOrContentContainsOrAuthorContainsOrClubNameContainsOrderByCreatedAtDesc
                (query, query, query, query);
    }
}
