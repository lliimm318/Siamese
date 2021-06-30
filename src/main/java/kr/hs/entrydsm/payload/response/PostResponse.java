package kr.hs.entrydsm.payload.response;

import kr.hs.entrydsm.enitity.PostType;
import lombok.Builder;
import lombok.Getter;

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
