package kr.hs.entrydsm.admin.service.dto;

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
