package kr.hs.entrydsm.service.post;

import kr.hs.entrydsm.payload.response.PostDetailResponse;

public interface PostDetailService {

  PostDetailResponse getDetailPost(long id);

}
