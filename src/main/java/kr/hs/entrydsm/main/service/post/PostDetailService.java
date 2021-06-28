package kr.hs.entrydsm.main.service.post;

import kr.hs.entrydsm.main.payload.response.PostDetailResponse;

public interface PostDetailService {

  PostDetailResponse getDetailPost(long id);

}
