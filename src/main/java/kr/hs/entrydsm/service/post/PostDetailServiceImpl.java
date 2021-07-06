package kr.hs.entrydsm.service.post;

import kr.hs.entrydsm.enitity.Image;
import kr.hs.entrydsm.enitity.Post;
import kr.hs.entrydsm.enitity.repository.ImageRepository;
import kr.hs.entrydsm.enitity.repository.PostRepository;
import kr.hs.entrydsm.payload.response.PostDetailResponse;
import kr.hs.entrydsm.service.exception.ImageNotFoundException;
import kr.hs.entrydsm.service.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDetailServiceImpl implements PostDetailService {
    private final PostRepository postRepository;
    private final ImageRepository imageRepository;

    @Override
    public PostDetailResponse getDetailPost(long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(PostNotFoundException::new);
        Image image = imageRepository.findById(post.getImage().getId())
                .orElseThrow(ImageNotFoundException::new);

        return PostDetailResponse.builder()
                    .id(post.getId())
                    .title(post.getTitle())
                    .description(post.getDescription())
                    .author(post.getAuthor())
                    .content(post.getContent())
                    .imagePath(image.getPath())
                    .date(post.getCreatedAt())
                    .build();
    }
}
