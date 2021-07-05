package kr.hs.entrydsm.service.post;

import kr.hs.entrydsm.enitity.repository.PostRepository;
import kr.hs.entrydsm.payload.response.MainPostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<MainPostResponse> getListPost() {
        return postRepository.findAllBy().stream()
                    .map(post -> MainPostResponse.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .author(post.getAuthor())
                            .image(post.getImageId())
                            .build())
                    .collect(Collectors.toList());
    }
}

