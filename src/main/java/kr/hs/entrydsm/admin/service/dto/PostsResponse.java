package kr.hs.entrydsm.admin.service.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PostsResponse {
    private List<PostPreviewResponse> posts;
}
