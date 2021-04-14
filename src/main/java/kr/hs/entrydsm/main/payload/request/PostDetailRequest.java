package kr.hs.entrydsm.main.payload.request;

import lombok.Getter;

@Getter
public class PostDetailRequest {
    private String title;
    private String author;
    private String description;
    private String content;

}
