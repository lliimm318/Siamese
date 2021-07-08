package kr.hs.entrydsm.service.Recommend;

import kr.hs.entrydsm.enitity.Club;
import kr.hs.entrydsm.enitity.repository.ClubRepository;
import kr.hs.entrydsm.enitity.repository.PostRepository;
import kr.hs.entrydsm.payload.response.RecommendResponse;
import kr.hs.entrydsm.service.exception.ClubNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecommendServiceImpl implements RecommendService {

    private final PostRepository postRepository;
    private final ClubRepository clubRepository;
    private static final String id = "entrydsm_init";

    @Override
    public List<RecommendResponse> bestPostList() {

        Club club = clubRepository.findById(id)
                .orElseThrow(ClubNotFoundException::new);

        return postRepository.findAllByClubOrderByCreatedAtDesc(club).stream()
                .map(post -> RecommendResponse.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .author(post.getAuthor())
                        .description(post.getDescription())
                        .imagePath(post.getImage().getPath())
                        .type(post.getType().toString())
                        .build())
                .collect(Collectors.toList());

    }
}

