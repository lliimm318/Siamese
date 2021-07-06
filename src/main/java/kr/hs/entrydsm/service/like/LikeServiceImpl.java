package kr.hs.entrydsm.service.like;

import kr.hs.entrydsm.enitity.Like;
import kr.hs.entrydsm.enitity.Post;
import kr.hs.entrydsm.enitity.repository.LikeRepository;
import kr.hs.entrydsm.enitity.repository.PostRepository;
import kr.hs.entrydsm.payload.response.RecommendPageResponse;
import kr.hs.entrydsm.payload.response.RecommendPostResponse;
import kr.hs.entrydsm.service.exception.PostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    private final PostRepository postRepository;

    @Override
    public void createLike(long postId) {
        String ip = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest().getRemoteAddr();

        likeRepository.findByPostIdAndIp(postId, ip)
                .ifPresent(like -> {throw new PostNotFoundException();});

        Post post = postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        likeRepository.save(
                Like.builder()
                        .ip(ip)
                        .postId(postId)
                        .build()
        );
    }

    @Override
    public RecommendPageResponse bestPostList(Pageable page) {
        Page<Post> likes = postRepository.findByOrderByLikesDesc(page);

        Integer totalPages = likes.getTotalPages();
        Integer totalPost = likes.getNumberOfElements();

        List<RecommendPostResponse> pageResponses = new ArrayList<>();

        for(Post post : likes) {
            pageResponses.add(
                    RecommendPostResponse.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .author(post.getAuthor())
                            .imagePath(post.getImage().getPath())
                            .build()
            );
        }
        return RecommendPageResponse.builder()
                .totalPage(totalPages)
                .totalPosts(totalPost)
                .bestListResponse(pageResponses)
                .build();

    }
}

