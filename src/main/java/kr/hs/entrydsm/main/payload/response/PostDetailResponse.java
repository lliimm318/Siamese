package kr.hs.entrydsm.main.payload.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDetailResponse {

    private long id;

    private String title;

    private String author;

    private String description;

    private String content;

    private long image;

    private LocalDateTime date;

}
