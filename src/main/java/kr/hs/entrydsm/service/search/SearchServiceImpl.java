package kr.hs.entrydsm.service.search;

import kr.hs.entrydsm.enitity.repository.PostRepositoryManager;
import kr.hs.entrydsm.payload.response.SearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final PostRepositoryManager postRepositoryManager;

    @Override
    public List<SearchResponse> searchPostList(String searchWord) {
        return postRepositoryManager.searchPost(searchWord).stream()
                .map(post -> SearchResponse.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .description(post.getDescription())
                        .author(post.getAuthor())
                        .imagePath(post.getImage().getPath())
                        .type(post.getType().toString())
                        .build()
                )
                .collect(Collectors.toList());
    }
}
