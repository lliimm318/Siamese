package kr.hs.entrydsm.main.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PageResponse {

    private Integer totalPosts;

    private Integer totalPage;

    private List<PostResponse> bestListResponse;

}
