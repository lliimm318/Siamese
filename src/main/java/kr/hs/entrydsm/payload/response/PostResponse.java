package kr.hs.entrydsm.payload.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponse {

    private long id;

    private String imagePath;

    private String title;

    private String author;

    private String description;

    private String content;

    private String type;

}
