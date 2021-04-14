package kr.hs.entrydsm.main.service.post;

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
    public PostDetailResponse getDetailPost(Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        return PostDetailResponse.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .author(post.getAuthor())
                    .description(post.getDescription())
                    .content(post.getContent())
                    .image(post.getImage().getPath())
                    .date(post.getDate())
                    .build();
    }
}
