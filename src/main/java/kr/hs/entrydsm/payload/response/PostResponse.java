package kr.hs.entrydsm.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class PostResponse {

    private long id;

    private long image;

    private String title;

    private String author;

    private String description;

    private String content;

    private String type;

}
