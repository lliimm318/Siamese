package kr.hs.entrydsm.service.post;

import kr.hs.entrydsm.enitity.repository.PostRepository;
import kr.hs.entrydsm.payload.response.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostResponse> getListPost() {
        return postRepository.findAllBy().stream()
                    .map(post -> PostResponse.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .author(post.getAuthor())
                            .image(post.getImageId())
                            .type(post.getType().toString())
                            .build())
                    .collect(Collectors.toList());
    }
}

