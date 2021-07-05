package kr.hs.entrydsm.service.post;

import kr.hs.entrydsm.enitity.Post;
import kr.hs.entrydsm.enitity.repository.PostRepository;
import kr.hs.entrydsm.payload.response.PostDetailResponse;
import kr.hs.entrydsm.service.exception.PostNotFoundException;
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
                    .content(post.getContent())
                    .imageId(post.getImageId())
                    .date(post.getCreatedAt())
                    .build();
    }
}
