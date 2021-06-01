package kr.hs.entrydsm.main.payload.response;

import kr.hs.entrydsm.main.enitity.PostType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private Integer id;
    private String title;
    private String description;
    private String image;
    private PostType type;
}
