package kr.hs.entrydsm.admin.service;

import kr.hs.entrydsm.admin.entity.Post;
import kr.hs.entrydsm.admin.entity.PostRepository;
import kr.hs.entrydsm.admin.entity.PostType;
import kr.hs.entrydsm.admin.service.dto.PostRequest;
import kr.hs.entrydsm.admin.service.exception.ForbiddenException;
import kr.hs.entrydsm.admin.service.exception.InvalidPostTypeException;
import kr.hs.entrydsm.admin.service.exception.PostNotFoundException;
import kr.hs.entrydsm.common.security.AuthMiddleware;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public void createPost(PostRequest postRequest) {
        postRepository.save(requestToeEntity(postRequest));
    }

    @Override
    @Transactional
    public void deletePost(long postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        System.out.println(post);
        if (!AuthMiddleware.currentClub().getId().equals(post.getClub().getId())) { throw new ForbiddenException(); }
        postRepository.deleteById(post.getId());
    }

    @Override
    public void updatePost(long postId, PostRequest postRequest) {
        Post post = requestToeEntity(postRequest);
        postRepository.findById(postId)
                .map(p -> postRepository.save(p.update(post)))
                .orElseThrow(PostNotFoundException::new);
    }

    private Post requestToeEntity(PostRequest postRequest) {
        try {
            return Post.builder()
                    .club(AuthMiddleware.currentClub())
                    .title(postRequest.getTitle())
                    .author(postRequest.getAuthor())
                    .description(postRequest.getDescription())
                    .content(postRequest.getContent())
                    .type(PostType.valueOf(postRequest.getType()))
                    .createdAt(LocalDateTime.now())
                    .build();
        } catch (IllegalArgumentException e) {
            throw new InvalidPostTypeException();
        }
    }
}
