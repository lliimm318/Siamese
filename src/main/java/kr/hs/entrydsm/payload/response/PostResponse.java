package kr.hs.entrydsm.payload.response;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponse {

    private long id;

    private long image;

    private String title;

    private String author;

    private String type;
}
