package kr.hs.entrydsm.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchResponse {

    private long id;

    private String imagePath;

    private String description;

    private String title;

    private String author;

    private String type;

}
