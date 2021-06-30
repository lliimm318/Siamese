package kr.hs.entrydsm.payload.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostPreviewResponse {
    private long postId;
    private String author;
    private String title;
    private String description;
    private LocalDateTime createdAt;
}
