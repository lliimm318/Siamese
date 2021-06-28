package kr.hs.entrydsm.main.service.post;

import kr.hs.entrydsm.main.payload.response.PostResponse;

import java.util.List;

public interface PostService {

    List<PostResponse> getListPost();

}
