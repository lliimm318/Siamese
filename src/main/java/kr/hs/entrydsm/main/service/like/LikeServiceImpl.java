package kr.hs.entrydsm.main.service.like;

import kr.hs.entrydsm.common.exception.PostNotFoundException;
import kr.hs.entrydsm.main.enitity.Like;
import kr.hs.entrydsm.main.enitity.Post;
import kr.hs.entrydsm.main.enitity.repository.LikeRepository;
import kr.hs.entrydsm.main.enitity.repository.PostRepository;
import kr.hs.entrydsm.main.payload.response.PageResponse;
import kr.hs.entrydsm.main.payload.response.PostResponse;
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
                        .post(post)
                        .build()
        );
    }

    @Override
    public PageResponse bestPostList(Pageable page) {
        Page<Post> likes = postRepository.findByOrderByLikesDesc(page);

        Integer totalPages = likes.getTotalPages();
        Integer totalPost = likes.getNumberOfElements();

        List<PostResponse> pageResponses = new ArrayList<>();

        for(Post post : likes) {
            pageResponses.add(
                    PostResponse.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .author(post.getAuthor())
                        .image(post.getImage().getId())
                        .type(post.getType())
                        .build()
            );
        }
        return PageResponse.builder()
                    .totalPage(totalPages)
                    .totalPosts(totalPost)
                    .bestListResponse(pageResponses)
                    .build();

    }
}
