package kr.hs.entrydsm.service.post;

import kr.hs.entrydsm.payload.response.PostResponse;

import java.util.List;

public interface PostService {

    List<PostResponse> getListPost();

}
