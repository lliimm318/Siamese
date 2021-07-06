package kr.hs.entrydsm.payload.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RecommendPostResponse {

    private long id;

    private String imagePath;

    private String description;

    private String title;

    private String author;

}
