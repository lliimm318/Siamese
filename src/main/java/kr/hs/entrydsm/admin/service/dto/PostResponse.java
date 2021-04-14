package kr.hs.entrydsm.admin.service.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponse {
    private String title;

    private String author;

    private String description;

    private String content;

    private String type;
}
