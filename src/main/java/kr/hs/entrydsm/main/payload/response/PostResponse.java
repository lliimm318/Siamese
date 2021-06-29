package kr.hs.entrydsm.main.payload.response;

import kr.hs.entrydsm.main.enitity.PostType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private long id;

    private String title;

    private String author;

    private long image;

    private PostType type;

}
