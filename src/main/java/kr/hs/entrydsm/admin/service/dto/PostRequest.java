package kr.hs.entrydsm.admin.service.dto;

import kr.hs.entrydsm.admin.entity.PostType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostRequest {
    private String title;
    private String author;
    private String description;
    private String content;
    private PostType type;
}
