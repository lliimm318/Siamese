package kr.hs.entrydsm.main.service.post;

import kr.hs.entrydsm.common.exception.PostNotFoundException;
import kr.hs.entrydsm.main.enitity.Post;
import kr.hs.entrydsm.main.enitity.repository.PostRepository;
import kr.hs.entrydsm.main.payload.response.PostDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDetailServiceImpl implements PostDetailService {

    private final PostRepository postRepository;

    @Override
    public PostDetailResponse getDetailPost(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);

        return PostDetailResponse.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .author(post.getAuthor())
                    .description(post.getDescription())
                    .content(post.getContent())
                    .image(post.getImage().getId())
                    .date(post.getCreatedAt())
                    .build();
    }
}
