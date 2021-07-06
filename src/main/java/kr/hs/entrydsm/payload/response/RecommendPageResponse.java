package kr.hs.entrydsm.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RecommendPageResponse {

    private Integer totalPosts;

    private Integer totalPage;

    private List<RecommendPostResponse> bestListResponse;

}
